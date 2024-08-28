package com.websarva.wings.timesignalapp.Functions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.R
import com.websarva.wings.timesignalapp.ViewModels

@Composable
fun TextDisplay(text: String, fontSize: Int, density: Density, viewModel: ViewModels) {
    val selectedFont = when (viewModel.selectedFontNumber) {
        1 -> R.font.noto_sans_jp
        2 -> R.font.roboto
        3 -> R.font.montserrat
        4 -> R.font.open_sans
        5 -> R.font.playfair_display
        6 -> R.font.new_amsterdam
        else -> null
    }

    val fontFamily = if (selectedFont != null) {
        FontFamily(Font(resId = selectedFont))
    } else {
        FontFamily.Default
    }

    Text(
        text = text,
        fontSize = with(density) { fontSize.dp.toSp() },
        fontWeight = FontWeight.Bold,
        color = viewModel.selectedColor,
        fontFamily = fontFamily
    )
}