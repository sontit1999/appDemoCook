package com.duongtung.cookingman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseMultiViewHolderAdapter
import com.duongtung.cookingman.databinding.NavMenuItemBinding
import com.duongtung.cookingman.databinding.NavMenuItemTitleBinding
import com.duongtung.cookingman.model.MenuItem

class MenuHomeAdapter : BaseMultiViewHolderAdapter<MenuItem>() {
    object MenuHomeConstance {
        @JvmStatic
        var TITLE = 0
        @JvmStatic
        var ACCOUNT_SETTING = 1
        @JvmStatic
        var OTHER_SETTING = 2
    }
    lateinit var otherbinding: NavMenuItemBinding
    lateinit var binding: NavMenuItemBinding
    lateinit var titleBinding: NavMenuItemTitleBinding
    override fun createBinding(parent: ViewGroup, viewType: Int): BaseViewMultiHolder<MenuItem> {
        if (viewType == MenuHomeConstance.TITLE) {
            titleBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.nav_menu_item_title, parent, false
            )
            return BaseViewMultiHolder(titleBinding)
        } else if (viewType == MenuHomeConstance.ACCOUNT_SETTING) {
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.nav_menu_item, parent, false
            )
            return BaseViewMultiHolder(binding)
        }
        otherbinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.nav_menu_item, parent, false
        )
        return BaseViewMultiHolder(otherbinding)
    }

    override fun getVariableId() = mutableListOf(BR.item,BR.item,BR.item)

    override fun getIdVariableOnClick() = mutableListOf(null, BR.callBack,BR.callBack)

    override fun getOnClick() = MenuCallBack()

}
