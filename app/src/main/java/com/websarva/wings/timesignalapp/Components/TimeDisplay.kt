package com.websarva.wings.timesignalapp.Components

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.Functions.playSound
import com.websarva.wings.timesignalapp.R
import kotlinx.coroutines.delay
import java.util.Calendar


private enum class TimeTable(val id: Int) {
    AM(0),
    PM(1)
}

/**
 * １桁だった場合頭に0を追加する
 *
 * @param time 時間
 */
private fun zeroFillFormat(time: String): String {
    return time.padStart(2, '0')
}

/**
 * 24時間表記にする
 *
 * @param am_pm amかpmの数値
 * @param hour 時間(hh)
 */
private fun changeTimeTable(am_pm: Int, hour: Int): String {
    if (TimeTable.PM.id == am_pm) {
        // PMだった場合変換する
        return when (hour) {
            0 -> "12"
            1 -> "13"
            2 -> "14"
            3 -> "15"
            4 -> "16"
            5 -> "17"
            6 -> "18"
            7 -> "19"
            8 -> "20"
            9 -> "21"
            10 -> "22"
            11 -> "23"
            else -> hour.toString()
        }
    }
    return hour.toString()
}

@Composable
fun TimeDisplay(context: Context) {
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
            hour = zeroFillFormat(
                changeTimeTable(
                    calendar.get(Calendar.AM_PM),
                    calendar.get(Calendar.HOUR_OF_DAY)
                )
            )
            // 時間(mm)
            min = zeroFillFormat(calendar.get(Calendar.MINUTE).toString())
            // 時間(ss)
            second = zeroFillFormat(calendar.get(Calendar.SECOND).toString())
        }
    }
    val density = LocalDensity.current
    // レイアウト
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = hour, fontSize = with(density) { 60.dp.toSp() }, fontWeight = FontWeight.Bold, color = Color.Blue)
        Text(text = " : ", fontSize = with(density) { 60.dp.toSp() }, fontWeight = FontWeight.Bold,color = Color.Blue)
        Text(text = min, fontSize = with(density) { 60.dp.toSp() }, fontWeight = FontWeight.Bold, color = Color.Blue)
        Text(text = " : ", fontSize = with(density) { 60.dp.toSp() }, fontWeight = FontWeight.Bold, color = Color.Blue)
        Text(text = second, fontSize = with(density) { 60.dp.toSp() }, fontWeight = FontWeight.Bold, color = Color.Blue)
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}