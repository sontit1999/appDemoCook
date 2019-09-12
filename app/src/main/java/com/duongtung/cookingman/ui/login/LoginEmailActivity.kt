package com.duongtung.cookingman.ui.login

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityLoginnBinding

class LoginEmailActivity : BaseActivity<ActivityLoginnBinding,LoginEmailViewModel>(){
    override fun getViewMode() = LoginEmailViewModel::class.java

    override fun getLayout() = R.layout.activity_loginn

    override fun setBindingViewModel() {
       binding.viewModel = viewModel
    }

}