package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.ItemTypeFoodAdapter
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.TypeFood

class PreferanceViewModel : BaseViewModel(){
    var adapter = ItemTypeFoodAdapter()
    private var arrItemTypeFood = MutableLiveData<MutableList<TypeFood>>()
    fun getArrItemTypeFood(): MutableLiveData<MutableList<TypeFood>> {
        val list = listOf(
            (TypeFood(R.drawable.protein, "Vitamins", "Vitamins are organic molecules essential for an organism that are not classified as amino acids.")),
            (TypeFood(R.drawable.protein, "Minerals", "Minerals are the exogenous chemical elements indispensable for life.")),
            (TypeFood(R.drawable.protein, "Fatty acids", "Essential fatty acids (EFAs) are fatty acids that humans and other animals must ingest.")),
            (TypeFood(R.drawable.protein, "Protein", "Vitamins are organic molecules essential for an organism that are not classified."))
        ).toMutableList()
        arrItemTypeFood.postValue(list)

        return arrItemTypeFood
    }


}

