package com.duongtung.cookingman.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySendEmailAtivityBinding
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class SendEmailAtivity : BaseActivity<ActivitySendEmailAtivityBinding,SendEmailViewModel>(){
    override fun getViewMode() = SendEmailViewModel::class.java

    override fun getLayout() = R.layout.activity_send_email_ativity

    override fun setBindingViewModel() {
       binding.viewModel = viewModel
        binding.btnBacklogin.setOnClickListener {
            goToActivity(LoginEmailActivity::class.java,null,null)
        }
        binding.actionbar.tvReturn.setText("Return")
    }

}
