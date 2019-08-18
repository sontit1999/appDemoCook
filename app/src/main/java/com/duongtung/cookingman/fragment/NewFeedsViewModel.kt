package com.duongtung.cookingman.fragment

import androidx.lifecycle.MutableLiveData
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import com.duongtung.cookingman.model.Post

class NewFeedsViewModel : BaseViewModel() {
    var adapter = PostAdapter()
    private var arrPost = MutableLiveData<MutableList<Post>>()

    fun getArrPost(): MutableLiveData<MutableList<Post>> {
        val list = listOf(
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList())),
            (Post("Hamburger", "HN", "10 phút trc", ArrayList())),
            (Post("Sandwwich", "HCM", "10 phút trc", ArrayList())),
            (Post("Hot dog", "DN", "10 phút trc", ArrayList())),
            (Post("Chocolate", "HN", "10 phút trc", ArrayList())),
            (Post("Xúc xích", "HN", "10 phút trc", ArrayList()))
        ).toMutableList()
        arrPost.postValue(list)

        return arrPost
    }
//    fun initData(recyclerview: RecyclerView){
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//        (Post("Hamburger","HN","10 phút trc", ArrayList()))
//        (Post("Sandwwich","HCM","10 phút trc",ArrayList()))
//        (Post("Hot dog","DN","10 phút trc",ArrayList()))
//        (Post("Chocolate","HN","10 phút trc",ArrayList()))
//        (Post("Xúc xích","HN","10 phút trc",ArrayList()))
//
//        adapter.notifyDataSetChanged()
////        recyclerview.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL,false)
////        recyclerview.setHasFixedSize(true)
////        recyclerview.addItemDecoration(
////            DividerItemDecoration(requireContext(),
////                (recyclerview.layoutManager as LinearLayoutManager).getOrientation())
////        )
////        recyclerview.adapter = adapter
//    }
}