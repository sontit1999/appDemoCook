package com.duongtung.cookingman.adapter

import android.util.Log
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemIngredientBinding
import com.duongtung.cookingman.databinding.ItemIngredientBindingImpl
import com.duongtung.cookingman.model.FoodIngredient

class IngredientAdapter : BaseAdapter<FoodIngredient,ItemIngredientBinding>(){
    override fun getLayoutId()  = R.layout.item_ingredient

    override fun getIdVariable() = BR.foodingredient
}