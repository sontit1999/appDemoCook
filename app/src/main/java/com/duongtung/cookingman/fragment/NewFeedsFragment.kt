package com.duongtung.cookingman.fragment

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding

class NewFeedsFragment : BaseFragment<FragmentNewfeedsBinding, NewFeedsViewModel>() {
//    var adapter = PostAdapter()
    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })

    }

    override fun setBindingViewModel() {
//        viewModel = NewFeedsViewModel()
        binding.viewModel = viewModel
//        binding.recyclerviewBangTin.adapter = adapter
    }

    override fun getClassViewMode() = NewFeedsViewModel::class.java

    override fun getLayoutId() = R.layout.fragment_newfeeds

//    var arrpost: ArrayList<Post> = arrayListOf()
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        var view : View = inflater.inflate(R.layout.fragment_newfeeds,container,false)
//        var recyclerview: RecyclerView = view.findViewById(R.id.recyclerviewBangTin)
//        initData(recyclerview)
//        return view
//    }
//    @SuppressLint("WrongConstant")
//    fun initData(recyclerview: RecyclerView){
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hamburger","HN","10 phút trc", ArrayList()));
//        arrpost.add(Post("Sandwwich","HCM","10 phút trc",ArrayList()));
//        arrpost.add(Post("Hot dog","DN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Chocolate","HN","10 phút trc",ArrayList()));
//        arrpost.add(Post("Xúc xích","HN","10 phút trc",ArrayList()));
//
//        adapter.notifyDataSetChanged()
//        recyclerview.layoutManager = LinearLayoutManager(context, VERTICAL,false)
//        recyclerview.setHasFixedSize(true)
//        recyclerview.addItemDecoration(DividerItemDecoration(requireContext(),
//            (recyclerview.layoutManager as LinearLayoutManager).getOrientation()))
//        recyclerview.adapter = adapter
//    }
}