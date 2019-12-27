package com.duongtung.cookingman.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel  : BaseViewModel(){
    var statusRegister = MutableLiveData<String>()
    fun register(mail: String,pass: String,nickname: String,des: String,avatar: String){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.Register(mail,pass,nickname,des,avatar)
        call.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
               statusRegister.postValue(response.body().toString())
            }
        })
    }
    fun getsStatus(): MutableLiveData<String> {
        statusRegister.postValue("aaa")
        return statusRegister
    }
}