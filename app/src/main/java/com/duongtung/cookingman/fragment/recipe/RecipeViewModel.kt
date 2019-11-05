package com.duongtung.cookingman.fragment.recipe

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.adapter.MyRecipeAdapter
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.repository.listener.IServiceRespond
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.service.RecipeAPIs
import com.duongtung.cookingman.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeViewModel : BaseViewModel() {
    var adapter = MyRecipeAdapter()
    private var arrmyRecipe = MutableLiveData<MutableList<Recipe>>()

    fun getRecipe() : MutableLiveData<MutableList<Recipe>> {
        BaseRepository.instance.getResponde(CookingApplication.serviceApi.getDataRecipe(),object : IServiceRespond<MutableList<Recipe>>{
            override fun onSuccess(result: MutableList<Recipe>) {
                Log.d("test", result.toString())
                arrmyRecipe.postValue(result)
            }

            override fun onError(message: String) {
                Log.d("test", message)
            }

        })
        return arrmyRecipe
    }
}