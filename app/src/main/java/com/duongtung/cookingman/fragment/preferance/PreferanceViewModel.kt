package com.duongtung.cookingman.fragment.preferance

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.ItemTypeFoodAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener
import com.duongtung.cookingman.model.TypeFood

class PreferanceViewModel : BaseViewModel(){
    var adapter = ItemTypeFoodAdapter()
    var onButtonClickListener: OnButtonClickListener? = null

    private var arrItemTypeFood = MutableLiveData<MutableList<TypeFood>>()
    fun getArrItemTypeFood(): MutableLiveData<MutableList<TypeFood>> {
        val list = listOf(
            (TypeFood(R.drawable.protein, "Vitamins", "Vitamins are organic molecules essential for an organism.",false)),
            (TypeFood(R.drawable.protein, "Minerals", "Minerals are the exogenous chemical elements indispensable for life.",true)),
            (TypeFood(R.drawable.protein, "Fatty acids", "Essential fatty acids (EFAs) are fatty acids.",false)),
            (TypeFood(R.drawable.protein, "Protein", "Vitamins are organic molecules essential for an organism .",true))
        ).toMutableList()
        arrItemTypeFood.postValue(list)

        return arrItemTypeFood
    }

    fun comfirmDone(view : View){
        onButtonClickListener!!.onButtonClicked(view,false)
    }
}

