package com.duongtung.cookingman.fragment.chat

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.ListChatCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragChatBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.User

class ChatFragment  : BaseFragment<FragChatBinding,ChatViewModel>(){
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
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
               viewModel.adapter.setCallBack(object : ListChatCallback{
                   override fun onItemClick(view: View, user: User) {
                       view.findNavController().navigate(R.id.detailChatFragment)
                   }
               })
               viewModel.adapter.setList(list)
           })

    }

    override fun getLayoutId() = R.layout.frag_chat
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}