package com.duongtung.cookingman.ui.home

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MenuHomeAdapter
import com.duongtung.cookingman.adapter.PostHomeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class HomeViewModel : BaseViewModel(){

    var menuAdapter = MenuHomeAdapter()
    private var arrMenu = MutableLiveData<MutableList<MenuItem>>()

    fun getMenuItem() : MutableLiveData<MutableList<MenuItem>>{
       val list = listOf(
           MenuItem(-1,CookingApplication.getResource().getString(R.string.icon_account),"Social",false,0),
           MenuItem(0,CookingApplication.getResource().getString(R.string.icon_home),"Home",true,1),
           MenuItem(1,CookingApplication.getResource().getString(R.string.icon_news),"NewsFeed",false,1),
           MenuItem(2,CookingApplication.getResource().getString(R.string.icon_recipe),"Recipe",false,1),
           MenuItem(3,CookingApplication.getResource().getString(R.string.icon_chathome),"Chat",false,1),
           MenuItem(4,CookingApplication.getResource().getString(R.string.icon_favorite),"Favorite",false,1),
           MenuItem(5,CookingApplication.getResource().getString(R.string.icon_profile),"Profile",false,1),
           MenuItem(-1,CookingApplication.getResource().getString(R.string.icon_account),"App",false,0),
           MenuItem(6,CookingApplication.getResource().getString(R.string.icon_setting),"Setting",false,2),
           MenuItem(7,CookingApplication.getResource().getString(R.string.icon_share),"Share",false,2),
           MenuItem(8,CookingApplication.getResource().getString(R.string.icon_info),"Information",false,2)
       )
        arrMenu.postValue(list.toMutableList())
        return arrMenu
    }
}