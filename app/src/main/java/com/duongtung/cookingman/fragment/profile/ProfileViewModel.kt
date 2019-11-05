package com.duongtung.cookingman.fragment.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.repository.listener.IServiceRespond
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class ProfileViewModel  : BaseViewModel(){
    var adapter = RecipeAdapter()
    private var arrmyRecipe = MutableLiveData<MutableList<Recipe>>()

    fun getRecipe() : MutableLiveData<MutableList<Recipe>> {
        BaseRepository.instance.getResponde(CookingApplication.serviceApi.getDataRecipe(),object :
            IServiceRespond<MutableList<Recipe>> {
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