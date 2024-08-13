package com.websarva.wings.timesignalapp.Components

import android.content.Context
import android.media.MediaPlayer
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
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.testsound) } //音声ファイルのインスタンス作成

    val calendar = Calendar.getInstance()
    var hour by remember { mutableStateOf(calendar.get(Calendar.HOUR_OF_DAY).toString()) }
    var min by remember { mutableStateOf(calendar.get(Calendar.MINUTE).toString()) }
    var second by remember { mutableStateOf(calendar.get(Calendar.SECOND).toString()) }

    LaunchedEffect(true) {
        while (true) {
            // 音を再生
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }

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
                    calendar.get(Calendar.SECOND)
                )
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

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
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

