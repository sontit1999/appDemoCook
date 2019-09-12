package com.duongtung.cookingman.customview.pinview

import android.text.Selection
import android.text.Spannable
import android.text.method.MovementMethod
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.TextView

class DefaultMovementMethod : MovementMethod{
    companion object {
        private var sInstance: DefaultMovementMethod? = null
        fun getInstance(): MovementMethod {
            if (sInstance == null) {
                sInstance = DefaultMovementMethod()
            }
            return sInstance as DefaultMovementMethod
        }
    }
    override fun initialize(widget: TextView, text: Spannable) {
        Selection.setSelection(text, 0)
    }

    override fun onKeyDown(
        widget: TextView,
        text: Spannable,
        keyCode: Int,
        event: KeyEvent
    ): Boolean {
        return false
    }

    override fun onKeyUp(
        widget: TextView,
        text: Spannable,
        keyCode: Int,
        event: KeyEvent
    ): Boolean {
        return false
    }

    override fun onKeyOther(view: TextView, text: Spannable, event: KeyEvent): Boolean {
        return false
    }

    override fun onTakeFocus(widget: TextView, text: Spannable, direction: Int) {

    }

    override fun onTrackballEvent(widget: TextView, text: Spannable, event: MotionEvent): Boolean {
        return false
    }

    override fun onTouchEvent(widget: TextView, text: Spannable, event: MotionEvent): Boolean {
        return false
    }

    override fun onGenericMotionEvent(
        widget: TextView,
        text: Spannable,
        event: MotionEvent
    ): Boolean {
        return false
    }

    override fun canSelectArbitrarily(): Boolean {
        return false
    }
}