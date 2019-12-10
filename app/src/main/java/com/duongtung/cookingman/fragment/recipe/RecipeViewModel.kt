package com.duongtung.cookingman.fragment.recipe

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.adapter.MyRecipeAdapter
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.repository.listener.IServiceRespond
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.service.RecipeAPIs
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeViewModel : BaseViewModel() {
    var adapter = RecipeAdapter()
    private var arrmyPost = MutableLiveData<MutableList<Postres>>()

    fun getpost() : MutableLiveData<MutableList<Postres>> {
            val retrofit = APIClient.getClient()
            val callapi = retrofit.create(DemoApi::class.java)
            val idadmin = "1"
            val call = callapi.getPostUser(idadmin)
            call.enqueue(object : Callback<List<Postres>> {
                override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                    Log.d("test",t.message.toString())
                }

                override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                    Log.d("test",response.body()!!.size.toString())
                    arrmyPost.postValue(response.body()!!.toMutableList())
                }
            })
        return arrmyPost
        }

    }
