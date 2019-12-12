package com.duongtung.cookingman.fragment.resultsearch

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.SearchResultAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultSearchViewModel : BaseViewModel(){
    var adapter = SearchResultAdapter()
    private var arrPost = MutableLiveData<MutableList<Postres>>()
    fun getArrPost(): MutableLiveData<MutableList<Postres>> {
        return arrPost
    }
    fun search(keyword:String){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.searchPost(keyword)
        call.enqueue(object : Callback<List<Postres>> {
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                arrPost.postValue(response.body()!!.reversed().toMutableList())
            }
        })
    }
    fun addFavorite(idpost:String,context: Context){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.addFavorite(CurentUser.user.id,idpost)
        call.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(context,"Đã thích!", Toast.LENGTH_LONG).show()
            }
        })
    }
}