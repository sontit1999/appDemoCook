package com.duongtung.cookingman.adapter

import android.util.Log
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemChatlistBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

class ListChatAdapter  : BaseAdapter<User,ItemChatlistBinding>(){
    private var callBack : ListChatCallback?= null

    fun setCallBack( callBack: ListChatCallback?){
        this.callBack = callBack
    }
    override fun getOnClick()= callBack

    override fun getIdVariableOnClick() = BR.callback

    override fun getLayoutId() = R.layout.item_chatlist

    override fun getIdVariable() = BR.user

}