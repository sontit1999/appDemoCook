package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemDirectionBinding
import com.duongtung.cookingman.model.Direction

class DirectionAdapter  : BaseAdapter<Direction,ItemDirectionBinding>(){
    override fun getLayoutId() = R.layout.item_direction

    override fun getIdVariable() = BR.direction

    override fun getIdVariableOnClick() = null

    override fun getOnClick() = null

}