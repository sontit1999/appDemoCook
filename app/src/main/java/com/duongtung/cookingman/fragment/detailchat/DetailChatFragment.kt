package com.duongtung.cookingman.fragment.detailchat


import android.widget.Toast
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragDetailChatBinding
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User


class DetailChatFragment : BaseFragment<FragDetailChatBinding,DetailChatViewModel>() {
    override fun getClassViewMode() = DetailChatViewModel::class.java

    override fun setBindingViewModel() {
          binding.viewmodel = viewModel

            binding.tvSend.setOnClickListener {
                val string = binding.edittextChatbox.text.toString().trim()
                if(string.equals("")){
                    Toast.makeText(activity,"Message not empty!",Toast.LENGTH_LONG).show()
                }else{
                    viewModel.adapter.addElement(Message(string, User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0))
                    //viewModel.addMessage( Message(string, User(1,"sontit","http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-161.jpg"),"9.00",0))
                    binding.edittextChatbox.setText("")
                }

            }
    }

    override fun viewCreated() {
              viewModel.getArrMessage().observe(this, Observer { list->
                  viewModel.adapter.setList(list)
                  binding.reyclerviewMessageList.scrollToPosition(list.size-1)
              })


    }

    override fun getLayoutId() = R.layout.frag_detail_chat
}