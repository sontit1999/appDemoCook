package com.duongtung.cookingman.model

import com.duongtung.cookingman.base.repository.data.DataRespond
import java.io.Serializable

data class Postres(val idphoto: String,val namereipe:String,val caption:String,val image:String,val timecomplete:String,val ingredient:String,val howtocook:String,val userid:Int,val menuid:Int,val nickname:String,val linkavatar:String,val timepost:String,val description:String) :
    Serializable