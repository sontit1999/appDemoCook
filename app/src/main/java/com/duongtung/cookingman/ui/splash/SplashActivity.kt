package com.duongtung.cookingman.ui.splash

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.customview.CustomSpanTypeFace
import com.duongtung.cookingman.customview.FontCache
import com.duongtung.cookingman.databinding.ActivitySplashBinding
import com.duongtung.cookingman.pref.PrefCookingMan
import com.duongtung.cookingman.ui.MainActivity
import com.duongtung.cookingman.ui.getstart.GetstartActivity
import com.duongtung.cookingman.ui.home.HomeActivity
import com.duongtung.cookingman.ui.login.LoginActivity
import com.duongtung.cookingman.ui.login.LoginEmailActivity
import com.duongtung.cookingman.ui.login.LoginPhoneActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun getViewMode() = SplashViewModel::class.java

    override fun getLayout() = R.layout.activity_splash

    override fun setBindingViewModel() {
        binding.viewModel = viewModel

        viewModel.text.setSpan(
            CustomSpanTypeFace("", FontCache.get(this, FontCache.FONT_ROBOTO_THIN)!!),
            0,
            viewModel.text.length,
            0
        )
        viewModel.text.setSpan(
            ForegroundColorSpan(CookingApplication.getResource().getColor(R.color.tvGetStarted)!!),
            15,
            26,
            0
        )
        viewModel.text.setSpan(
            CustomSpanTypeFace(
                "",
                FontCache.get(this, FontCache.FONT_ROBOTO_REGULAR)!!
            ), 15, 26, 0
        )

        binding.tvSignIn.setOnClickListener {
//            if (PrefCookingMan.getAccessToken(this@SplashActivity) == null)
//                goToActivity(LoginActivity::class.java, null, null)
//            else
                goToActivity(LoginPhoneActivity::class.java, null, null)
        }
        binding.tvGetStarted.setOnClickListener {
            goToActivity(GetstartActivity::class.java, null, null)
        }

        binding.tvCreate.setOnClickListener {
            goToActivity(LoginEmailActivity::class.java, null, null)
        }
        binding.imgLogo.setOnClickListener {
            goToActivity(HomeActivity::class.java, null, null)
        }
    }
}