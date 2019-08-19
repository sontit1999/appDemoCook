package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post

class RecipeViewModel : BaseViewModel(){
    private  var arrRecipe = MutableLiveData<MutableList<Post>>()
    fun getArrRecipe(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post("Sondz","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sondz","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sondz","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit","linkimg","Hamburger", "HN", "10 ago", ArrayList()))
        ).toMutableList()
        arrRecipe.postValue(list)

        return arrRecipe
    }
}