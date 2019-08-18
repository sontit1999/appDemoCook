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
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
//        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_post,parent,false)
//        return Viewholder(v)
//    }
//
//    override fun getItemCount(): Int {
//        return arrPost.size
//    }
//
//    override fun onBindViewHolder(holder: Viewholder, position: Int) {
//        var Post = arrPost.get(position)
//        holder?.tvname?.text = Post.getName()
//        holder?.tvfood?.text = Post.getFood()
//    }
//
//    class Viewholder(itemview : View) : RecyclerView.ViewHolder(itemview) {
//        var tvname = itemview.findViewById(R.id.tv_name) as TextView
//        var tvfood = itemview.findViewById(R.id.tvnameFood) as TextView
//    }
}