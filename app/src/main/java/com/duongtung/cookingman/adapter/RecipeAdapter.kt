package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemRecipeBinding
import com.duongtung.cookingman.model.Post

class RecipeAdapter : BaseAdapter<Post,ItemRecipeBinding>(){
    override fun getIdVariableOnClick()= BR.callback

    override fun getLayoutId() = R.layout.item_recipe

    override fun getIdVariable() = BR.post

}