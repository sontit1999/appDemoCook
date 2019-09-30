package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.User

class ListChatCallback : CBAdapter{
    fun onItemClick(view : View,user: User){
        Log.d("test", "click list chat")
        view.findNavController().navigate(R.id.action_Chatfragment_to_detailChatFragment)
    }
}