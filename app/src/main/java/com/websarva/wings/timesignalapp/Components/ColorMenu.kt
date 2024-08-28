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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.ViewModels

@Composable
fun ColorMenu(
    viewModel: ViewModels
) {
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        DropdownMenu(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .heightIn(max = 240.dp),
            expanded = viewModel.colorMenuExpanded,
            onDismissRequest = { viewModel.colorMenuExpanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Red
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "レッド")
                        if (viewModel.selectedColor == Color.Red) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Magenta
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "マゼンタ")
                        if (viewModel.selectedColor == Color.Magenta) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Blue
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ブルー")
                        if (viewModel.selectedColor == Color.Blue) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Cyan
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "シアン")
                        if (viewModel.selectedColor == Color.Cyan) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Green
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "グリーン")
                        if (viewModel.selectedColor == Color.Green) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Black
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ブラック")
                        if (viewModel.selectedColor == Color.Black) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.Gray
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "グレー")
                        if (viewModel.selectedColor == Color.Gray) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedColor = Color.DarkGray
                    viewModel.colorMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ダークグレー")
                        if (viewModel.selectedColor == Color.DarkGray) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
        }
    }
}

