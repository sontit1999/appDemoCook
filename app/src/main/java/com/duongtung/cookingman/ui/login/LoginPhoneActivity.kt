package com.duongtung.cookingman.ui.login

import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.LoginPhoneActivityBinding

class LoginPhoneActivity : BaseActivity<LoginPhoneActivityBinding, LoginPhoneViewModel>() {
    override fun getViewMode()=LoginPhoneViewModel::class.java
    override fun getLayout()= R.layout.login_phone_activity

    override fun setBindingViewModel() {
       binding.viewmodel = viewModel
    }

    override fun getToolbar(): Toolbar? {
       return null
    }
}