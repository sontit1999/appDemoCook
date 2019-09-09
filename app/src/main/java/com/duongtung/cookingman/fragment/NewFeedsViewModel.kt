package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post

class NewFeedsViewModel : BaseViewModel() {
    var adapter = PostAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    // thường thì em viết trên activity là recyvleview.setAdapter(list)
    // phương thức MutableLiveData thể hiện lăng nghe thay đổi từ data
    //MutableList  = ListView bên java chỉ khác serial thui
    // toMutableList kiểu như convert từ list về MutableList
    // postValue() là kiểu update của MutableList arrPost giống như set giá trị vào arrPost để đẩy lên trên ý
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