package com.websarva.wings.timesignalapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class ViewModels : ViewModel(){
    var selectedClickSound by mutableIntStateOf(1) //選択されたクリック音の番号
    var clickSound by mutableIntStateOf(1) //クリック音の設定

    var selectedCharacter by mutableStateOf("zundamon") //選択されたキャラクターの名前

    var selectedColor by mutableStateOf(Color.Black) //選択された色の名前

    var selectedFontNumber by mutableIntStateOf(0) //選択されたフォントの番号

    var clicksoundMenuExpanded by mutableStateOf(false) //クリック音設定メニュー開閉の制御
    var characterMenuExpanded by mutableStateOf(false) //キャラクター設定メニュー開閉の制御
    var colorMenuExpanded by mutableStateOf(false) //文字色設定メニュー開閉の制御
    var fontMenuExpanded by mutableStateOf(false) //フォント設定メニュー開閉の制御
}