package com.websarva.wings.timesignalapp.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.websarva.wings.timesignalapp.Functions.playSound

@Composable
fun MainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val context = LocalContext.current
        Button(
            onClick = { playSound(context) }
        ) {
            Text(text = "音を鳴らす")
        }
    }

}