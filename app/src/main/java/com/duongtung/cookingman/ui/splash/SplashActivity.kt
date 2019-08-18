package com.duongtung.cookingman.ui.splash

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding,SplashViewModel>() {
    override fun getViewMode()= SplashViewModel::class.java

    override fun getLayout()= R.layout.activity_splash

    override fun setBindingViewModel() {
       binding.viewModel = viewModel
    }
}