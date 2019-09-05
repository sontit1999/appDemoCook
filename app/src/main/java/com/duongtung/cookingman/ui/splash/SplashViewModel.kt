package com.duongtung.cookingman.ui.splash

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import com.duongtung.cookingman.base.ui.base.BaseViewModel

class SplashViewModel : BaseViewModel() {
    var text:SpannableString = SpannableString("Best place for food lovers like you")
    val styledString = SpannableString(
        "By continue, you agree to the Terms of Service and Privacy Policy"
    )
}