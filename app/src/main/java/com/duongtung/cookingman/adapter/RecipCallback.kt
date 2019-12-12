package com.duongtung.cookingman.adapter

import android.view.View
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe

interface RecipCallback : CBAdapter{
    fun onAuthorClick(view: View,post : Postres)
    fun onLikeClick(view: View,post : Postres)
    fun onRecipeClick(view: View,post: Postres)
}