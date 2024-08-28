package com.websarva.wings.timesignalapp.Components

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
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
import com.websarva.wings.timesignalapp.ViewModels
import kotlinx.coroutines.delay
import java.util.Calendar

@Composable
fun TimeDisplay(context: Context, density: Density, viewModel: ViewModels) {

    val audioAttributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_ALARM)
        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
        .build()

    val soundpool = remember {
        SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(4)
            .build()
    }

    var clickSound by remember { mutableStateOf(0) }

    LaunchedEffect(viewModel.selectedClickSound) {
        // クリック音のロード
        val newClickSound = when (viewModel.selectedClickSound) {
            1 -> soundpool.load(context, R.raw.clicksound1, 1)
            2 -> soundpool.load(context, R.raw.clicksound2, 1)
            3 -> soundpool.load(context, R.raw.clicksound3, 1)
            4 -> soundpool.load(context, R.raw.clicksound4, 1)
            5 -> soundpool.load(context, R.raw.clicksound5, 1)
            6 -> soundpool.load(context, R.raw.clicksound6, 1)
            7 -> soundpool.load(context, R.raw.clicksound7, 1)
            8 -> soundpool.load(context, R.raw.clicksound8, 1)
            9 -> soundpool.load(context, R.raw.clicksound9, 1)
            10 -> soundpool.load(context, R.raw.clicksound10, 1)
            else -> soundpool.load(context, R.raw.clicksound1, 1)
        }

        soundpool.setOnLoadCompleteListener { _, sampleId, _ ->
            if (sampleId == newClickSound) {
                clickSound = newClickSound
                viewModel.clickSound = newClickSound
                Log.d("clicksound", "clickSound loaded: $clickSound")
            }
        }

        Log.d("selectedClicksound", "selectedClickSound: ${viewModel.selectedClickSound}")
    }

    //3秒カウント
    val count3Sound = remember { mutableStateOf(soundpool.load(context, R.raw.count3, 1)) }

    //10秒カウント
    val count10s = remember { mutableStateOf(soundpool.load(context, R.raw.count10s, 1)) }

    val calendar = Calendar.getInstance()
    var hour by remember { mutableStateOf(calendar.get(Calendar.HOUR_OF_DAY).toString()) }
    var min by remember { mutableStateOf(calendar.get(Calendar.MINUTE).toString()) }
    var second by remember { mutableStateOf(calendar.get(Calendar.SECOND).toString()) }

    LaunchedEffect(Unit) {
        while (true) {
            if (clickSound != 0) {
                soundpool.play(clickSound, 0.2f, 0.2f, 0, 0, 1.0f)
            }

            // 1秒ごとに実行する
            delay(1000)

            val current = Calendar.getInstance()
            // 時間(hh)
            hour = zeroFillFormat(current.get(Calendar.HOUR_OF_DAY).toString())
            // 時間(mm)
            min = zeroFillFormat(current.get(Calendar.MINUTE).toString())
            // 時間(ss)
            second = zeroFillFormat(current.get(Calendar.SECOND).toString())

            // 10秒ごとにreadTimeを呼び出す
            if (current.get(Calendar.SECOND) % 10 == 1) {
                readTime(
                    context,
                    current.get(Calendar.AM_PM),
                    current.get(Calendar.HOUR),
                    current.get(Calendar.MINUTE),
                    current.get(Calendar.SECOND),
                    soundpool,
                    viewModel
                )
            }

            //10秒ごとのカウント
            if (current.get(Calendar.SECOND) == 10 || current.get(Calendar.SECOND) == 20 || current.get(Calendar.SECOND) == 40 || current.get(Calendar.SECOND) == 50) {
                soundpool.play(count10s.value, 0.2f, 0.2f, 0, 0, 1.0f)
            }

            //30,60秒前のカウント
            if (current.get(Calendar.SECOND) == 26 || current.get(Calendar.SECOND) == 56) {
                soundpool.play(count3Sound.value, 0.2f, 0.2f, 0, 0, 1.0f)
            }
        }
    }

    // レイアウト
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextDisplay(text = hour, fontSize = 100, density = density, viewModel)
        TextDisplay(text = ":", fontSize = 100, density = density, viewModel)
        TextDisplay(text = min, fontSize = 100, density = density, viewModel)
        TextDisplay(text = ":", fontSize = 100, density = density, viewModel)
        TextDisplay(text = second, fontSize = 100, density = density, viewModel)
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