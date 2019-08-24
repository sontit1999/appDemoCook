package com.duongtung.cookingman.ui.splash

import android.content.Intent
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySplashBinding
import com.duongtung.cookingman.ui.chatdetail.DetailChatActivity
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
            var intent = Intent(baseContext, DetailChatActivity::class.java)
            startActivity(intent)
        }
    }
}