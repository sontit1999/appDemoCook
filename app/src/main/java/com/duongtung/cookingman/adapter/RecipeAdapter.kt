package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.View
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemRecipeBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

class RecipeAdapter : BaseAdapter<Post,ItemRecipeBinding>(){
    private var callBack : PostCallback?= null

    fun setCallBack( callBack: PostCallback?){
        this.callBack = callBack
    }
    override fun getIdVariableOnClick()= BR.callback

    override fun getLayoutId() = R.layout.item_recipe

    override fun getIdVariable() = BR.post
    override fun getOnClick() = callBack

    }
