package com.duongtung.cookingman.fragment.favorite

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.FavoriteAdapter
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteViewModel  : BaseViewModel(){
    var adapter = FavoriteAdapter()
    private var arrPost = MutableLiveData<MutableList<Postres>>()
    fun getArrPost(): MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.getFavoritepost(CurentUser.user.id)
        call.enqueue(object : Callback<List<Postres>> {
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                Log.d("test",response.body()!!.size.toString())
                arrPost.postValue(response.body()!!.reversed().toMutableList())
            }
        })
        return arrPost
    }

    fun deleteFavorite(idpost:String,context: Context){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.deleteFavorite(CurentUser.user.id,idpost)
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(context,"Đã xóa",Toast.LENGTH_LONG).show()
            }

        })
    }
}