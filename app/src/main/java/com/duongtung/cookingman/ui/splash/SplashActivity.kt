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
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySplashBinding
import com.duongtung.cookingman.ui.login.LoginActivity
import com.duongtung.cookingman.ui.recipefood.RecipeActivity
import com.duongtung.cookingman.ui.setting.SettingActivity

class SplashActivity : BaseActivity<ActivitySplashBinding,SplashViewModel>() {
    override fun getViewMode()= SplashViewModel::class.java

    override fun getLayout()= R.layout.activity_splash

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        // set multi color for text
        viewModel.text.setSpan(ForegroundColorSpan(Color.RED),15,26,0)

        binding.tvSignIn.setOnClickListener {
            goToActivity(LoginActivity::class.java,null,null)

        }
        binding.tvGetStarted.setOnClickListener {
            var intent = Intent(baseContext, RecipeActivity::class.java)
            startActivity(intent)
        }

        binding.tvCreate.setOnClickListener {
            goToActivity(SettingActivity::class.java,null,null)
        }
    }
}