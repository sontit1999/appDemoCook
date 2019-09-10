package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R

class TextViewWithFontAwesome: AppCompatTextView {
    private var  typeFace : Int? = null
    private var  typeFaceText : Int? = null
    private var typedFace : Typeface?= null
    private var typeText : Typeface? = null
    constructor(context: Context?) : super(context){
        init(context,null)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context,attrs){
        init(context,attrs)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs,defStyleAttr){
        init(context,attrs)
    }
    private fun init(context :Context?,attrs: AttributeSet?){
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.TextViewWithFontAwesome)
        typeFace = typed.getInt(R.styleable.TextViewWithFontAwesome_fontawesome,0)
        when(typeFace){
            0 -> typedFace = FontCache.get(context,FontCache.FA_FONT_LIGHT)
            1 -> typedFace = FontCache.get(context,FontCache.FA_FONT_BRANDS)
            2 -> typedFace = FontCache.get(context,FontCache.FA_FONT_SOLID)
            3 -> typedFace = FontCache.get(context,FontCache.FA_FONT_REGULAR)
        }
        typeFaceText = typed.getInt(R.styleable.TextViewWithFontAwesome_fontFaceText,0)
        when(typeFaceText){
            0->typeText = this.typeface
            1->typeText = FontCache.get(context,FontCache.FONT_CATHSGBR)
            2->typeText = FontCache.get(context,FontCache.FONT_GENBKBASL)
        }
        this.typeface = typeText!!

        val iconLeft = typed.getString(R.styleable.TextViewWithFontAwesome_iconLeft)
        val iconTop = typed.getString(R.styleable.TextViewWithFontAwesome_iconTop)
        val iconRight = typed.getString(R.styleable.TextViewWithFontAwesome_iconRight)
        val iconBottom = typed.getString(R.styleable.TextViewWithFontAwesome_iconBottom)
        val iconColor = typed.getColor(R.styleable.TextViewWithFontAwesome_iconColor, Color.WHITE)

        val iconDrawableLeft = getIconDrawable(context,iconLeft,typedFace,iconColor)
        val iconDrawableRight = getIconDrawable(context,iconRight,typedFace,iconColor)
        val iconDrawableTop = getIconDrawable(context,iconTop,typedFace,iconColor)
        val iconDrawableBottom = getIconDrawable(context,iconBottom,typedFace,iconColor)

        this.setCompoundDrawablesWithIntrinsicBounds(iconDrawableLeft,iconDrawableTop,iconDrawableRight,iconDrawableBottom)
    }
    fun getIconDrawable(context: Context?, icon: String?, typeface: Typeface?, color: Int?): FontDrawable?{
        if (TextUtils.isEmpty(icon)) return null
        val drawable = FontDrawable(context!!,icon!!,typeface!!)
        drawable.setTextColor(color!!)
        return drawable
    }
}