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
           MenuItem(0,CookingApplication.getResource().getString(R.string.icon_account),"Social",0),
           MenuItem(1,CookingApplication.getResource().getString(R.string.icon_news),"NewsFeed",1),
           MenuItem(2,CookingApplication.getResource().getString(R.string.icon_recipe),"Recipe",1),
           MenuItem(3,CookingApplication.getResource().getString(R.string.icon_chathome),"Chat",1),
           MenuItem(4,CookingApplication.getResource().getString(R.string.icon_favorite),"Favorite",2),
           MenuItem(5,CookingApplication.getResource().getString(R.string.icon_profile),"Profile",2),
           MenuItem(6,CookingApplication.getResource().getString(R.string.icon_account),"App",0),
           MenuItem(7,CookingApplication.getResource().getString(R.string.icon_setting),"Setting",2),
           MenuItem(8,CookingApplication.getResource().getString(R.string.icon_share),"Share",2),
           MenuItem(9,CookingApplication.getResource().getString(R.string.icon_info),"Information",2)
       )
        arrMenu.postValue(list.toMutableList())
        return arrMenu
    }

    fun getMenuItemRecipe() : MutableLiveData<MutableList<MenuItem>>{
        val list = listOf(
            MenuItem(0,CookingApplication.getResource().getString(R.string.icon_account),"Social",0),
            MenuItem(0,CookingApplication.getResource().getString(R.string.icon_home),"Home",1),
            MenuItem(1,CookingApplication.getResource().getString(R.string.icon_news),"NewsFeed",1),
            MenuItem(3,CookingApplication.getResource().getString(R.string.icon_chathome),"Chat",1),
            MenuItem(4,CookingApplication.getResource().getString(R.string.icon_favorite),"Favorite",2),
            MenuItem(5,CookingApplication.getResource().getString(R.string.icon_profile),"Profile",2),
            MenuItem(0,CookingApplication.getResource().getString(R.string.icon_account),"App",0),
            MenuItem(7,CookingApplication.getResource().getString(R.string.icon_setting),"Setting",2),
            MenuItem(8,CookingApplication.getResource().getString(R.string.icon_share),"Share",2),
            MenuItem(9,CookingApplication.getResource().getString(R.string.icon_info),"Information",2)
        )
        arrMenu.postValue(list.toMutableList())
        return arrMenu
    }
}