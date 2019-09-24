package com.duongtung.cookingman.base.utils

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout


object  BindingUtils{

    @BindingAdapter("imageResource")
    @JvmStatic fun ImageView.setImageResoucre( res : Int){
        if (res>0)
        this.setImageResource(res)
    }

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

    @BindingAdapter("app:height")
    @JvmStatic fun setHeight(collapsing : CollapsingToolbarLayout,imageCollapsing : Int?){
        val resourceId = collapsing.context.resources.getIdentifier("status_bar_height", "dimen", "android")
        val params = collapsing.layoutParams
        val styledAttributes = collapsing.context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val statusDimen = collapsing.context.resources.getDimensionPixelSize(resourceId)
         if (imageCollapsing==null){
             params.height = styledAttributes.getDimension(0, 0f).toInt() + statusDimen
            styledAttributes.recycle()
        }else {
            collapsing.context.resources.getDimension(com.duongtung.cookingman.R.dimen.heigh_banner_home) + statusDimen
        }
    }

    @BindingAdapter("android:visibility")
    @JvmStatic fun setVisibility(view : View, isVisibility : Boolean){
        view.visibility = if (isVisibility) View.GONE else View.VISIBLE
    }

    @BindingAdapter("app:fitSystem")
    @JvmStatic fun setFitSystem(view: View,imageCollapsing: Int?){
        view.fitsSystemWindows = imageCollapsing != null
    }
}