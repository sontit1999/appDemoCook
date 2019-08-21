package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post

class NewFeedsViewModel : BaseViewModel() {
    var adapter = PostAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    fun getArrPost(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post("Sontitdz", "linkimg", "Hamburger", "HN", "1 h trước", ArrayList())),
            (Post("Sontitzd", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontitdz", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList()))
        ).toMutableList()
        arrPost.postValue(list)

        return arrPost
    }
}