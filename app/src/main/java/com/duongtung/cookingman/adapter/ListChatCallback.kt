package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.User

interface ListChatCallback : CBAdapter{
    fun onItemClick(view : View,user: User)
}