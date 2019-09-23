package com.duongtung.cookingman.fragment.chat

import android.graphics.Color
import androidx.fragment.app.FragmentManager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragChatBinding
import com.duongtung.cookingman.fragment.PopularAuthorFragment

class ChatFragment  : BaseFragment<FragChatBinding,ChatViewModel>(){
    override fun getClassViewMode() = ChatViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewModel = viewModel

        val myViewPageStateAdapter = MyViewPageStateAdapter(activity!!.supportFragmentManager)
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Popular Author")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Recent People")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Other Author")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)

    }

    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_chat

}