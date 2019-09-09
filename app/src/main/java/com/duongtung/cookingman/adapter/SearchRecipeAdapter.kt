package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemSearchRecipeBinding
import com.duongtung.cookingman.model.RecipeFood

class SearchRecipeAdapter :BaseAdapter<RecipeFood,ItemSearchRecipeBinding>(){
    override fun getIdVariableOnClick(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId() = R.layout.item_search_recipe

    override fun getIdVariable() = BR.recipe

}