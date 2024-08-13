package com.websarva.wings.timesignalapp.Functions

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import com.websarva.wings.timesignalapp.R
import kotlinx.coroutines.delay

//fun readTime(
//    context: Context,
//    am_pm: Int,
//    hour: Int,
//    min: Int,
//    second: Int
//) {
//    val mediaPlayers = mutableListOf<MediaPlayer?>()
//
//    val mediaPlayer: MediaPlayer? = when (am_pm) {
//        0 -> MediaPlayer.create(context, R.raw.zunda_am)
//        else -> MediaPlayer.create(context, R.raw.zunda_pm)
//    }
//
//    mediaPlayers.add(mediaPlayer)
//
////    mediaPlayer?.let {
////        it.setOnCompletionListener { mp ->
////            mp.release()  // メモリを解放
////        }
////        it.start()
////    }
//
//    //hourの読み上げ
//    val readHour: MediaPlayer? = when (hour) {
//        0 -> MediaPlayer.create(context, R.raw.zunda_0h)
//        1 -> MediaPlayer.create(context, R.raw.zunda_1h)
//        2 -> MediaPlayer.create(context, R.raw.zunda_2h)
//        3 -> MediaPlayer.create(context, R.raw.zunda_3h)
//        4 -> MediaPlayer.create(context, R.raw.zunda_4h)
//        5 -> MediaPlayer.create(context, R.raw.zunda_5h)
//        6 -> MediaPlayer.create(context, R.raw.zunda_6h)
//        7 -> MediaPlayer.create(context, R.raw.zunda_7h)
//        8 -> MediaPlayer.create(context, R.raw.zunda_8h)
//        9 -> MediaPlayer.create(context, R.raw.zunda_9h)
//        10 -> MediaPlayer.create(context, R.raw.zunda_10h)
//        11 -> MediaPlayer.create(context, R.raw.zunda_11h)
//        12 -> MediaPlayer.create(context, R.raw.zunda_12h)
//        else -> null
//    }
//
//    mediaPlayers.add(readHour)
//
////    readHour?.let {
////        it.setOnCompletionListener { mp ->
////            mp.release()  // メモリを解放
////        }
////        it.start()
////    }
//
//    //minの読み上げ
//    val readMin: MediaPlayer? = when (min) {
//        0 -> MediaPlayer.create(context, R.raw.zunda_0m)
//        1 -> MediaPlayer.create(context, R.raw.zunda_1m)
//        2 -> MediaPlayer.create(context, R.raw.zunda_2m)
//        3 -> MediaPlayer.create(context, R.raw.zunda_3m)
//        4 -> MediaPlayer.create(context, R.raw.zunda_4m)
//        5 -> MediaPlayer.create(context, R.raw.zunda_5m)
//        6 -> MediaPlayer.create(context, R.raw.zunda_6m)
//        7 -> MediaPlayer.create(context, R.raw.zunda_7m)
//        8 -> MediaPlayer.create(context, R.raw.zunda_8m)
//        9 -> MediaPlayer.create(context, R.raw.zunda_9m)
//        10 -> MediaPlayer.create(context, R.raw.zunda_10m)
//        11 -> MediaPlayer.create(context, R.raw.zunda_11m)
//        12 -> MediaPlayer.create(context, R.raw.zunda_12m)
//        13 -> MediaPlayer.create(context, R.raw.zunda_13m)
//        14 -> MediaPlayer.create(context, R.raw.zunda_14m)
//        15 -> MediaPlayer.create(context, R.raw.zunda_15m)
//        16 -> MediaPlayer.create(context, R.raw.zunda_16m)
//        17 -> MediaPlayer.create(context, R.raw.zunda_17m)
//        18 -> MediaPlayer.create(context, R.raw.zunda_18m)
//        19 -> MediaPlayer.create(context, R.raw.zunda_19m)
//        20 -> MediaPlayer.create(context, R.raw.zunda_20m)
//        21 -> MediaPlayer.create(context, R.raw.zunda_21m)
//        22 -> MediaPlayer.create(context, R.raw.zunda_22m)
//        23 -> MediaPlayer.create(context, R.raw.zunda_23m)
//        24 -> MediaPlayer.create(context, R.raw.zunda_24m)
//        25 -> MediaPlayer.create(context, R.raw.zunda_25m)
//        26 -> MediaPlayer.create(context, R.raw.zunda_26m)
//        27 -> MediaPlayer.create(context, R.raw.zunda_27m)
//        28 -> MediaPlayer.create(context, R.raw.zunda_28m)
//        29 -> MediaPlayer.create(context, R.raw.zunda_29m)
//        30 -> MediaPlayer.create(context, R.raw.zunda_30m)
//        31 -> MediaPlayer.create(context, R.raw.zunda_31m)
//        32 -> MediaPlayer.create(context, R.raw.zunda_32m)
//        33 -> MediaPlayer.create(context, R.raw.zunda_33m)
//        34 -> MediaPlayer.create(context, R.raw.zunda_34m)
//        35 -> MediaPlayer.create(context, R.raw.zunda_35m)
//        36 -> MediaPlayer.create(context, R.raw.zunda_36m)
//        37 -> MediaPlayer.create(context, R.raw.zunda_37m)
//        38 -> MediaPlayer.create(context, R.raw.zunda_38m)
//        39 -> MediaPlayer.create(context, R.raw.zunda_39m)
//        40 -> MediaPlayer.create(context, R.raw.zunda_40m)
//        41 -> MediaPlayer.create(context, R.raw.zunda_41m)
//        42 -> MediaPlayer.create(context, R.raw.zunda_42m)
//        43 -> MediaPlayer.create(context, R.raw.zunda_43m)
//        44 -> MediaPlayer.create(context, R.raw.zunda_44m)
//        45 -> MediaPlayer.create(context, R.raw.zunda_45m)
//        46 -> MediaPlayer.create(context, R.raw.zunda_46m)
//        47 -> MediaPlayer.create(context, R.raw.zunda_47m)
//        48 -> MediaPlayer.create(context, R.raw.zunda_48m)
//        49 -> MediaPlayer.create(context, R.raw.zunda_49m)
//        50 -> MediaPlayer.create(context, R.raw.zunda_50m)
//        51 -> MediaPlayer.create(context, R.raw.zunda_51m)
//        52 -> MediaPlayer.create(context, R.raw.zunda_52m)
//        53 -> MediaPlayer.create(context, R.raw.zunda_53m)
//        54 -> MediaPlayer.create(context, R.raw.zunda_54m)
//        55 -> MediaPlayer.create(context, R.raw.zunda_55m)
//        56 -> MediaPlayer.create(context, R.raw.zunda_56m)
//        57 -> MediaPlayer.create(context, R.raw.zunda_57m)
//        58 -> MediaPlayer.create(context, R.raw.zunda_58m)
//        59 -> MediaPlayer.create(context, R.raw.zunda_59m)
//        else -> null
//    }
//    mediaPlayers.add(readMin)
//
////    readMin?.let {
////        it.setOnCompletionListener { mp ->
////            mp.release()  // メモリを解放
////        }
////        it.start()
////    }
//
//    //secondの読み上げ
//    val readSecond: MediaPlayer? = when (second) {
//        in 0..9 -> MediaPlayer.create(context, R.raw.zunda_10s)
//        in 10..19 -> MediaPlayer.create(context, R.raw.zunda_20s)
//        in 20..29 -> MediaPlayer.create(context, R.raw.zunda_30s)
//        in 30..39 -> MediaPlayer.create(context, R.raw.zunda_40s)
//        in 40..49 -> MediaPlayer.create(context, R.raw.zunda_50s)
//        in 50..59 -> MediaPlayer.create(context, R.raw.zunda_0s)
//        else -> null
//    }
//    mediaPlayers.add(readSecond)
//
////    readSecond?.let {
////        it.setOnCompletionListener { mp ->
////            mp.release()  // メモリを解放
////        }
////        it.start()
////    }
//
//    //「お知らせします。」の読み上げ
//    val readInfo = MediaPlayer.create(context, R.raw.zunda_inform)
//    mediaPlayers.add(readInfo)
////    readInfo.setOnCompletionListener { mp ->
////        mp.release()  // メモリを解放
////    }
////    readInfo.start()
//
//    // 順番に再生するためのリスナー設定
//    for (i in 0 until mediaPlayers.size - 1) {
//        mediaPlayers[i]?.setOnCompletionListener { mp ->
//            mp.release()
//            mediaPlayers[i + 1]?.start()
//        }
//    }
//
//    // 最後のプレーヤーのリスナー設定
//    mediaPlayers.last()?.setOnCompletionListener { mp ->
//        mp.release()
//    }
//
//    // 最初のプレーヤーを再生開始
//    mediaPlayers.first()?.start()
//}

fun readTime(
    context: Context,
    am_pm: Int,
    hour: Int,
    min: Int,
    second: Int
) {
    val mediaPlayers = mutableListOf<MediaPlayer>()

    val amPmPlayer = when (am_pm) {
        0 -> MediaPlayer.create(context, R.raw.zunda_am)
        else -> MediaPlayer.create(context, R.raw.zunda_pm)
    }

    if (amPmPlayer != null) {
        mediaPlayers.add(amPmPlayer)
    }

    // hourの読み上げ
    val readHour = when (hour) {
        0 -> MediaPlayer.create(context, R.raw.zunda_0h)
        1 -> MediaPlayer.create(context, R.raw.zunda_1h)
        2 -> MediaPlayer.create(context, R.raw.zunda_2h)
        3 -> MediaPlayer.create(context, R.raw.zunda_3h)
        4 -> MediaPlayer.create(context, R.raw.zunda_4h)
        5 -> MediaPlayer.create(context, R.raw.zunda_5h)
        6 -> MediaPlayer.create(context, R.raw.zunda_6h)
        7 -> MediaPlayer.create(context, R.raw.zunda_7h)
        8 -> MediaPlayer.create(context, R.raw.zunda_8h)
        9 -> MediaPlayer.create(context, R.raw.zunda_9h)
        10 -> MediaPlayer.create(context, R.raw.zunda_10h)
        11 -> MediaPlayer.create(context, R.raw.zunda_11h)
        12 -> MediaPlayer.create(context, R.raw.zunda_12h)
        else -> null
    }

    Log.d("hour", hour.toString())

    if (readHour != null) {
        mediaPlayers.add(readHour)
    }

    // minの読み上げ
    val readMin = when (min) {
        0 -> MediaPlayer.create(context, R.raw.zunda_0m)
        1 -> MediaPlayer.create(context, R.raw.zunda_1m)
        2 -> MediaPlayer.create(context, R.raw.zunda_2m)
        3 -> MediaPlayer.create(context, R.raw.zunda_3m)
        4 -> MediaPlayer.create(context, R.raw.zunda_4m)
        5 -> MediaPlayer.create(context, R.raw.zunda_5m)
        6 -> MediaPlayer.create(context, R.raw.zunda_6m)
        7 -> MediaPlayer.create(context, R.raw.zunda_7m)
        8 -> MediaPlayer.create(context, R.raw.zunda_8m)
        9 -> MediaPlayer.create(context, R.raw.zunda_9m)
        10 -> MediaPlayer.create(context, R.raw.zunda_10m)
        11 -> MediaPlayer.create(context, R.raw.zunda_11m)
        12 -> MediaPlayer.create(context, R.raw.zunda_12m)
        13 -> MediaPlayer.create(context, R.raw.zunda_13m)
        14 -> MediaPlayer.create(context, R.raw.zunda_14m)
        15 -> MediaPlayer.create(context, R.raw.zunda_15m)
        16 -> MediaPlayer.create(context, R.raw.zunda_16m)
        17 -> MediaPlayer.create(context, R.raw.zunda_17m)
        18 -> MediaPlayer.create(context, R.raw.zunda_18m)
        19 -> MediaPlayer.create(context, R.raw.zunda_19m)
        20 -> MediaPlayer.create(context, R.raw.zunda_20m)
        21 -> MediaPlayer.create(context, R.raw.zunda_21m)
        22 -> MediaPlayer.create(context, R.raw.zunda_22m)
        23 -> MediaPlayer.create(context, R.raw.zunda_23m)
        24 -> MediaPlayer.create(context, R.raw.zunda_24m)
        25 -> MediaPlayer.create(context, R.raw.zunda_25m)
        26 -> MediaPlayer.create(context, R.raw.zunda_26m)
        27 -> MediaPlayer.create(context, R.raw.zunda_27m)
        28 -> MediaPlayer.create(context, R.raw.zunda_28m)
        29 -> MediaPlayer.create(context, R.raw.zunda_29m)
        30 -> MediaPlayer.create(context, R.raw.zunda_30m)
        31 -> MediaPlayer.create(context, R.raw.zunda_31m)
        32 -> MediaPlayer.create(context, R.raw.zunda_32m)
        33 -> MediaPlayer.create(context, R.raw.zunda_33m)
        34 -> MediaPlayer.create(context, R.raw.zunda_34m)
        35 -> MediaPlayer.create(context, R.raw.zunda_35m)
        36 -> MediaPlayer.create(context, R.raw.zunda_36m)
        37 -> MediaPlayer.create(context, R.raw.zunda_37m)
        38 -> MediaPlayer.create(context, R.raw.zunda_38m)
        39 -> MediaPlayer.create(context, R.raw.zunda_39m)
        40 -> MediaPlayer.create(context, R.raw.zunda_40m)
        41 -> MediaPlayer.create(context, R.raw.zunda_41m)
        42 -> MediaPlayer.create(context, R.raw.zunda_42m)
        43 -> MediaPlayer.create(context, R.raw.zunda_43m)
        44 -> MediaPlayer.create(context, R.raw.zunda_44m)
        45 -> MediaPlayer.create(context, R.raw.zunda_45m)
        46 -> MediaPlayer.create(context, R.raw.zunda_46m)
        47 -> MediaPlayer.create(context, R.raw.zunda_47m)
        48 -> MediaPlayer.create(context, R.raw.zunda_48m)
        49 -> MediaPlayer.create(context, R.raw.zunda_49m)
        50 -> MediaPlayer.create(context, R.raw.zunda_50m)
        51 -> MediaPlayer.create(context, R.raw.zunda_51m)
        52 -> MediaPlayer.create(context, R.raw.zunda_52m)
        53 -> MediaPlayer.create(context, R.raw.zunda_53m)
        54 -> MediaPlayer.create(context, R.raw.zunda_54m)
        55 -> MediaPlayer.create(context, R.raw.zunda_55m)
        56 -> MediaPlayer.create(context, R.raw.zunda_56m)
        57 -> MediaPlayer.create(context, R.raw.zunda_57m)
        58 -> MediaPlayer.create(context, R.raw.zunda_58m)
        59 -> MediaPlayer.create(context, R.raw.zunda_59m)
        else -> null
    }

    if (readMin != null) {
        mediaPlayers.add(readMin)
    }

    // secondの読み上げ
    val readSecond = when (second) {
        in 0..9 -> MediaPlayer.create(context, R.raw.zunda_10s)
        in 10..19 -> MediaPlayer.create(context, R.raw.zunda_20s)
        in 20..29 -> MediaPlayer.create(context, R.raw.zunda_30s)
        in 30..39 -> MediaPlayer.create(context, R.raw.zunda_40s)
        in 40..49 -> MediaPlayer.create(context, R.raw.zunda_50s)
        in 50..59 -> MediaPlayer.create(context, R.raw.zunda_0s)
        else -> null
    }

    if (readSecond != null) {
        mediaPlayers.add(readSecond)
    }

    // 「お知らせします。」の読み上げ
    val readInfo = MediaPlayer.create(context, R.raw.zunda_inform)
    if (readInfo != null) {
        mediaPlayers.add(readInfo)
    }

    // 順番に再生するためのリスナー設定
    for (i in 0 until mediaPlayers.size - 1) {
        mediaPlayers[i]?.setOnCompletionListener { mp ->
            mp.release()
            mediaPlayers[i + 1]?.start()
        }
    }

    // 最後のプレーヤーのリスナー設定
    mediaPlayers.last()?.setOnCompletionListener { mp ->
        mp.release()
    }

    // 最初のプレーヤーを再生開始
    mediaPlayers.first()?.start()
}