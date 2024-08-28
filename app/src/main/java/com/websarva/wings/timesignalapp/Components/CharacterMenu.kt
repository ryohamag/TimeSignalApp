package com.websarva.wings.timesignalapp.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.ViewModels

@Composable
fun CharacterMenu(
    viewModel: ViewModels
) {
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        DropdownMenu(
            modifier = Modifier
                // タップされた時の背景を円にする
                .clip(RoundedCornerShape(16.dp))
                .heightIn(max = 240.dp),
            expanded = viewModel.characterMenuExpanded,
            // メニューの外がタップされた時に閉じる
            onDismissRequest = { viewModel.characterMenuExpanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedCharacter = "zundamon"
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ずんだもん")
                        if (viewModel.selectedCharacter == "zundamon") {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedCharacter = "metan"
                    viewModel.characterMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "四国めたん")
                        if (viewModel.selectedCharacter == "metan") {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
        }
    }
}
