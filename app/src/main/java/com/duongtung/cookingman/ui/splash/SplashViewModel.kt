package com.duongtung.cookingman.ui.splash

import android.text.SpannableString
import android.text.SpannableStringBuilder
import com.duongtung.cookingman.base.ui.base.BaseViewModel

class SplashViewModel : BaseViewModel() {
    var text= SpannableStringBuilder ("Best place for food lovers like you")
    val styledString = SpannableString(
        "By continue, you agree to the Terms of Service and Privacy Policy")

}