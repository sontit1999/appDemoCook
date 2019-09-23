package com.duongtung.cookingman.ui.profile
import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class ProfileViewModel : BaseViewModel() {
    var adapter = RecipeAdapter()
    private var arrRecipe = MutableLiveData<MutableList<Post>>()
    fun getArrRecipe(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời")),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời")),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời")),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời")),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời")),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời"))
        ).toMutableList()
        arrRecipe.postValue(list)

        return arrRecipe
    }
}