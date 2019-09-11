package com.duongtung.cookingman.fragment.phone


import android.view.View
import com.duongtung.cookingman.base.ui.base.BaseViewModel

class PhoneViewModel : BaseViewModel(){
    var onButtonClickListener: OnButtonClickListener ? = null
    fun handleNext(view : View){
        onButtonClickListener!!.onButtonClicked(view)
    }
}