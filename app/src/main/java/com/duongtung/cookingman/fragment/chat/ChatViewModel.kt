package com.duongtung.cookingman.fragment.chat

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.ListChatAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class ChatViewModel : BaseViewModel(){
    var adapter = ListChatAdapter()
    private var arrPerson = MutableLiveData<MutableList<User>>()
    fun getArrPerson(): MutableLiveData<MutableList<User>> {
        val list = listOf(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
            User(
                1,
                "Sơn tít dz",
                "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
            ),
            User(
                1,
                "Sơn tít dz",
                "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
            ),
            User(
                1,
                "Sơn tít dz",
                "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
            ),
            User(
                1,
                "Sơn tít dz",
                "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
            ),
            User(
                    1,
            "Sơn tít dz",
            "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
        ),
        User(
            1,
            "Sơn tít dz",
            "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
        ),
        User(
            1,
            "Sơn tít dz",
            "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
        ),
        User(
            1,
            "Sơn tít dz",
            "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
        ),
        User(
            1,
            "Sơn tít dz",
            "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
        )
        ).toMutableList()
        arrPerson.postValue(list)

        return arrPerson
    }
}