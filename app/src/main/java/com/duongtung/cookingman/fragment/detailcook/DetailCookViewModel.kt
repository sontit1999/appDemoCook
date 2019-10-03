package com.duongtung.cookingman.fragment.detailcook

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.CommentAdapter
import com.duongtung.cookingman.adapter.DirectionAdapter
import com.duongtung.cookingman.adapter.IngredientAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Comment
import com.duongtung.cookingman.model.Direction
import com.duongtung.cookingman.model.FoodIngredient
import com.duongtung.cookingman.model.User

class DetailCookViewModel : BaseViewModel(){
    var adapterComment = CommentAdapter()
    var adapterIngredient = IngredientAdapter()
    var adapterDirection = DirectionAdapter()
    private var arrIngredient = MutableLiveData<MutableList<FoodIngredient>>()
    private var arrComment = MutableLiveData<MutableList<Comment>>()
    private var arrDirection = MutableLiveData<MutableList<Direction>>()
    fun getArrComment(): MutableLiveData<MutableList<Comment>> {
        var list = listOf(
            (Comment(1, User(1,"Maria ozawa","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe","5")),
            (Comment(1, User(1,"Sơn tít dz","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe Thank you for sharing recipe Thank you for sharing recipe ^^","3")),
            (Comment(1, User(1,"Chris howell","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe Thank you for sharing recipe","2")),
            (Comment(1, User(1,"Lion messi","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe ","1")),
            (Comment(1, User(1,"Critina ronaldo","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),"I like it.It is very delecious.Thank you for sharing recipe","4"))
        ).toMutableList()
        arrComment.postValue(list)
        return arrComment
    }
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
    fun getArrDirection(): MutableLiveData<MutableList<Direction>> {
        val list = listOf(
            Direction("Thịt ba chỉ mua về cạo sạch lông, rửa sạch rồi ngâm trong nước muối ấm khoảng 5 phút khử mùi hôi. Sau khi làm sạch, thái miếng vuông to."),
            Direction("Cho thịt lợn thái miếng vào tô sau đó ướp cùng 2 thìa nước mắm, 1 thìa đường, ½ thìa muối, mì chính, thêm tỏi băm, hạt tiêu, 1 thìa dầu ăn sau đó đảo đều để ngấm trong 30 phút."),
            Direction("Trong lúc chờ thịt ngấm gia vị, cho trứng gà và trứng cút vào nồi luộc chín, sau đó bóc sạch vỏ để ra bát."),
            Direction("Cho đường vào chảo đun sôi, đảo đều đến khi đường có màu cánh gián, sau đó cho từ từ khoảng 1 bát tô nước đủ để kho thịt. Có thể cho thêm một chút dầu ăn vào khi đun đường để tránh bị cháy."),
            Direction("Bắc nồi lên bếp, cho một chút dầu ăn vào đun nóng sau đó cho thịt lợn đã ướp vào đảo đều cho săn lại, thêm chút xíu mắm cho món thịt kho đậm đà."),
            Direction("Tiếp đó bạn cho nước màu và nước dừa xâm xấp mặt thịt đun đến khi sôi vặn lửa nhỏ trong khoảng 1 tiếng rưỡi. Khi kho dùng thìa hớt bọt để món ăn được đẹp mắt."),
            Direction("Trước khi tắt bếp, thả trứng cút và trứng gà vào đun sôi nhỏ lửa 15 phút là trứng và thịt đã ngấm đều."),
            Direction("Sau đó bạn đã có món thịt kho tàu siêu ngon rùi :D")
        ).toMutableList()
        arrDirection.postValue(list)

        return arrDirection
    }
    fun addComment(message: Comment){
        var mutablelist = arrComment.value
        mutablelist?.add(message)
        arrComment.postValue(mutablelist)
    }
}



