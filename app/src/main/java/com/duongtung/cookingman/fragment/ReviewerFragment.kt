package com.duongtung.cookingman.fragment
import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragReviewerBinding
import com.duongtung.cookingman.model.User
import com.duongtung.cookingman.ui.profile.ProfileActivity
import org.w3c.dom.Comment

class ReviewerFragment : BaseFragment<FragReviewerBinding,ReviewerViewModel>(){
    override fun getClassViewMode() = ReviewerViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recyclerComment.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        binding.ivAvatar.setOnClickListener{
            var intent = Intent(activity,ProfileActivity::class.java)
            intent.putExtra("iduser","1")
            startActivity(intent)
        }
        binding.tvSend.setOnClickListener {
            var content = binding.edtCommnet.text.toString()
            viewModel.getArrComment().observe(this, Observer { list->
                list.add(com.duongtung.cookingman.model.Comment(1, User(1,"Nà ní","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),
                    content,"5"))
                viewModel.adapter.setList(list)
                binding.recyclerComment.scrollToPosition(list.size-1)
            })
            binding.edtCommnet.setText("")
        }
    }

    override fun viewCreated() {
          viewModel.getArrComment().observe(this, Observer { list->
              viewModel.adapter.setList(list)
          })
    }

    override fun getLayoutId() = R.layout.frag_reviewer
   // a chỉ e cái bind image đi a
}