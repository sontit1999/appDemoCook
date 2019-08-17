package com.duongtung.cookingman.base.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.Model.Post
import com.duongtung.cookingman.base.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragmnet_bangtin.*

class BangtinFragment : Fragment(){
    var arrpost: ArrayList<Post> = arrayListOf();
    var adapter: PostAdapter = PostAdapter(arrpost)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.fragmnet_bangtin,container,false)
        var recyclerview: RecyclerView = view.findViewById(R.id.recyclerviewBangTin)
        initData(recyclerview)
        return view
    }
    @SuppressLint("WrongConstant")
    fun initData(recyclerview: RecyclerView){
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));

        adapter.notifyDataSetChanged()
        recyclerview.layoutManager = LinearLayoutManager(context, VERTICAL,false)
        recyclerview.setHasFixedSize(true)
        recyclerview.addItemDecoration(DividerItemDecoration(requireContext(),
            (recyclerview.layoutManager as LinearLayoutManager).getOrientation()))
        recyclerview.adapter = adapter
    }
}