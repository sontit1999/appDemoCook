package com.duongtung.cookingman.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R


class ItemTypeFoodAdapter(val arrItemList: ArrayList<TypeFood>, val context: Context) :
    RecyclerView.Adapter<TypeFoodholder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TypeFoodholder {
        return TypeFoodholder(LayoutInflater.from(context).inflate(R.layout.item_recycle_type, p0, false))
    }

    override fun getItemCount(): Int {
        return arrItemList.size
    }

    override fun onBindViewHolder(p0: TypeFoodholder, p1: Int) {
        p0.txtTitle.text = arrItemList.get(p1).getTitle()
        p0.txtDescrible.text = arrItemList.get(p1).getDescribe()
        p0.imgbtnadd.setTag(R.drawable.ic_add)
        Glide.with(context).load(arrItemList.get(p1).getImage()).into(p0.imgTypeFood)
        p0.imgbtnadd.setOnClickListener {
            if (p0.imgbtnadd.tag == R.drawable.ic_add) {
                p0.imgbtnadd.setTag(R.drawable.doneicon)
                p0.imgbtnadd.setImageResource(R.drawable.doneicon)
            } else {
                p0.imgbtnadd.setTag(R.drawable.ic_add)
                p0.imgbtnadd.setImageResource(R.drawable.ic_add)
            }
        }
    }

}