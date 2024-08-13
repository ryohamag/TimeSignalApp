package com.websarva.wings.timesignalapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Density
import com.websarva.wings.timesignalapp.Functions.TextDisplay
import java.util.Calendar

@Composable
fun DateDisplay(density: Density) {
    val currentDate = Calendar.getInstance()
    val year = currentDate.get(Calendar.YEAR)
    val month = currentDate.get(Calendar.MONTH) + 1
    val day = currentDate.get(Calendar.DAY_OF_MONTH)
    val dayOfWeek = currentDate.get(Calendar.DAY_OF_WEEK)

    val dayOfWeekStr = when (dayOfWeek) {
        1 -> "日曜日"
        2 -> "月曜日"
        3 -> "火曜日"
        4 -> "水曜日"
        5 -> "木曜日"
        6 -> "金曜日"
        7 -> "土曜日"
        else -> ""
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextDisplay(text = year.toString(), fontSize = 40, density = density)
        TextDisplay(text = "年", fontSize = 40, density = density)
        TextDisplay(text = month.toString(), fontSize = 40, density = density)
        TextDisplay(text = "月", fontSize = 40, density = density)
        TextDisplay(text = day.toString(), fontSize = 40, density = density)
        TextDisplay(text = "日", fontSize = 40, density = density)
        TextDisplay(text = dayOfWeekStr, fontSize = 40, density = density)
    }
}