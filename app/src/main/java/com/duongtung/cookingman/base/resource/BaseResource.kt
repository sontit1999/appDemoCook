package com.duongtung.cookingman.base.resource

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.ContextCompat

class BaseResource{

    private var context : Context
    constructor(context: Context){
        this.context = context
    }

    fun getString(resId : Int) : String {
        return context.getString(resId)
    }

    fun getImageResource(resId: Int) : Drawable? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.getDrawable(resId)
        } else {
            ContextCompat.getDrawable(context,resId)
        }
    }

    fun getColor(resId: Int) : Int? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getColor(resId)
        } else {
            ContextCompat.getColor(context,resId)
        }
    }
    fun getResource() : Resources{
        return context.resources
    }
}