package com.duongtung.cookingman.fragment.favorite

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.FavoriteAdapter
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class FavoriteViewModel  : BaseViewModel(){
    var adapter = FavoriteAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    fun getArrPost(): MutableLiveData<MutableList<Post>> {
        return arrPost
    }

}