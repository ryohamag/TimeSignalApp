package com.websarva.wings.timesignalapp.Functions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.ViewModels

@Composable
fun TextDisplay(text: String, fontSize: Int, density: Density, viewModel: ViewModels) {
    Text(
        text = text,
        fontSize = with(density) { fontSize.dp.toSp() },
        fontWeight = FontWeight.Bold,
        color = viewModel.selectedColor,
    )
}