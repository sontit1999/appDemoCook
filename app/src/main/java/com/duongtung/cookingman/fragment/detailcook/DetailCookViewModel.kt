package com.duongtung.cookingman.fragment.detailcook

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.CommentAdapter
import com.duongtung.cookingman.adapter.DirectionAdapter
import com.duongtung.cookingman.adapter.IngredientAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCookViewModel : BaseViewModel(){
    var adapterComment = CommentAdapter()
    private var arrComment = MutableLiveData<MutableList<Comment>>()
    fun getArrComment(idpost:String): MutableLiveData<MutableList<Comment>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.getComment(idpost)
        call.enqueue(object : Callback<List<Comment>>{
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                arrComment.postValue(response.body()!!.toMutableList())
            }
        })
        return arrComment
    }
    fun addComment(content:String,postid :String,userid:String) {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.addComment(content,postid,userid)
        call.enqueue(object : Callback<Comment>{
            override fun onFailure(call: Call<Comment>, t: Throwable) {

            }

            override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                Log.d("cmt",response.body().toString())
                var listcommnet = arrComment.value
                listcommnet!!.add(response.body()!!)
                arrComment.postValue(listcommnet)
            }
        })
    }

}



