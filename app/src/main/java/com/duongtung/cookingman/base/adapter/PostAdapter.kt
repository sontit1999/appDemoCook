package com.duongtung.cookingman.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.Model.Post

class PostAdapter(val arrPost : ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.Viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_post,parent,false)
        return Viewholder(v)
    }

    override fun getItemCount(): Int {
        return arrPost.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        var Post = arrPost.get(position)
        holder?.tvname?.text = Post.getName()
        holder?.tvfood?.text = Post.getFood()
    }

    class Viewholder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var tvname = itemview.findViewById(R.id.tv_name) as TextView
        var tvfood = itemview.findViewById(R.id.tvnameFood) as TextView
    }
}