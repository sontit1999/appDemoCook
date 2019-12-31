package com.duongtung.cookingman.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginEmailViewModel  : BaseViewModel(){
    private var statusLogin = MutableLiveData<LoginRes>()
    fun login(email:String,password:String){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.login(email,password)
        call.enqueue(object : Callback<LoginRes>{
            override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                Log.d("aaaa",t.message.toString())
            }

            override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
                Log.d("aaaa",response.body()!!.toString())
                statusLogin.postValue(response.body()!!)
            }
        })
    }
    fun getStauslogin(): MutableLiveData<LoginRes> {
        statusLogin.postValue(LoginRes("xxx","fail","fail","fail","fail","fail","fail","fail"))
        return statusLogin
    }

}