package com.duongtung.cookingman.ui.login

import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.databinding.ActivitySendEmailAtivityBinding

class SendEmailAtivity : BaseActivity<ActivitySendEmailAtivityBinding,SendEmailViewModel>(){
    override fun getToolbar(): Toolbar = binding.abSendEmail.tbBase

    override fun getViewMode() = SendEmailViewModel::class.java

    override fun getLayout() = R.layout.activity_send_email_ativity

    override fun setBindingViewModel() {
       binding.viewModel = viewModel
        binding.btnBacklogin.setOnClickListener {
            goToActivity(LoginEmailActivity::class.java,null,null)
        }
        binding.abSendEmail.data = DataUtilsApplication.createActionBarLeftArrow(null,this)
        binding.abSendEmail.tvleft.setOnClickListener {
            onBackPressed()
        }
    }

}
