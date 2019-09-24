package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemFavoriteBinding
import com.duongtung.cookingman.model.Post

class FavoriteAdapter : BaseAdapter<Post,ItemFavoriteBinding>(){
    override fun getLayoutId() = R.layout.item_favorite

    override fun getIdVariable() = BR.post

    override fun getIdVariableOnClick() = null

    override fun getOnClick() = null

}