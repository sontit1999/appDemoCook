package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.View
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemRecipeBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Recipe
import com.duongtung.cookingman.model.User

class RecipeAdapter : BaseAdapter<Recipe,ItemRecipeBinding>(){
    private var callBack : RecipCallback?= null

    fun setCallBack( callBack: RecipCallback?){
        this.callBack = callBack
    }
    override fun getIdVariableOnClick()= BR.callback

    override fun getLayoutId() = R.layout.item_recipe

    override fun getIdVariable() = BR.recipe
    override fun getOnClick() = callBack

    }
