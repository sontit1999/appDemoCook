package com.duongtung.cookingman.ui.chatdetail

import android.util.Log
import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.R
import androidx.lifecycle.Observer
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityDetailChatBinding
import com.duongtung.cookingman.model.Message
import com.duongtung.cookingman.model.User
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class DetailChatActivity : BaseActivity<ActivityDetailChatBinding, DetailChatViewModel>(){

    override fun getToolbar(): Toolbar? {
        return null
    }
    override fun getViewMode() = DetailChatViewModel::class.java

    override fun getLayout() = R.layout.activity_detail_chat

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvSend.setOnClickListener{
            var message = binding.edittextChatbox.text.toString();
            viewModel.adapter.addMessage(Message(message, User(1,"xxx","https://i1.wp.com/1.bp.blogspot.com/-0PYThk9yaSE/XWDJjc5N38I/AAAAAAAC2QU/jRIuBT0aRp0c1wLp8oWyn5vFmiEMmmB3ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-002.jpg?w=955&ssl=1"),"15:20"))
            binding.reyclerviewMessageList.scrollToPosition(viewModel.adapter.itemCount-1)
            binding.edittextChatbox.setText("")
        }
        binding.tvCamera.setOnClickListener{
            viewModel.adapter.addMessage(Message("em cũng yêu anh",User(2,"Pé quỳnh","https://i1.wp.com/1.bp.blogspot.com/-0PYThk9yaSE/XWDJjc5N38I/AAAAAAAC2QU/jRIuBT0aRp0c1wLp8oWyn5vFmiEMmmB3ACLcBGAs/s1600/CANDY-Vol.072-Cris-MrCong.com-002.jpg?w=955&ssl=1"),"15:15"))
            binding.reyclerviewMessageList.scrollToPosition(viewModel.adapter.itemCount-1)
        }
        binding.actionBar.tvReturn.setOnClickListener { finish() }
    }

}
