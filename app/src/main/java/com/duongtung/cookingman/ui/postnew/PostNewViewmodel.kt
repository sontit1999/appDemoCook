package com.duongtung.cookingman.ui.postnew

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field

class PostNewViewmodel : BaseViewModel(){
    var statuspost = MutableLiveData<String>()
    fun addPost(namereipe:String,caption:String, image:String, ingredient:String, howtocook:String, userid:String, menuid:String, timecomplete:String,context: Context){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.addpost(namereipe,caption,image,ingredient,howtocook,CurentUser.user.id,menuid,timecomplete)
        call.enqueue(object : Callback<com.duongtung.cookingman.model.Response> {
            override fun onFailure(
                call: Call<com.duongtung.cookingman.model.Response>,
                t: Throwable
            ) {
                Log.d("ahihi","fail")
            }

            override fun onResponse(
                call: Call<com.duongtung.cookingman.model.Response>,
                response: Response<com.duongtung.cookingman.model.Response>
            ) {
                Log.d("ahihi","succes")
                statuspost.postValue("succes")
            }

        })
    }
    fun getStatus(): MutableLiveData<String> {
        return statuspost
    }

}