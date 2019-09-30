package com.duongtung.cookingman.adapter

import android.view.View
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User

interface MessageCallback : CBAdapter{
    fun onMessageClick(view: View, user : User){

    }
}