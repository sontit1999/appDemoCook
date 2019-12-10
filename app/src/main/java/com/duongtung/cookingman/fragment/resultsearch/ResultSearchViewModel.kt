package com.duongtung.cookingman.fragment.resultsearch

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.SearchResultAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class ResultSearchViewModel : BaseViewModel(){
    var adapter = SearchResultAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    fun getArrPost(): MutableLiveData<MutableList<Post>> {

        return arrPost
    }
}