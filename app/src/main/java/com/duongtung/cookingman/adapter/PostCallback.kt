package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.View
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

interface PostCallback  : CBAdapter{
    fun onImageFoodClick(view: View,post : Post)
    fun onAvatarClick(view : View,user : User)
    fun onMoreClick(view:View,post:Post)
}
