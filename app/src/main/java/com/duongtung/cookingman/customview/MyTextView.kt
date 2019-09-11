package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

class MyTextView: TextView {
    constructor(context: Context, attrs: AttributeSet, defStyle:Int) : super(context, attrs, defStyle) {
        init()
    }
    constructor(context:Context, attrs:AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context:Context) : super(context) {
        init()
    }
    private fun init() {
        //Font name should not contain "/".
        var font = Typeface.createFromAsset(context.assets, "GenBkBasI.ttf" )
        setTypeface(font)
    }
}