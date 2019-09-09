package com.duongtung.cookingman.ui.chatdetail

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.MessageListaAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User

public class DetailChatViewModel : BaseViewModel(){
    val list = listOf(
            (Message("Hi , How are You", User(1,"xxxxxx","https://i0.wp.com/3.bp.blogspot.com/-fikHLVnx-aU/XWDJjNoHwuI/AAAAAAAC2QQ/MvdQT5s9AxITGvpCnYRyexKQ8oyHh1C4ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-003.jpg?w=955&ssl=1"),"10:05")),
            (Message("Hi , I'm find .And you ?",User(2,"xxxxxx","https://i1.wp.com/2.bp.blogspot.com/-YA0KyTrqhj8/XV_3-6K4bPI/AAAAAAAC18w/-zihZQrKDCkJOw6DPpscmznL--IGNV6BACLcBGAs/s1600/XingYan-Vol.125-Sara-MrCong.com-001.jpg?w=955&ssl=1"),"10:06")),
            (Message("Can I ask you some questrion about IT development near here", User(1,"xxxxxx","https://i0.wp.com/3.bp.blogspot.com/-fikHLVnx-aU/XWDJjNoHwuI/AAAAAAAC2QQ/MvdQT5s9AxITGvpCnYRyexKQ8oyHh1C4ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-003.jpg?w=955&ssl=1"),"10:07")),
            (Message("Ok.Yes of Course", User(2,"xxxxxx","https://i1.wp.com/2.bp.blogspot.com/-YA0KyTrqhj8/XV_3-6K4bPI/AAAAAAAC18w/-zihZQrKDCkJOw6DPpscmznL--IGNV6BACLcBGAs/s1600/XingYan-Vol.125-Sara-MrCong.com-001.jpg?w=955&ssl=1"),"10:08")),
            (Message("Ok. Babie ^^", User(1,"xxxxxx","https://i0.wp.com/3.bp.blogspot.com/-fikHLVnx-aU/XWDJjNoHwuI/AAAAAAAC2QQ/MvdQT5s9AxITGvpCnYRyexKQ8oyHh1C4ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-003.jpg?w=955&ssl=1"),"10:09")),
            (Message("When did it happen?",User(2,"xxxxxx","https://i1.wp.com/2.bp.blogspot.com/-YA0KyTrqhj8/XV_3-6K4bPI/AAAAAAAC18w/-zihZQrKDCkJOw6DPpscmznL--IGNV6BACLcBGAs/s1600/XingYan-Vol.125-Sara-MrCong.com-001.jpg?w=955&ssl=1"),"10:10")),
            (Message("It happen 3 year ago ", User(1,"xxxxxx","https://i0.wp.com/3.bp.blogspot.com/-fikHLVnx-aU/XWDJjNoHwuI/AAAAAAAC2QQ/MvdQT5s9AxITGvpCnYRyexKQ8oyHh1C4ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-003.jpg?w=955&ssl=1"),"10:11")),
            (Message("Who did develop it?", User(2,"xxxxxx","https://i1.wp.com/2.bp.blogspot.com/-YA0KyTrqhj8/XV_3-6K4bPI/AAAAAAAC18w/-zihZQrKDCkJOw6DPpscmznL--IGNV6BACLcBGAs/s1600/XingYan-Vol.125-Sara-MrCong.com-001.jpg?w=955&ssl=1"),"10:12")),
            (Message("Oh,sorry I don't know", User(1,"xxxxxx","https://i0.wp.com/3.bp.blogspot.com/-fikHLVnx-aU/XWDJjNoHwuI/AAAAAAAC2QQ/MvdQT5s9AxITGvpCnYRyexKQ8oyHh1C4ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-003.jpg?w=955&ssl=1"),"10:13"))
        ).toMutableList()
        var adapter = MessageListaAdapter(list)
}