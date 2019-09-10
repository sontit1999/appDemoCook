package com.duongtung.cookingman.model

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.customview.FontCache


class CustomTextView : AppCompatTextView {
    private var  typeFace : Int? = null
    private var typedFace : Typeface?= null
    constructor(context: Context?):super(context){
        init(context,null)
    }
    constructor(context: Context?, attrs: AttributeSet?):super(context, attrs){
        init(context,attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int):super(context, attrs, defStyleAttr){
        init(context,attrs)
    }
    fun init(context: Context?,attrs: AttributeSet?){
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        typeFace = typed.getInt(R.styleable.CustomTextView_fontFace,0)
        when(typeFace){
            0 -> typedFace = FontCache.get(context,FontCache.FA_FONT_LIGHT)
            1 -> typedFace = FontCache.get(context,FontCache.FA_FONT_BRANDS)
            2 -> typedFace = FontCache.get(context,FontCache.FA_FONT_SOLID)
            3 -> typedFace = FontCache.get(context,FontCache.FA_FONT_REGULAR)
            4 -> typedFace = FontCache.get(context,FontCache.FONT_CATHSGBR)
            5 -> typedFace = FontCache.get(context,FontCache.FONT_GENBKBASL)
        }
        this.typeface = typedFace!!
    }
}