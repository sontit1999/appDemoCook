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
    private var typedFace: Typeface? = null

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
        when (typeFace) {
            0 -> typedFace = FontCache.get(context, FontCache.FA_FONT_LIGHT)
            1 -> typedFace = FontCache.get(context, FontCache.FA_FONT_BRANDS)
            2 -> typedFace = FontCache.get(context, FontCache.FA_FONT_SOLID)
            3 -> typedFace = FontCache.get(context, FontCache.FA_FONT_REGULAR)
            4 -> typedFace = FontCache.get(context, FontCache.FONT_CATHSGBR)
            5 -> typedFace = FontCache.get(context, FontCache.FONT_GENBKBASL)
            6 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_REGULAR)
            7 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_THIN)
            8 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_MEDIUM)
            9 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_LIGHT)
            10 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_ITALIC)
            11 -> typedFace = FontCache.get(context, FontCache.FONT_ROBOTO_BOLD)
        }
        this.typeface = typedFace!!
        typed.recycle()
    }

    class PhoneValidate(private var editText: CustomEditText) : TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            if (editable!!.length in 10..10) {
                if (editable.matches(regex = Regex.fromLiteral("^+?(?:[0-9]??).{5,14}[0-9]\$"))) {
                    editText.error = editText.context!!.resources.getString(R.string.validate_phone_wrong_number)
                }
            } else if (editable.length < 10 || editable.length > 10) {
                editText.error = editText.context!!.resources.getString(R.string.validate_phone_missing_number)
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    class EMailValidate(private var editText: CustomEditText) : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            if (editable!!.length in 10..10) {
                if (editable.matches(regex = Regex.fromLiteral("^\\+?(?:[0-9]??).{5,14}[0-9]\$"))) {
                    editText.error =
                        editText.context!!.resources.getString(R.string.validate_phone_wrong_number)
                }
            } else if (editable.length < 10 || editable.length > 10) {
                editText.error =
                    editText.context!!.resources.getString(R.string.validate_phone_missing_number)
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

}