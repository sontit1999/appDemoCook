package com.duongtung.cookingman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemPostBinding
import com.duongtung.cookingman.model.Post

class PostAdapter : BaseAdapter<Post,ItemPostBinding>(){
    override fun getLayoutId() = R.layout.item_post

    override fun getIdVariable()= BR.post
}