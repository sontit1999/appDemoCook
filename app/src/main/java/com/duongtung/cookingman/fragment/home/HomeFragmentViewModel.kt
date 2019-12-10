package com.duongtung.cookingman.fragment.home

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostHomeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class HomeFragmentViewModel : BaseViewModel(){
    var adapter = PostHomeAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    fun getArrPost(): MutableLiveData<MutableList<Post>> {

        return arrPost
    }
}