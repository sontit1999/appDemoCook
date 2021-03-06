package com.duongtung.cookingman.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.customview.CustomEditText
import com.duongtung.cookingman.databinding.ActivityForgotPasswordBinding
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class ForgotPasswordActivity : BaseActivity<ActivityForgotPasswordBinding,ForgotPasswordViewModel>(){
    override fun getToolbar(): Toolbar? = binding.actionbar.tbBase

    override fun getViewMode() = ForgotPasswordViewModel::class.java

    override fun getLayout() = R.layout.activity_forgot_password
    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.btnChangepass.setOnClickListener {
            if(!binding.etGmail.text!!.isEmpty())
            goToActivity(SendEmailAtivity::class.java,null,null)
        }
        binding.actionbar.data = DataUtilsApplication.createActionBarLeftArrow(title = null,context = this)
        binding.actionbar.tvleft.setOnClickListener {
            onBackPressed()
        }
    }

}