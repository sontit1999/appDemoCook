package com.duongtung.cookingman.ui.splash

import android.content.Intent
import android.util.Log
import android.view.View
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySplashBinding
import com.duongtung.cookingman.ui.login.LoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding,SplashViewModel>() {
    override fun getViewMode()= SplashViewModel::class.java

    override fun getLayout()= R.layout.activity_splash

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvSignIn.setOnClickListener {
            goToActivity(LoginActivity::class.java,null,null)
        }
        binding.tvGetStarted.setOnClickListener {
            Log.d("test","ok nhận rồi")
        }
    }
}