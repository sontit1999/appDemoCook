package com.duongtung.cookingman.ui.chatdetail

import android.util.Log
import com.duongtung.cookingman.R
import androidx.lifecycle.Observer
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityDetailChatBinding
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User

class DetailChatActivity : BaseActivity<ActivityDetailChatBinding, DetailChatViewModel>(){
    override fun getViewMode() = DetailChatViewModel::class.java

    override fun getLayout() = R.layout.activity_detail_chat

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.buttonSend.setOnClickListener{
            var message = binding.edittextChatbox.text.toString();
            viewModel.adapter.addMessage(Message(message, User("Sơn tít","xxx"),"15:20",1))
            binding.reyclerviewMessageList.scrollToPosition(viewModel.adapter.itemCount-1)
        }
    }

}
