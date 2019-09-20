package com.duongtung.cookingman.fragment.home

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostHomeAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.*

class HomeFragmentViewModel : BaseViewModel(){
    var adapter = PostHomeAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()
    fun getArrPost(): MutableLiveData<MutableList<Post>> {
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
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4"))
            )),

            (Post(
                User(
                    1,
                    "Ronaldo",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ),
                RecipeFood(
                    "Xuxi",
                    "https://data.whicdn.com/images/91274239/large.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy ",
                "1 phú trước",
                emptyList()
            )),
            (Post(
                User(
                    1,
                    "Lion messi",
                    "https://4.bp.blogspot.com/-rdutuy5nybE/W-eWmiUsaiI/AAAAAAAACNI/7Blm2rXO0q0Qq2EfG9y_S1JOVhPE9WZwwCLcBGAs/s1600/36338093_193279504847884_616363283405864960_o.jpg"
                ),
                RecipeFood(
                    "pizza",
                    "http://www.traveller.com.au/content/dam/images/1/2/5/o/c/2/image.gallery.articleLeadwide.620x349.125ouh.png/1418345036259.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_1024/https://notintop100.com/wp-content/uploads/2018/03/girl-xinh-4k.jpg"), "Món này rất là ngon", "4"))
            )),
            (Post(
                User(
                    1,
                    "Sơn đẹp trai",
                    "http://pic.win007.com/Files/bongdalu/GetPic/e93902fa-df9a-4795-a3ea-5a87af0fb0d2.jpg"
                ),
                RecipeFood(
                    "Bánh rán",
                    "http://www.oprah.com/g/image-resizer?width=670&link=http://static.oprah.com/images/201302/orig/201302-orig-beautiful-chicken-600x411.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                " lưu xá hòa chính chương mỹ hà nội",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://anhdephd.com/wp-content/uploads/2017/10/hinh-anh-gai-Thai-Lan-xinh-xan-3.jpg"), "Món này rất là ngon", "4"))
            )),
            (Post(
                User(
                    1,
                    "Sơn tít dz",
                    "https://static2.yan.vn/YanNews/2167221/201806/20180610-052145-13.jpg"
                ),
                RecipeFood(
                    "Chocolate",
                    "https://assets3.thrillist.com/v1/image/1782498/size/tmg-article_default_mobile.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://anhdephd.com/wp-content/uploads/2017/10/hinh-anh-gai-Thai-Lan-xinh-xan-3.jpg"), "Món này rất là ngon", "4"))
            )),
            (Post(
                User(
                    1,
                    "Ronaldo",
                    "https://i.a4vn.com/2018/12/12/gai-dep-thai-lan-nhung-hot-girl-xinh-nhat-xu-chua-vang-d70083.jpg"
                ),
                RecipeFood(
                    "Xuxi",
                    "https://data.whicdn.com/images/91274239/large.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://anhdephd.com/wp-content/uploads/2017/10/hinh-anh-gai-Thai-Lan-xinh-xan-3.jpg"), "Món này rất là ngon", "4"))
            )),
            (Post(
                User(
                    1,
                    "Lion messi ahahahaha",
                    "https://4.bp.blogspot.com/-rdutuy5nybE/W-eWmiUsaiI/AAAAAAAACNI/7Blm2rXO0q0Qq2EfG9y_S1JOVhPE9WZwwCLcBGAs/s1600/36338093_193279504847884_616363283405864960_o.jpg"
                ),
                RecipeFood(
                    "pizza",
                    "http://www.traveller.com.au/content/dam/images/1/2/5/o/c/2/image.gallery.articleLeadwide.620x349.125ouh.png/1418345036259.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://anhdephd.com/wp-content/uploads/2017/10/hinh-anh-gai-Thai-Lan-xinh-xan-3.jpg"), "Món này rất là ngon", "4"))
            )),
            (Post(
                User(
                    1,
                    "Sơn đẹp trai ahihihihih",
                    "http://pic.win007.com/Files/bongdalu/GetPic/e93902fa-df9a-4795-a3ea-5a87af0fb0d2.jpg"
                ),
                RecipeFood(
                    "Bánh rán",
                    "http://www.oprah.com/g/image-resizer?width=670&link=http://static.oprah.com/images/201302/orig/201302-orig-beautiful-chicken-600x411.jpg",
                    listOf(FoodIngredient("Cà chua", "xxxx", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phú trước",
                listOf(Comment(1, User(1, "Sơn dz", "https://anhdephd.com/wp-content/uploads/2017/10/hinh-anh-gai-Thai-Lan-xinh-xan-3.jpg"), "Món này rất là ngon", "4"))
            ))

        ).toMutableList()
        arrPost.postValue(list)

        return arrPost
    }
}