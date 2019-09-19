package com.duongtung.cookingman.adapter

import android.util.Log
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.callback.MenuHomeCallback

class MenuCallBack(var cb:MenuHomeCallback) : CBAdapter {

    fun onCliCkMenu(id : Int){
        Log.d("","duongTung $id")
        cb.onCloseDrawer()
    }
}