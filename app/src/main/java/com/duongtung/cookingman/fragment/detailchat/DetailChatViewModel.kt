package com.duongtung.cookingman.fragment.detailchat

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.MessageAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User

class DetailChatViewModel  : BaseViewModel(){
    var adapter = MessageAdapter()
    private var arrMessage = MutableLiveData<MutableList<Message>>()
    fun getArrMessage(): MutableLiveData<MutableList<Message>> {
        val list = listOf(
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0)
        ).toMutableList()
        arrMessage.postValue(list)

        return arrMessage
    }
}