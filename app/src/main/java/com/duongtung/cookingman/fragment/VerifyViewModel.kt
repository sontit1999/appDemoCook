package com.duongtung.cookingman.fragment

import android.util.Log
import android.view.View
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.customview.pinview.PinView

class VerifyViewModel : BaseViewModel(){
    fun onComplete(view : View){
        Log.d("onComplete", ""+ (view as PinView).text.toString())
    }
}