package com.duongtung.cookingman.adapter

import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemShoppingBinding
import com.duongtung.cookingman.model.FoodIngredient

class ShoppingListAdapter  : BaseAdapter<FoodIngredient,ItemShoppingBinding>(){
    override fun getLayoutId() = R.layout.item_shopping

    override fun getIdVariable() = BR.ingredient

    override fun getIdVariableOnClick() = null

    override fun getOnClick() = null

}