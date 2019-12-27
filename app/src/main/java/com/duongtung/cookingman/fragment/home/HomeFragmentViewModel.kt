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
    var adapterDrink = PostHomeAdapter()
    var adapterSpecial = PostHomeAdapter()
    private var arrPost = MutableLiveData<MutableList<Postres>>()
    private var arrDink = MutableLiveData<MutableList<Postres>>()
    private var arrSpecial = MutableLiveData<MutableList<Postres>>()
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
                var list : MutableList<SlideModel>  = mutableListOf()
                for( i in response.body()!!){
                    if(!i.image.equals("") && !i.namereipe.equals(""))
                    list.add(SlideModel(i.image,i.namereipe,true))
                }
                imageList.postValue(list)
            }
        })
        return arrPost
    }
    fun getImagelist(): MutableLiveData<MutableList<SlideModel>> {
        return imageList
    }
    fun getDrink(): MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.drink
        call.enqueue(object : Callback<List<Postres>> {
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                Log.d("test",response.body()!!.size.toString())
                arrDink.postValue(response.body() as MutableList<Postres>?)
            }
        })
        return arrDink
    }
    fun getSpecial(): MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.specialFood
        call.enqueue(object : Callback<List<Postres>> {
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                Log.d("test",response.body()!!.size.toString())
                arrSpecial.postValue(response.body() as MutableList<Postres>?)
            }
        })
        return arrSpecial
    }
}