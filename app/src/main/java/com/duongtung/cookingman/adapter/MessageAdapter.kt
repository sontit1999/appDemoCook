package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseMultiViewHolderAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.model.Message

class MessageAdapter : BaseMultiViewHolderAdapter<Message>(){

    override fun getVariableId() = mutableListOf(BR.message,BR.message)

    override fun getIdVariableOnClick() = null

    override fun getOnClick() = null

    override fun getLayoutId() = mutableListOf(R.layout.item_chat_sent,R.layout.item_chat_recive)
}