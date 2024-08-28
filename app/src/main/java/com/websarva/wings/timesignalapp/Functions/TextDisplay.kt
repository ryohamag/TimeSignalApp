package com.websarva.wings.timesignalapp.Functions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

@Composable
fun TextDisplay(text: String, fontSize: Int, density: Density) {
    Text(
        text = text,
        fontSize = with(density) { fontSize.dp.toSp() },
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}