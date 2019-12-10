package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemRecipeBinding
import com.duongtung.cookingman.model.Recipe

class MyRecipeAdapter  : BaseAdapter<Recipe,ItemRecipeBinding>(){

    private var callBack : RecipCallback?= null

    fun setCallBack(callBack: RecipCallback){
        this.callBack = callBack
    }
    override fun getLayoutId() = R.layout.item_recipe

    override fun getIdVariable() = BR.post

    override fun getIdVariableOnClick() = BR.callback
    override fun getOnClick() = callBack

}