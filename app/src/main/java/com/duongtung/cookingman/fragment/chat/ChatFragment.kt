package com.duongtung.cookingman.fragment.chat

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
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


    }

    override fun viewCreated() {
           viewModel.getArrPerson().observe(this, Observer { list->
               viewModel.adapter.setList(list)
           })
    }

    override fun getLayoutId() = R.layout.frag_chat
    override fun onResume() {
        super.onResume()
        Log.d("test","on resume fragment chat")
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}