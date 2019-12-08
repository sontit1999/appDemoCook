package com.duongtung.cookingman.fragment.newfeed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.BaseApplication
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.repository.listener.IServiceRespond
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class NewFeedsViewModel : BaseViewModel() {
    var adapter = PostAdapter()
    private var arrPost = MutableLiveData<MutableList<Postres>>()
    fun getArrPost(): MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.post
        call.enqueue(object : Callback<List<Postres>>{
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
               Log.d("test",response.body()!!.size.toString())
                arrPost.postValue(response.body()!!.toMutableList())
            }
        })
        return arrPost
    }
}