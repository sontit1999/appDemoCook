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
                    "Bánh trung thu nhân đậu xanh",
                    "https://ameovat.com/wp-content/uploads/2016/06/cach-lam-banh-trung-thu-nhan-dau-xanh-9-220x140.jpg",
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
                    "Thịt nướng ozawa",
                    "https://ameovat.com/wp-content/uploads/2016/05/cach-uop-thit-nuong-6-220x140.jpg",
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
                    "Cá kho tương",
                    "https://cdn.eva.vn/upload/3-2019/images/2019-07-01/extra_large/1561965706-132-thumbnail.jpg",
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
                    "Lòng non sào rưa",
                    "https://pastaxi-manager.onepas.vn/content/uploads/articles/2amthuc/amthuccuocsong/monanhangngay/mon-an-hang-ngay-4.jpg",
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
                    "Cháo tim gà hạt sen",
                    "https://ameovat.com/wp-content/uploads/2019/07/ch%C3%A1o-timgaf-h%E1%BA%A1t-sen-1-220x140.jpg",
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
                    "Nộm đu đủ với thịt gà chua giòn",
                    "https://ameovat.com/wp-content/uploads/2016/04/nom-du-du-ngon-220x140.jpg",
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
                    "Bún ốc trộn giòn ngon sần sật",
                    "https://ameovat.com/wp-content/uploads/2019/08/c%C3%A1ch-l%C3%A0m-b%C3%BAn-%E1%BB%91c-tr%E1%BB%99n-11.-220x140.jpg",
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
                    "Xíu mại sốt cà chua",
                    "https://ameovat.com/wp-content/uploads/2016/07/cach-lam-xiu-mai-7-220x140.jpg",
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
                    "Nem chua rán ngon tuyệt",
                    "https://ameovat.com/wp-content/uploads/2016/04/cach-lam-nem-chua-ran-220x140.jpg",
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
                    "Bún chả obama",
                    "https://ameovat.com/wp-content/uploads/2016/04/bun-cha-Ha-Noi-ngon-220x140.jpg",
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
                    "Gà rang muối",
                    "https://ameovat.com/wp-content/uploads/2016/04/mon-ga-rang-muoi-220x140.jpg",
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
                    "Mì trộn hàn quốc",
                    "https://ameovat.com/wp-content/uploads/2019/08/mi-tron-han-quoc-1-220x140.jpg",
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
                    "Lẩu ghẹ chua cay",
                    "https://ameovat.com/wp-content/uploads/2019/07/cach-nau-lau-ghe-chua-cay-1-220x140.jpg",
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
                    "Sốt cua thơm ngon tại nhà",
                    "https://ameovat.com/wp-content/uploads/2016/04/cach-nau-sup-cua-ngon-2-220x140.jpg",
                    listOf(FoodIngredient("Cà chua", "https://happyshop.com.vn/wp-content/uploads/2018/03/TK1006-bo-do-lot-sexy-2.jpg", "200", "quả")),
                    "Food Republic’s column Ask Your Butcher seeks to answer FAQs in the world of butchery. Ethically minded butcher Bryan Mayer has opened butcher shops and restaurants and has trained butchers in the U.S. and abroad. He helped develop the renowned butcher-training program at Fleishers, where he is currently director of butchery education. In each column, Mayer tackles a pressing issue facing both meat buyers and home cooks. With the Fourth of July weekend approaching, he delves into the world of homemade hot dogs. Now that’s some serious BBQ bragging rights on the line."
                ),
                "Cầu giấy",
                "1 phút trước",
                listOf(Comment(1, User(1, "Sơn kute", "https://static1.bestie.vn/Mlog/ImageContent/201906/boc-info-hoi-gai-xinh-moi-noi-sexy-nhat-instagram-47ba8f.jpg"), "Món này rất là ngon", "4")),
                "Món này ngon tuyệt vời"))

        ).toMutableList()
        arrPost.postValue(list)

        return arrPost
    }
}