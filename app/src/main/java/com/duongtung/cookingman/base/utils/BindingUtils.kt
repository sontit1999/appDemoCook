package com.duongtung.cookingman.base.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duongtung.cookingman.customview.imageslide.ImageSlider
import com.duongtung.cookingman.customview.imageslide.ItemImageSlide
import com.duongtung.cookingman.customview.imageslide.ViewPagerAdapter
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

    @BindingAdapter(value = ["app:height","app:height_wrapper"],requireAll = false)
    @JvmStatic fun setHeight(collapsing : CollapsingToolbarLayout,imageCollapsing : Int?,listImageSlide: MutableList<ItemImageSlide>?){
        val resourceId = collapsing.context.resources.getIdentifier("status_bar_height", "dimen", "android")
        val params = collapsing.layoutParams
        val styledAttributes = collapsing.context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val statusDimen = collapsing.context.resources.getDimensionPixelSize(resourceId)
         if (imageCollapsing == null && listImageSlide == null){
             params.height = styledAttributes.getDimension(0, 0f).toInt() + statusDimen
        }else {
            collapsing.context.resources.getDimension(com.duongtung.cookingman.R.dimen.heigh_banner_home) + statusDimen
        }
        styledAttributes.recycle()
    }

    @BindingAdapter("android:visibility")
    @JvmStatic fun setVisibility(view : View, isVisibility : Boolean){
        view.visibility = if (isVisibility) View.GONE else View.VISIBLE
    }

    @BindingAdapter("app:fitSystem")
    @JvmStatic fun setFitSystem(view: View,imageCollapsing: Int?){
        view.fitsSystemWindows = imageCollapsing != null
    }

    @BindingAdapter("setImage")
    @JvmStatic fun setImage(view : ImageView,res : Any?){
        if (res == null ) return
       Glide.with(view).load(res).into(view)
    }

    @BindingAdapter("app:imageSliderFitSystem")
    @JvmStatic fun setImageSliderFitSystem(view: ImageSlider, sliders : MutableList<ItemImageSlide>?){
        view.fitsSystemWindows = sliders != null
    }

    @BindingAdapter("app:setViewPagerAdapter")
    @JvmStatic fun setAdapter(view: ImageSlider, sliders : MutableList<ItemImageSlide>?){
        if (sliders == null) return
        else view.setImageList(sliders)
    }

    @BindingAdapter("app:backgroundToolbar")
    @JvmStatic fun setBackground(view: Toolbar, background : Int?){
        if (background == null) view.setBackgroundColor(Color.TRANSPARENT)
        else view.setBackgroundColor(background)
    }
}