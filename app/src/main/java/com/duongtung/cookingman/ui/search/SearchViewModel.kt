package com.duongtung.cookingman.ui.search

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.SearchRecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class SearchViewModel() : BaseViewModel() {
    var adapter = SearchRecipeAdapter()
    private var arrRecipe = MutableLiveData<MutableList<RecipeFood>>()
    // thường thì em viết trên activity là recyvleview.setAdapter(list)
    // phương thức MutableLiveData thể hiện lăng nghe thay đổi từ data
    //MutableList  = ListView bên java chỉ khác serial thui
    // toMutableList kiểu như convert từ list về MutableList
    // postValue() là kiểu update của MutableList arrPost giống như set giá trị vào arrPost để đẩy lên trên ý
    fun getArrRecipe(): MutableLiveData<MutableList<RecipeFood>> {
        var list = listOf(
            RecipeFood(
                "Chocolate",
                "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                listOf(
                    FoodIngredient("Cà chua", "xxxx", "200", "quả")
                ),
                "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
            ),
            RecipeFood(
                "Chocolate",
                "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                listOf(
                    FoodIngredient("Cà chua", "xxxx", "200", "quả")
                ),
                "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
            ),
            RecipeFood(
                "Chocolate",
                "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                listOf(
                    FoodIngredient("Cà chua", "xxxx", "200", "quả")
                ),
                "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
            )

        ).toMutableList()
        arrRecipe.postValue(list)

        return arrRecipe
    }

}