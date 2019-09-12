package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.customview.FontCache


class CustomTextView : AppCompatTextView {
    private var typeFace: Int? = null

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    fun init(context: Context?, attrs: AttributeSet?) {
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        typeFace = typed.getInt(R.styleable.CustomTextView_fontFace, 9)
        this.typeface = FontCache.getTyface(context,typeFace!!)
        typed.recycle()
    }

}