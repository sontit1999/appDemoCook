package com.duongtung.cookingman.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityForgotPasswordBinding
import com.duongtung.cookingman.databinding.ActivityLoginBindingImpl
import com.duongtung.cookingman.databinding.ActivityLoginnBinding
import com.duongtung.cookingman.databinding.ActivityLoginnBindingImpl
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.ui.home.HomeActivity
import com.duongtung.cookingman.ui.register.RegisterAcitvity
import kotlinx.android.synthetic.main.activity_loginn.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class LoginEmailActivity : BaseActivity<ActivityLoginnBinding,LoginEmailViewModel>(){
    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun getViewMode() = LoginEmailViewModel::class.java

    override fun getLayout() = R.layout.activity_loginn

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvForgetpass.setOnClickListener {
            goToActivity(ForgotPasswordActivity::class.java,null,null)
        }
        binding.btnLogin.setOnClickListener {
            //goToActivity(HomeActivity::class.java,null,null)
            viewModel.login(binding.etGmail.text.toString(),binding.etPass.text.toString())
        }
        viewModel.getStauslogin().observe(this, Observer {loginres->
           if(loginres.status.equals("succes")){
               var bundle = Bundle()
               bundle.putSerializable("user",loginres)
               CurentUser.user = loginres
               goToActivity(HomeActivity::class.java,null,null)
           }else if(loginres.status.equals("fail")){
               Toast.makeText(baseContext,"Tài khoản hoặc mật khẩu không chính xác!",Toast.LENGTH_LONG).show()
           }
        })
        binding.tvsignUp.setOnClickListener {
            goToActivity(RegisterAcitvity::class.java, null,  null )
        }
    }

}