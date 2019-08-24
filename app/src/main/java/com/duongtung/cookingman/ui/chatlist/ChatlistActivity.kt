package com.duongtung.cookingman.ui.chatlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityChatlistBinding
import com.duongtung.cookingman.fragment.PopularAuthorFragment
import com.duongtung.cookingman.ui.chatdetail.DetailChatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class ChatlistActivity : BaseActivity<ActivityChatlistBinding,ChatlistViewModel>() {
    override fun getViewMode() = ChatlistViewModel::class.java

    override fun getLayout() = R.layout.activity_chatlist

    override fun setBindingViewModel() {
        binding.viewModel = viewModel


        val myViewPageStateAdapter: MyViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Popular Author")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Recent People")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Other Author")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)
    }

}
