package com.websarva.wings.timesignalapp.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.websarva.wings.timesignalapp.R
import com.websarva.wings.timesignalapp.ViewModels

@Composable
fun MainScreen(
    viewModel : ViewModels = ViewModels()
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { viewModel.clicksoundMenuExpanded = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_music_note_24),
                                contentDescription = "クリック音の設定")
                            if (viewModel.clicksoundMenuExpanded) {
                                ClicksoundMenu(viewModel)
                            }
                        }
                        IconButton(onClick = { viewModel.characterMenuExpanded = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.outline_voice_selection_24),
                                contentDescription = "ナレーターの設定",
                            )
                            if (viewModel.characterMenuExpanded) {
                                CharacterMenu(viewModel)
                            }
                        }
                        IconButton(onClick = { viewModel.colorMenuExpanded = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_palette_24),
                                contentDescription = "文字色の設定",
                            )
                            if (viewModel.colorMenuExpanded) {
                                ColorMenu(viewModel)
                            }
                        }
                        IconButton(onClick = { viewModel.fontMenuExpanded = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_font_download_24),
                                contentDescription = "Localized description",
                            )
                            if (viewModel.fontMenuExpanded) {
                                FontMenu(viewModel)
                            }
                        }
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp)

        ) {
            val context = LocalContext.current
            val density = LocalDensity.current

            DateDisplay(density, viewModel)

            Spacer(modifier = Modifier.height(20.dp))

            TimeDisplay(context, density, viewModel)
        }
    }
}