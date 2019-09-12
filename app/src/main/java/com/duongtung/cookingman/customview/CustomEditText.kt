package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.customview.FontCache
import java.util.regex.Pattern


class CustomEditText : AppCompatEditText {
    interface OnErrorListener{
        fun onErrorListener(boolean: Boolean)
    }

    private var typeFace: Int? = null

    private var onError : OnErrorListener?=null

    fun onError(onErrorListener: OnErrorListener){
        onError = onErrorListener
    }
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
        val typed = context!!.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        typeFace = typed.getInt(R.styleable.CustomEditText_fontFaceEdit, 9)
        this.typeface = FontCache.getTyface(context, typeFace!!)
        val validate = typed.getInt(R.styleable.CustomEditText_validate, -1)
        when (validate) {
            0 -> this.addTextChangedListener(PhoneValidate(this))
            1 -> this.addTextChangedListener(EMailValidate(this))
        }

        typed.recycle()
    }

    class PhoneValidate(private var editText: CustomEditText) : TextWatcher {
        private var pattern =
            Pattern.compile("(0)?(78|77|76|79|70|90|91|93|94|96|97|98|32|33|34|35|36|37|38|39|81|83|84|85|82)([0-9]{3})([0-9]{4})")

        override fun afterTextChanged(editable: Editable?) {
            val match = pattern.matcher(editable).matches()
            if (editable!!.length in 9..10) {
                if (!match) {
                    if(this.editText.onError!=null)  this.editText.onError!!.onErrorListener(true)
                    editText.error =
                        editText.context!!.resources.getString(R.string.validate_phone_wrong_number)
                }else {
                    if(this.editText.onError!=null)  this.editText.onError!!.onErrorListener(false)
                }
            } else if (editable.length <= 8 || editable.length > 10) {
                if(this.editText.onError!=null)  this.editText.onError!!.onErrorListener(true)
                editText.error =
                    editText.context!!.resources.getString(R.string.validate_phone_missing_number)
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    class EMailValidate(private var editText: CustomEditText) : TextWatcher {
        val pattern =
            Pattern.compile("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}\$")

        override fun afterTextChanged(editable: Editable?) {
            val matcher = pattern.matcher(editable).matches()
            if (!matcher) {
                if(this.editText.onError!=null)  this.editText.onError!!.onErrorListener(true)
                editText.error =
                    editText.context!!.resources.getString(R.string.validate_email)
            }else {
                if(this.editText.onError!=null)  this.editText.onError!!.onErrorListener(false)
            }

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }
}