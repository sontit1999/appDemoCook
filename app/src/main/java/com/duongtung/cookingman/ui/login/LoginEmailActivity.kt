package com.duongtung.cookingman.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityForgotPasswordBinding
import com.duongtung.cookingman.databinding.ActivityLoginBindingImpl
import com.duongtung.cookingman.databinding.ActivityLoginnBinding
import com.duongtung.cookingman.databinding.ActivityLoginnBindingImpl
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import com.duongtung.cookingman.ui.home.HomeActivity
import com.duongtung.cookingman.ui.register.RegisterAcitvity
import kotlinx.android.synthetic.main.activity_loginn.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val gmail = binding.etGmail.text.toString().trim()
            val pass = binding.etPass.text.toString().trim()
            if(TextUtils.isEmpty(gmail) || TextUtils.isEmpty(pass)){
                Toast.makeText(baseContext,"Not empty",Toast.LENGTH_LONG).show()
            }else{
                binding.pbLoad.visibility = View.VISIBLE
                viewModel.login(gmail,pass)
            }
        }
        viewModel.getStauslogin().observe(this, Observer {loginres->
           if(loginres.status.equals("succes")){
               binding.pbLoad.visibility = View.GONE
               var bundle = Bundle()
               bundle.putSerializable("user",loginres)
               CurentUser.user = loginres
               goToActivity(HomeActivity::class.java,null,null)
           }else if(loginres.status.equals("fail")){
               binding.pbLoad.visibility = View.GONE
               Toast.makeText(baseContext,"Tài khoản hoặc mật khẩu không chính xác!",Toast.LENGTH_LONG).show()
           }
        })
        binding.tvsignUp.setOnClickListener {
            goToActivity(RegisterAcitvity::class.java, null,  null )
        }
    }
}