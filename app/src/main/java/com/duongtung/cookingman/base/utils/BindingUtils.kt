package com.duongtung.cookingman.base.utils

import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

object  BindingUtils{

    @BindingAdapter("imageResource")
    @JvmStatic fun ImageView.setImageResoucre( res : Int){
        if (res>0)
        this.setImageResource(res)
    }
    // adapter là attribute set xuống xml có 2 kiểu viết là fun setAdapter(recycleview : RecycleView, adapter : RecycleView.Adapter<*>) và RecyclceView.setAdapter(adapter ...) kiểu 1 tên gì cũng được miễn tên function đã tồn tại kiểu 2 tự định nghĩa tên function chỉ nhận vs attribute .
    // e vừa thay thế này đúng ko a
    @BindingAdapter("adapter")
    @JvmStatic fun RecyclerView.setAdapter(adapter : RecyclerView.Adapter<*>){
        this.adapter = adapter
    }

    @BindingAdapter("imageUrl")
    @JvmStatic fun ImageView.setImageResoucre( res : String){
       Glide.with(this).load(res).into(this)
    }

    @BindingAdapter("textHtml")
    @JvmStatic fun setTextHtml(view : TextView,text : String){
        view.text = Html.fromHtml("<b>$text</b>")
    }

}