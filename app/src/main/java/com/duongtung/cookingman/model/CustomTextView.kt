package com.duongtung.cookingman.model

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R
import info.androidhive.fontawesome.FontCache

class CustomTextView: AppCompatTextView {
    private var isBrandingIcon:Boolean = false
    private var isSolidIcon:Boolean = false
    constructor(context: Context) : super(context) {}
    @JvmOverloads constructor(context:Context, attrs: AttributeSet, defStyle:Int = 0) : super(context, attrs, defStyle) {
        val a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FontTextView,
            0, 0)
        isSolidIcon = a.getBoolean(R.styleable.FontTextView_solid_icon, false)
        isBrandingIcon = a.getBoolean(R.styleable.FontTextView_brand_icon, false)
        init()
    }
    private fun init() {
        if (isBrandingIcon)
            setTypeface(FontCache.get(getContext(), "fa-brands-400.ttf"))
        else if (isSolidIcon)
            setTypeface(FontCache.get(getContext(), "fa-solid-900.ttf"))
        else
            setTypeface(FontCache.get(getContext(), "fa-regular-400.ttf"))
    }
}