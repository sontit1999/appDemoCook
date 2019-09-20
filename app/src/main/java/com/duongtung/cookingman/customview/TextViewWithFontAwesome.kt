package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R

class TextViewWithFontAwesome : AppCompatTextView {
    private var typeFace: Int? = null
    private var typeFaceText: Int? = null
    private var typedFace: Typeface? = null
    private var typeText: Typeface? = null
    private var iconLeft: String? = null
    private var iconRight: String? = null
    private var iconTop: String? = null
    private var iconBottom: String? = null
    private var iconSize: Float? = null
    private var iconColor: Int? = null
    private var iconDrawableLeft: Drawable? = null
    private var iconDrawableRight: Drawable? = null
    private var iconDrawableTop: Drawable? = null
    private var iconDrawableBottom: Drawable? = null

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

    private fun init(context: Context?, attrs: AttributeSet?) {
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.TextViewWithFontAwesome)
        typeFace = typed.getInt(R.styleable.TextViewWithFontAwesome_fontawesome, 0)
        when (typeFace) {
            0 -> typedFace = FontCache.get(context, FontCache.FA_FONT_LIGHT)
            1 -> typedFace = FontCache.get(context, FontCache.FA_FONT_BRANDS)
            2 -> typedFace = FontCache.get(context, FontCache.FA_FONT_SOLID)
            3 -> typedFace = FontCache.get(context, FontCache.FA_FONT_REGULAR)
        }
        typeFaceText = typed.getInt(R.styleable.TextViewWithFontAwesome_fontFaceText, 0)
        when (typeFaceText) {
            0 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_LIGHT)
            1 -> typeText = FontCache.get(context, FontCache.FONT_CATHSGBR)
            2 -> typeText = FontCache.get(context, FontCache.FONT_GENBKBASL)
            3 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_BOLD)
            4 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_ITALIC)
            5 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_MEDIUM)
            6 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_REGULAR)
            7 -> typeText = FontCache.get(context, FontCache.FONT_ROBOTO_THIN)
        }
        iconSize = typed.getDimension(R.styleable.TextViewWithFontAwesome_iconTextSize, 15f)
        iconLeft = typed.getString(R.styleable.TextViewWithFontAwesome_iconLeft)
        iconTop = typed.getString(R.styleable.TextViewWithFontAwesome_iconTop)
        iconRight = typed.getString(R.styleable.TextViewWithFontAwesome_iconRight)
        iconBottom = typed.getString(R.styleable.TextViewWithFontAwesome_iconBottom)
        iconColor = typed.getColor(R.styleable.TextViewWithFontAwesome_iconColor, Color.WHITE)

        iconDrawableLeft = getIconDrawable(context, iconLeft, typedFace, iconColor, iconSize)
        iconDrawableRight = getIconDrawable(context, iconRight, typedFace, iconColor, iconSize)
        iconDrawableTop = getIconDrawable(context, iconTop, typedFace, iconColor, iconSize)
        iconDrawableBottom = getIconDrawable(context, iconBottom, typedFace, iconColor, iconSize)

        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )

        this.typeface = typeText!!
        typed.recycle()

    }

    private fun getIconDrawable(
        context: Context?,
        icon: String?,
        typeface: Typeface?,
        color: Int?,
        iconSize: Float?
    ): FontDrawable? {
        if (TextUtils.isEmpty(icon)) return null
        val drawable = FontDrawable(context!!, icon!!, typeface!!)
        drawable.setTextSize(TypedValue.COMPLEX_UNIT_PX, iconSize!!)
        drawable.setTextColor(color!!)
        return drawable
    }

    fun setIconLeft(iconLeft: String?) {
        this.iconLeft = iconLeft
        iconDrawableLeft = getIconDrawable(context, iconLeft, typedFace, iconColor, iconSize)
        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )
    }

    fun setIconRight(iconRight: String?) {
        this.iconRight = iconRight
        iconDrawableRight = getIconDrawable(context, iconRight, typedFace, iconColor, iconSize)
        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )

    }

    fun setIconTop(iconTop: String?) {
        this.iconTop = iconTop
        iconDrawableTop = getIconDrawable(context, iconTop, typedFace, iconColor, iconSize)
        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )

    }

    fun setIconBottom(iconBottom: String?) {
        this.iconBottom = iconBottom
        iconDrawableBottom = getIconDrawable(context, iconBottom, typedFace, iconColor, iconSize)
        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )
    }
    fun setFontIcon(type: Typeface){
        iconDrawableLeft = getIconDrawable(context, iconLeft, type, iconColor, iconSize)
        iconDrawableRight = getIconDrawable(context, iconRight, type, iconColor, iconSize)
        iconDrawableTop = getIconDrawable(context, iconTop, type, iconColor, iconSize)
        iconDrawableBottom = getIconDrawable(context, iconBottom, type, iconColor, iconSize)

        this.setCompoundDrawablesWithIntrinsicBounds(
            iconDrawableLeft,
            iconDrawableTop,
            iconDrawableRight,
            iconDrawableBottom
        )

    }
}