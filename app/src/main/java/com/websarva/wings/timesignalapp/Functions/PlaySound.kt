package com.websarva.wings.timesignalapp.Functions

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import com.websarva.wings.timesignalapp.R
import kotlinx.coroutines.delay

fun playSound(context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.testsound)
    mediaPlayer.start()
}