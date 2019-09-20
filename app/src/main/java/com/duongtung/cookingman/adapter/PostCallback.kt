package com.duongtung.cookingman.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.ui.recipefood.RecipeActivity

class PostCallback  : CBAdapter{
    fun onImagefoodclick(view: View,post : Post){
        //Details Food
        var intent = Intent(view.context,RecipeActivity::class.java)
        intent.putExtra("image",post.recipe.imageRecipe)
        view.context.startActivity(intent)
    }
}