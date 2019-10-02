package com.duongtung.cookingman.adapter


import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemResultBinding
import com.duongtung.cookingman.model.Post

class SearchResultAdapter  : BaseAdapter<Post,ItemResultBinding>(){
    private var callback : PostCallback? = null
    fun setCallback(callback: PostCallback){
        this.callback = callback
    }
    override fun getLayoutId() = R.layout.item_result

    override fun getIdVariable() = BR.post

    override fun getIdVariableOnClick() = BR.callback

    override fun getOnClick() = callback

}