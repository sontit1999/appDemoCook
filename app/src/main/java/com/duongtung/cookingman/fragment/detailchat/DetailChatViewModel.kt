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
       var list = listOf(
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi ", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Bạn tên gì ?", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Mình tên sơn.Còn bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("mình tên quỳnh", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("um hi. bạn sinh năm bao nhiêu vậy", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("mk 99.còn bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("mình cũng 99 nè", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Bạn có ny chưa", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Mình làm gì có ny mk đang sợ ế đây này", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Really", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Yes.Bạn có muốn làm người yêu mk không", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Có hihi", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi chào bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("hi ", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Bạn tên gì ?", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Mình tên sơn.Còn bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("mình tên quỳnh", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("um hi. bạn sinh năm bao nhiêu vậy", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("mk 99.còn bạn", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("mình cũng 99 nè", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Bạn có ny chưa", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Mình làm gì có ny mk đang sợ ế đây này", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Really", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0),
            Message("Yes.Bạn có muốn làm người yêu mk không", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",1),
            Message("Có hihi", User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0)

        ).toMutableList()
        arrMessage.postValue(list)
        return arrMessage
    }
    fun addMessage(message: Message){
        var mutablelist = arrMessage.value
        mutablelist?.add(message)
        arrMessage.postValue(mutablelist)
    }

}