package com.duongtung.cookingman.fragment.profile

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.repository.listener.IServiceRespond
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel  : BaseViewModel(){
    var adapter = RecipeAdapter()
    private var arrmyRecipe = MutableLiveData<MutableList<Postres>>()
    private var user = MutableLiveData<LoginRes>()
    fun getRecipe(iduser:String) : MutableLiveData<MutableList<Postres>> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.getPostUser(iduser)
        call.enqueue(object : Callback<List<Postres>> {
            override fun onFailure(call: Call<List<Postres>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }

            override fun onResponse(call: Call<List<Postres>>, response: Response<List<Postres>>) {
                Log.d("test",response.body()!!.size.toString())
                arrmyRecipe.postValue(response.body()!!.toMutableList())
            }
        })
        return arrmyRecipe
    }
    fun getUser(iduser : String): MutableLiveData<LoginRes> {
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.getUser(iduser)
        call.enqueue(object : Callback<LoginRes>{
            override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
                user.postValue(response.body())
            }
        })
        return user
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