package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseMultiViewHolderAdapter
import com.duongtung.cookingman.callback.MenuHomeCallback
import com.duongtung.cookingman.model.MenuItem
import com.duongtung.cookingman.ui.home.HomeActivity

class MenuHomeAdapter : BaseMultiViewHolderAdapter<MenuItem>() {
    private var onMHCallback : MenuHomeCallback?=null
    fun setOnMHCallback(onMHCallback : MenuHomeCallback){
        this.onMHCallback = onMHCallback
    }
    override fun getLayoutId()= mutableListOf(R.layout.nav_menu_item_title,R.layout.nav_menu_item,R.layout.nav_menu_item)

    override fun getVariableId() = mutableListOf(BR.item,BR.item,BR.item)

    override fun getIdVariableOnClick() = mutableListOf(null, BR.callBack,BR.callBack)

    override fun getOnClick() = MenuCallBack(onMHCallback!!)
}
