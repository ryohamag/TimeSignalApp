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
fun ClicksoundMenu(
    viewModel : ViewModels
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
            expanded = viewModel.clicksoundMenuExpanded,
            // メニューの外がタップされた時に閉じる
            onDismissRequest = { viewModel.clicksoundMenuExpanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 1
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド１")
                        if (viewModel.selectedClickSound == 1) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 2
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド２")
                        if (viewModel.selectedClickSound == 2) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 3
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド３")
                        if (viewModel.selectedClickSound == 3) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 4
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド４")
                        if (viewModel.selectedClickSound == 4) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 5
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド５")
                        if (viewModel.selectedClickSound == 5) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 6
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド６")
                        if (viewModel.selectedClickSound == 6) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 7
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド７")
                        if (viewModel.selectedClickSound == 7) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 8
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド８")
                        if (viewModel.selectedClickSound == 8) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 9
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド９")
                        if (viewModel.selectedClickSound == 9) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedClickSound = 10
                    viewModel.clicksoundMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "サウンド１０")
                        if (viewModel.selectedClickSound == 10) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                       },
            )
        }
    }
}
