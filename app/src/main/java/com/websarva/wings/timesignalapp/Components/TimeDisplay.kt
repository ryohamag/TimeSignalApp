package com.websarva.wings.timesignalapp.Components

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Density
import com.websarva.wings.timesignalapp.Functions.TextDisplay
import com.websarva.wings.timesignalapp.Functions.readTime
import com.websarva.wings.timesignalapp.R
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun TimeDisplay(context: Context, density: Density) {

    val audioAttributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_ALARM)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()

    val soundpool = SoundPool.Builder()
        .setAudioAttributes(audioAttributes)
        .setMaxStreams(4)
        .build()

    //クリック音のロード
    val clickSound = soundpool.load(context, R.raw.testsound, 1)

    //3秒カウント
    val count3Sound = soundpool.load(context, R.raw.count3, 1)

    //10秒カウント
    val count10s = soundpool.load(context, R.raw.count10s, 1)

    val calendar = Calendar.getInstance()
    var hour by remember { mutableStateOf(calendar.get(Calendar.HOUR_OF_DAY).toString()) }
    var min by remember { mutableStateOf(calendar.get(Calendar.MINUTE).toString()) }
    var second by remember { mutableStateOf(calendar.get(Calendar.SECOND).toString()) }

    LaunchedEffect(true) {
        while (true) {
            soundpool.play(clickSound, 0.2f, 0.2f, 0, 0, 1.0f)

            // 1秒ごとに実行する
            delay(1000)

            val calendar = Calendar.getInstance()
            // 時間(hh)
            hour = zeroFillFormat(calendar.get(Calendar.HOUR_OF_DAY).toString())
            // 時間(mm)
            min = zeroFillFormat(calendar.get(Calendar.MINUTE).toString())
            // 時間(ss)
            second = zeroFillFormat(calendar.get(Calendar.SECOND).toString())

            // 10秒ごとにreadTimeを呼び出す
            if (calendar.get(Calendar.SECOND) % 10 == 1) {
                readTime(
                    context,
                    calendar.get(Calendar.AM_PM),
                    calendar.get(Calendar.HOUR),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    soundpool
                )
            }

            //10秒ごとのカウント
            if (calendar.get(Calendar.SECOND) == 10 || calendar.get(Calendar.SECOND) == 20 || calendar.get(Calendar.SECOND) == 40 || calendar.get(Calendar.SECOND) == 50) {
                soundpool.play(count10s, 0.2f, 0.2f, 0, 0, 1.0f)
            }

            //30,60秒前のカウント
            if (calendar.get(Calendar.SECOND) == 26 || calendar.get(Calendar.SECOND) == 56) {
                soundpool.play(count3Sound, 0.2f, 0.2f, 0, 0, 1.0f)
            }
        }
    }

    // レイアウト
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextDisplay(text = hour, fontSize = 100, density = density)
        TextDisplay(text = ":", fontSize = 100, density = density)
        TextDisplay(text = min, fontSize = 100, density = density)
        TextDisplay(text = ":", fontSize = 100, density = density)
        TextDisplay(text = second, fontSize = 100, density = density)
    }

}

/**
 * １桁だった場合頭に0を追加する
 *
 * @param time 時間
 */
private fun zeroFillFormat(time: String): String {
    return time.padStart(2, '0')
}