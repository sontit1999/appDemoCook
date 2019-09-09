package com.duongtung.cookingman.adapter

import android.util.Log
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemChatlistBinding
import com.duongtung.cookingman.model.Post

public class ListChatAdapter  : BaseAdapter<Post,ItemChatlistBinding>(){
    override fun getIdVariableOnClick(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId() = R.layout.item_chatlist

    override fun getIdVariable() = BR.post

}