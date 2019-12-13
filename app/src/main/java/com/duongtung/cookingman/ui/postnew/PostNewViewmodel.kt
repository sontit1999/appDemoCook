package com.duongtung.cookingman.ui.postnew

import android.content.Context
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
        val call = callapi.addpost(namereipe,caption,"https://phonelumi.com/wp-content/uploads/2017/01/Hinh-anh-girl-xinh-lam-hinh-nen-cho-iphone-7-25.jpg",ingredient,howtocook,CurentUser.user.id,menuid,timecomplete)
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if(response.body().toString().equals("succes")){
                    Toast.makeText(context,"Đã đăng",Toast.LENGTH_LONG).show()
                    statuspost.postValue("succes")
                }else{
                    Toast.makeText(context,"Lỗi. chưa đăng đc",Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    fun getStatus(): MutableLiveData<String> {
        return statuspost
    }
}