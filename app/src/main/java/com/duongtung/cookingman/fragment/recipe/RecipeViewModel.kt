package com.duongtung.cookingman.fragment.recipe

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class RecipeViewModel : BaseViewModel() {
    var adapter = RecipeAdapter()
    private var arrRecipe = MutableLiveData<MutableList<Post>>()
    fun getArrRecipe(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ), RecipeFood(
                    "Summer Salad",
                    "http://images.media-allrecipes.com/userphotos/960x960/6539094.jpg",
                    listOf(
                        FoodIngredient("Cà chua", "xxxx", "200", "quả")
                    ),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ), "Hamburger", "HN", listOf(
                    Comment(1, User(1, "Sơn dz", "xxxx"), "Món này rất là ngon", "4")
                )
            )),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ), RecipeFood(
                    "Chicken Satay",
                    "https://www.countryandtownhouse.co.uk/wp-content/uploads/2016/06/Chicken-Satay-Eat-Beautiful-Wendy-Rowe.jpg",
                    listOf(
                        FoodIngredient("Cà chua", "xxxx", "200", "quả")
                    ),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ), "Hamburger", "HN", listOf(
                    Comment(1, User(1, "Sơn dz", "xxxx"), "Món này rất là ngon", "4")
                )
            )),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ), RecipeFood(
                    "Pizaa olawsa",
                    "https://theviewfromgreatisland.com/wp-content/uploads/2013/04/Beautiful-Breakfast-Tart-image-10.jpg",
                    listOf(
                        FoodIngredient("Cà chua", "xxxx", "200", "quả")
                    ),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ), "Hamburger", "HN", listOf(
                    Comment(1, User(1, "Sơn dz", "xxxx"), "Món này rất là ngon", "4")
                )
            )),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ), RecipeFood(
                    "Apple cake",
                    "https://i.ytimg.com/vi/pluy_njmu9g/maxresdefault.jpg",
                    listOf(
                        FoodIngredient("Cà chua", "xxxx", "200", "quả")
                    ),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ), "Hamburger", "HN", listOf(
                    Comment(1, User(1, "Sơn dz", "xxxx"), "Món này rất là ngon", "4")
                )
            )),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ), RecipeFood(
                    "Elmlea charroa royal",
                    "https://i.pinimg.com/originals/e6/9d/c0/e69dc089cc27158a07b4e50609a59372.jpg",
                    listOf(
                        FoodIngredient("Cà chua", "xxxx", "200", "quả")
                    ),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ), "Hamburger", "HN", listOf(
                    Comment(1, User(1, "Sơn dz", "xxxx"), "Món này rất là ngon", "4")
                )
            ))
        ).toMutableList()
        arrRecipe.postValue(list)

        return arrRecipe
    }
}