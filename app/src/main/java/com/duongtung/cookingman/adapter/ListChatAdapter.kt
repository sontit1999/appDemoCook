package com.duongtung.cookingman.adapter

import android.util.Log
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemChatlistBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

public class ListChatAdapter  : BaseAdapter<User,ItemChatlistBinding>(){

    override fun getOnClick()= ListChatCallback()

    override fun getIdVariableOnClick() = BR.callBack

    override fun getLayoutId() = R.layout.item_chatlist

    override fun getIdVariable() = BR.user

}