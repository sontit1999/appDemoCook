package com.duongtung.cookingman.ui.chatdetail

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.MessageListaAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User

public class DetailChatViewModel : BaseViewModel(){
    val list = listOf(
            (Message("Hi , How are You", User("Sơn tít","xxxxxx"),"10:05",1)),
            (Message("Hi , I'm find .And you ?", User("Sơn tít","xxxxxx"),"10:06",2)),
            (Message("Can I ask you some questrion about IT development near here", User("Sơn tít","xxxxxx"),"10:07",1)),
            (Message("Ok.Yes of Course", User("Sơn tít","xxxxxx"),"10:08",2)),
            (Message("Ok. Babie ^^", User("Sơn tít","xxxxxx"),"10:09",1)),
            (Message("When did it happen?", User("Sơn tít","xxxxxx"),"10:10",2)),
            (Message("It happen 3 year ago ", User("Sơn tít","xxxxxx"),"10:11",2)),
            (Message("Who did develop it?", User("Sơn tít","xxxxxx"),"10:12",2)),
            (Message("Oh,sorry I don't know", User("Sơn tít","xxxxxx"),"10:13",2))
        ).toMutableList()
        var adapter = MessageListaAdapter(list)
}