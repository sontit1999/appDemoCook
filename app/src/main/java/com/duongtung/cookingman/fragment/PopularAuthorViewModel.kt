package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.ListChatAdapter
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post

class PopularAuthorViewModel : BaseViewModel(){
    var adapter = ListChatAdapter()
    private var arrPerson = MutableLiveData<MutableList<Post>>()
    fun getArrPerson(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post("Sơn tít", "linkimg", "Hamburger", "HN", "1 h trước", ArrayList())),
            (Post("Abibe pratt", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Louit spire", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Maria ozawa", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Lion Mesi", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Keyakizaka46", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Dempagumi.inc", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Morning Musume ", "linkimg", "Hamburger", "HN", "10 ago", ArrayList())),
            (Post("Sontit", "linkimg", "Hamburger", "HN", "10 ago", ArrayList()))
        ).toMutableList()
        arrPerson.postValue(list)

        return arrPerson
    }
}