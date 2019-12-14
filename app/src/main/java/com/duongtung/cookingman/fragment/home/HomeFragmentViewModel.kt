package com.duongtung.cookingman.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.denzcoskun.imageslider.models.SlideModel
import com.duongtung.cookingman.adapter.PostHomeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel : BaseViewModel(){
    var adapter = PostHomeAdapter()
    private var arrPost = MutableLiveData<MutableList<Postres>>()
    private var imageList = MutableLiveData<MutableList<SlideModel>>()
    fun getArrPost(): MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.post
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
    fun getImagelist(): MutableLiveData<MutableList<SlideModel>> {
        var list = listOf<SlideModel>(
            SlideModel("https://1.bp.blogspot.com/-GUZsgr8my50/XJUWOhyHyaI/AAAAAAAABUo/bljp3LCS3SUtj-judzlntiETt7G294WcgCLcBGAs/s1600/fox.jpg", "Foxes live wild in the city.", true),
            SlideModel("https://2.bp.blogspot.com/-CyLH9NnPoAo/XJUWK2UHiMI/AAAAAAAABUk/D8XMUIGhDbwEhC29dQb-7gfYb16GysaQgCLcBGAs/s1600/tiger.jpg","Sơn dz"),
            SlideModel("https://3.bp.blogspot.com/-uJtCbNrBzEc/XJUWQPOSrfI/AAAAAAAABUs/ZlReSwpfI3Ack60629Rv0N8hSrPFHb3TACLcBGAs/s1600/elephant.jpg", "The population of elephants is decreasing in the world.")
        ).toMutableList()
        imageList.postValue(list)
        return imageList
    }
}