package com.duongtung.cookingman.ui.login

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityForgotPasswordBinding
import com.duongtung.cookingman.databinding.ActivityLoginBindingImpl
import com.duongtung.cookingman.databinding.ActivityLoginnBinding
import com.duongtung.cookingman.databinding.ActivityLoginnBindingImpl
import kotlinx.android.synthetic.main.activity_loginn.view.*

class LoginEmailActivity : BaseActivity<ActivityLoginnBinding,LoginEmailViewModel>(){
    override fun getViewMode() = LoginEmailViewModel::class.java

    override fun getLayout() = R.layout.activity_loginn

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvForgetpass.setOnClickListener {
            goToActivity(ForgotPasswordActivity::class.java,null,null)
        }
    }

}