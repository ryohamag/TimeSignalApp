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
fun FontMenu(
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
            expanded = viewModel.fontMenuExpanded,
            onDismissRequest = { viewModel.fontMenuExpanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 0
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Default")
                        if (viewModel.selectedFontNumber == 0) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 1
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Noto Sans Japanese")
                        if (viewModel.selectedFontNumber == 1) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 2
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Roboto")
                        if (viewModel.selectedFontNumber == 2) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 3
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Montserrat")
                        if (viewModel.selectedFontNumber == 3) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 4
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Open Sans")
                        if (viewModel.selectedFontNumber == 4) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 5
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Playfair Display")
                        if (viewModel.selectedFontNumber == 5) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
            DropdownMenuItem(
                onClick = {
                    viewModel.selectedFontNumber = 6
                    viewModel.fontMenuExpanded = false
                },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "New Amsterdam")
                        if (viewModel.selectedFontNumber == 6) {
                            Icon(Icons.Default.Check, contentDescription = null)
                        }
                    }
                },
            )
        }
    }
}