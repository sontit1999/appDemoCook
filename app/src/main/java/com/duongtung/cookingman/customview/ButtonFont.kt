package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.duongtung.cookingman.R

class ButtonFont : AppCompatButton{
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
    fun init(context: Context?, attrs: AttributeSet?){
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.ButtonFont)
        typeFace = typed.getInt(R.styleable.ButtonFont_fontFaceButton,9)
        this.typeface = FontCache.getTyface(context,typeFace!!)
        typed.recycle()
    }
}