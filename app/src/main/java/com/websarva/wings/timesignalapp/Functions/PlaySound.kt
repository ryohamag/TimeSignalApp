package com.websarva.wings.timesignalapp.Functions

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import com.websarva.wings.timesignalapp.R

fun playSound(context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.testsound)
    mediaPlayer.start()
    Log.d("playSound", "音を鳴らしました")
}