package com.duongtung.cookingman.fragment

import android.util.Log
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.customview.pinview.PinView

class VerifyViewModel : BaseViewModel(){
    fun onComplete(view : PinView){
        Log.d("onComplete", "onComplete: "+ view.text.toString())
    }
}