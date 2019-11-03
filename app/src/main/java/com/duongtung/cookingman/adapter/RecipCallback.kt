package com.duongtung.cookingman.adapter

import android.view.View
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Recipe

interface RecipCallback : CBAdapter{
    fun onAuthorClick(view: View,recipe : Recipe)
    fun onLikeClick(view: View,recipe : Recipe)
    fun onRecipeClick(view: View,recipe: Recipe)
}