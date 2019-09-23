package com.duongtung.cookingman.fragment.chat

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragChatBinding
import com.duongtung.cookingman.fragment.PopularAuthorFragment
import com.duongtung.cookingman.fragment.home.ActionBarListener

class ChatFragment  : BaseFragment<FragChatBinding,ChatViewModel>(){
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment chat")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
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
    override fun onResume() {
        super.onResume()
        Log.d("test","on resume fragment chat")
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}