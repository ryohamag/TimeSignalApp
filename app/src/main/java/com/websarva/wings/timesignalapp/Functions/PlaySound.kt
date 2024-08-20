package com.websarva.wings.timesignalapp.Functions

import android.content.Context
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.websarva.wings.timesignalapp.R

fun readTime(
    context: Context,
    am_pm: Int,
    hour: Int,
    min: Int,
    second: Int,
    soundPool: SoundPool
) {
    val soundIdsToLoad = listOf(
        if (am_pm == 0) R.raw.zunda_am else R.raw.zunda_pm,
        when (hour) {
            0 -> R.raw.zunda_0h
            1 -> R.raw.zunda_1h
            2 -> R.raw.zunda_2h
            3 -> R.raw.zunda_3h
            4 -> R.raw.zunda_4h
            5 -> R.raw.zunda_5h
            6 -> R.raw.zunda_6h
            7 -> R.raw.zunda_7h
            8 -> R.raw.zunda_8h
            9 -> R.raw.zunda_9h
            10 -> R.raw.zunda_10h
            11 -> R.raw.zunda_11h
            12 -> R.raw.zunda_12h
            else -> throw IllegalArgumentException("Invalid hour: $hour")
        },
        arrayOf(
            R.raw.zunda_0m, R.raw.zunda_1m, R.raw.zunda_2m, R.raw.zunda_3m,
            R.raw.zunda_4m, R.raw.zunda_5m, R.raw.zunda_6m, R.raw.zunda_7m,
            R.raw.zunda_8m, R.raw.zunda_9m, R.raw.zunda_10m, R.raw.zunda_11m,
            R.raw.zunda_12m, R.raw.zunda_13m, R.raw.zunda_14m, R.raw.zunda_15m,
            R.raw.zunda_16m, R.raw.zunda_17m, R.raw.zunda_18m, R.raw.zunda_19m,
            R.raw.zunda_20m, R.raw.zunda_21m, R.raw.zunda_22m, R.raw.zunda_23m,
            R.raw.zunda_24m, R.raw.zunda_25m, R.raw.zunda_26m, R.raw.zunda_27m,
            R.raw.zunda_28m, R.raw.zunda_29m, R.raw.zunda_30m, R.raw.zunda_31m,
            R.raw.zunda_32m, R.raw.zunda_33m, R.raw.zunda_34m, R.raw.zunda_35m,
            R.raw.zunda_36m, R.raw.zunda_37m, R.raw.zunda_38m, R.raw.zunda_39m,
            R.raw.zunda_40m, R.raw.zunda_41m, R.raw.zunda_42m, R.raw.zunda_43m,
            R.raw.zunda_44m, R.raw.zunda_45m, R.raw.zunda_46m, R.raw.zunda_47m,
            R.raw.zunda_48m, R.raw.zunda_49m, R.raw.zunda_50m, R.raw.zunda_51m,
            R.raw.zunda_52m, R.raw.zunda_53m, R.raw.zunda_54m, R.raw.zunda_55m,
            R.raw.zunda_56m, R.raw.zunda_57m, R.raw.zunda_58m, R.raw.zunda_59m
        )[min],
        when (second) {
            in 0..9 -> R.raw.zunda_10s
            in 10..19 -> R.raw.zunda_20s
            in 20..29 -> R.raw.zunda_30s
            in 30..39 -> R.raw.zunda_40s
            in 40..49 -> R.raw.zunda_50s
            in 50..59 -> R.raw.zunda_0s
            else -> throw IllegalArgumentException("Invalid second: $second")
        },
        R.raw.zunda_inform
    )

    val soundIds = mutableListOf<Int>()
    val soundDurations = mutableListOf<Int>()
    val loadCompleteListener = SoundPool.OnLoadCompleteListener { _, sampleId, status ->
        if (status == 0) {
            soundIds.add(sampleId)
            if (soundIds.size == soundIdsToLoad.size) {
                // 全てのサウンドが読み込まれたら再生時間を取得
                soundIdsToLoad.forEach { resId ->
                    val afd = context.resources.openRawResourceFd(resId)
                    val mp = MediaPlayer()
                    mp.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                    mp.prepare()
                    soundDurations.add(mp.duration)
                    mp.release()
                    afd.close()
                }
                // 再生開始
                playSoundsSequentially(soundPool, soundIds, soundDurations)
            }
        } else {
            Log.e("SoundPool", "Failed to load sound with sampleId: $sampleId")
        }
    }
    soundPool.setOnLoadCompleteListener(loadCompleteListener)

    soundIdsToLoad.forEach { soundPool.load(context, it, 1) }
}

private fun playSoundsSequentially(soundPool: SoundPool, soundIds: List<Int>, soundDurations: List<Int>) {
    var currentIndex = 0

    fun playNext() {
        if (currentIndex < soundIds.size) {
            val duration = soundDurations[currentIndex]
            val streamId = soundPool.play(soundIds[currentIndex], 0.2f, 0.2f, 0, 0, 1.0f)
            currentIndex++
            Handler(Looper.getMainLooper()).postDelayed({ playNext() }, duration.toLong())
        }
    }

    playNext()
}

