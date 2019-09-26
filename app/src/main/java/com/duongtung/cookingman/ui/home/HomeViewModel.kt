package com.duongtung.cookingman.ui.home

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MenuHomeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.customview.imageslide.ItemImageSlide
import com.duongtung.cookingman.model.*

class HomeViewModel : BaseViewModel(){

    var menuAdapter = MenuHomeAdapter()
    private var arrMenu = MutableLiveData<MutableList<MenuItem>>()
    private var sliderAdapter = MutableLiveData<MutableList<ItemImageSlide>>()
    fun getMenuItem() : MutableLiveData<MutableList<MenuItem>>{
       val list = listOf(
           MenuItem(-1,CookingApplication.getResource().getString(R.string.icon_account),"Social",false,0),
           MenuItem(-1,CookingApplication.getResource().getString(R.string.icon_account),"App",false,0,1),
           MenuItem(6,CookingApplication.getResource().getString(R.string.icon_setting),"Setting",false,2,1),
           MenuItem(7,CookingApplication.getResource().getString(R.string.icon_share),"Share",false,2,1),
           MenuItem(8,CookingApplication.getResource().getString(R.string.icon_info),"Information",false,2,1),
           MenuItem(0,CookingApplication.getResource().getString(R.string.icon_home),"Home",true,1),
           MenuItem(1,CookingApplication.getResource().getString(R.string.icon_news),"NewsFeed",false,1),
           MenuItem(2,CookingApplication.getResource().getString(R.string.icon_recipe),"Recipe",false,1),
           MenuItem(3,CookingApplication.getResource().getString(R.string.icon_chathome),"Chat",false,1),
           MenuItem(4,CookingApplication.getResource().getString(R.string.icon_favorite),"Favorite",false,1),
           MenuItem(5,CookingApplication.getResource().getString(R.string.icon_profile),"Profile",false,1)
        )
        arrMenu.postValue(list.toMutableList())
        return arrMenu
    }

    fun getHomeSlider() : MutableLiveData<MutableList<ItemImageSlide>>{
        val imageList = mutableListOf(
            ItemImageSlide(R.drawable.bg_home,"Bánh trung thu nhân đậu xanh","Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line.")
            ,ItemImageSlide(R.drawable.food,"Bánh trung thu hai trứng","Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line.")
            ,ItemImageSlide(R.drawable.bg_home,"Bánh trung thu chay","Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line.")
        )
        sliderAdapter.postValue(imageList)
        return sliderAdapter
    }
}