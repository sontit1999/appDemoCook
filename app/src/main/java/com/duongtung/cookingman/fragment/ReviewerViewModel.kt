package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.CommentAdapter
import com.duongtung.cookingman.adapter.ListChatAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Comment
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

class ReviewerViewModel : BaseViewModel(){
    var adapter = CommentAdapter()
    private var arrComment = MutableLiveData<MutableList<Comment>>()
    fun getArrComment(): MutableLiveData<MutableList<Comment>> {
        var list = listOf(
            (Comment(1, User(1,"Maria ozawa","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe","5")),
            (Comment(1, User(1,"Sơn tít dz","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe Thank you for sharing recipe Thank you for sharing recipe ^^","3")),
            (Comment(1, User(1,"Chris howell","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe","2")),
            (Comment(1, User(1,"Lion messi","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe ","1")),
            (Comment(1, User(1,"Critina ronaldo","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe","4"))
        ).toMutableList()
        arrComment.postValue(list)
        return arrComment
    }
}