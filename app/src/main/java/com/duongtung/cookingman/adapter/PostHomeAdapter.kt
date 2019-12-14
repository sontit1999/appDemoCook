package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemSpecialFoodBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres

class PostHomeAdapter  : BaseAdapter<Postres,ItemSpecialFoodBinding>(){
    private var callBack : PostCallback?= null

    fun setCallBack( callBack: PostCallback?){
        this.callBack = callBack
    }

    override fun getLayoutId() = R.layout.item_special_food

    override fun getIdVariable() = BR.post

    override fun getIdVariableOnClick() = BR.callback

    override fun getOnClick() = callBack

}