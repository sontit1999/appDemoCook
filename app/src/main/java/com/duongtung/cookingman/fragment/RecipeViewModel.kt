package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class RecipeViewModel : BaseViewModel(){
    var adapter = RecipeAdapter()
    private  var arrRecipe = MutableLiveData<MutableList<Post>>()
    fun getArrRecipe(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post(User(1,"Sơn tít dz","https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"), RecipeFood("Chocolate","http://streaming1.danviet.vn/upload/2-2017/images/2017-05-14/149471116414590-nhac-kheo-hoang-kieu-ngoc-trinh-can-ca-tienlan-tinh_231428248.jpg" , listOf(FoodIngredient("Cà chua","xxxx","200","quả")),"Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."), "Hamburger", "HN", listOf(Comment(1, User(1,"Sơn dz","xxxx"),"Món này rất là ngon","4")))),
            (Post(User(1,"Sơn tít dz","https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"), RecipeFood("Chocolate","http://streaming1.danviet.vn/upload/2-2017/images/2017-05-14/149471116414590-nhac-kheo-hoang-kieu-ngoc-trinh-can-ca-tienlan-tinh_231428248.jpg" , listOf(FoodIngredient("Cà chua","xxxx","200","quả")),"Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."), "Hamburger", "HN", listOf(Comment(1, User(1,"Sơn dz","xxxx"),"Món này rất là ngon","4")))),
            (Post(User(1,"Sơn tít dz","https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"), RecipeFood("Chocolate","http://streaming1.danviet.vn/upload/2-2017/images/2017-05-14/149471116414590-nhac-kheo-hoang-kieu-ngoc-trinh-can-ca-tienlan-tinh_231428248.jpg" , listOf(FoodIngredient("Cà chua","xxxx","200","quả")),"Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."), "Hamburger", "HN", listOf(Comment(1, User(1,"Sơn dz","xxxx"),"Món này rất là ngon","4")))),
            (Post(User(1,"Sơn tít dz","https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"), RecipeFood("Chocolate","http://streaming1.danviet.vn/upload/2-2017/images/2017-05-14/149471116414590-nhac-kheo-hoang-kieu-ngoc-trinh-can-ca-tienlan-tinh_231428248.jpg" , listOf(FoodIngredient("Cà chua","xxxx","200","quả")),"Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."), "Hamburger", "HN", listOf(Comment(1, User(1,"Sơn dz","xxxx"),"Món này rất là ngon","4")))),
            (Post(User(1,"Sơn tít dz","https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"), RecipeFood("Chocolate","http://streaming1.danviet.vn/upload/2-2017/images/2017-05-14/149471116414590-nhac-kheo-hoang-kieu-ngoc-trinh-can-ca-tienlan-tinh_231428248.jpg" , listOf(FoodIngredient("Cà chua","xxxx","200","quả")),"Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."), "Hamburger", "HN", listOf(Comment(1, User(1,"Sơn dz","xxxx"),"Món này rất là ngon","4"))))
        ).toMutableList()
        arrRecipe.postValue(list)

        return arrRecipe
    }
}