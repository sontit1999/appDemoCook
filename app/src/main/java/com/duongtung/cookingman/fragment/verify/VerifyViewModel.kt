package com.duongtung.cookingman.fragment.verify

import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.customview.pinview.PinView
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener

class VerifyViewModel : BaseViewModel(){
    var onButtonClickListener: OnButtonClickListener? = null

    fun onComplete(view : PinView){
        onButtonClickListener!!.onButtonClicked(view,false)
    }
}