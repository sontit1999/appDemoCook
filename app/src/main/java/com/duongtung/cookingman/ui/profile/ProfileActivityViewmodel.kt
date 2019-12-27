package com.duongtung.cookingman.ui.profile

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.callback.CallbackHomeActivity
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.service.DemoApi
import com.duongtung.cookingman.ui.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivityViewmodel :BaseViewModel(){
    var adapter = RecipeAdapter()
    var user = MutableLiveData<LoginRes>()
    private var arrmyRecipe = MutableLiveData<MutableList<Postres>>()

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

    fun updateProfile(type:String,imagestring:String,context: Context){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.updateProfile(CurentUser.user.id,type,imagestring)
        call.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Toast.makeText(context,"Đã cập nhật!", Toast.LENGTH_LONG).show()
                getUser(CurentUser.user.id)
            }
        })
    }

    fun getUser(id : String){
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.getUser(id)
        call.enqueue(object : Callback<LoginRes>{
            override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
               CurentUser.user =  response.body()
            }
        })
    }

}