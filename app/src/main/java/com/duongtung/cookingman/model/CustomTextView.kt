package com.duongtung.cookingman.model

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R

class CustomTextView: AppCompatTextView {
    private var isBrandingIcon:Boolean = false
    private var isSolidIcon:Boolean = false
    constructor(context: Context) : super(context) {}
    @JvmOverloads constructor(context:Context, attrs: AttributeSet, defStyle:Int = 0) : super(context, attrs, defStyle) {
            }
    private fun init() {
    }
}