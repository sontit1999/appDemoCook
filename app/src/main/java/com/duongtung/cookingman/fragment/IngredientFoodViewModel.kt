package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.IngredientAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.FoodIngredient

class IngredientFoodViewModel  : BaseViewModel(){
    var adapter = IngredientAdapter()
    private var arrIngredient = MutableLiveData<MutableList<FoodIngredient>>()
    fun getArrIngredient(): MutableLiveData<MutableList<FoodIngredient>> {
        val list = listOf(
            (FoodIngredient("Fresh Lemon","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnWNgmjgg6bVQMXxCjvHOp0JAzJF9CFLXWCgIZ1FeNYokMEB3n","200"," Quả")),
            (FoodIngredient("Icream","https://www.thespruceeats.com/thmb/r_1v-wduUI3_4sJAR-EO1PKu6bw=/2048x1152/smart/filters:no_upscale()/perfect-banana-split-recipe-305712-13_preview-5b2bd062ba61770054b59b85.jpeg","300","cái")),
            (FoodIngredient("Salt","https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/5/7/9/9/1159975-1-eng-GB/Study-identifies-quick-and-simple-test-for-salt-levels-in-food_wrbm_large.jpg","500","gram")),
            (FoodIngredient("Potato","https://www.texanerin.com/content/uploads/2011/10/potato-wedges-6-650x975.jpg","600","quả")),
            (FoodIngredient("Sugar","https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/3/2/9/1/5931923-1-eng-GB/Sugary-foods-advertising-ban-the-first-step-to-reducing-obesity_wrbm_large.jpg","700","gram"))
        ).toMutableList()
        arrIngredient.postValue(list)

        return arrIngredient
    }

}