package com.duongtung.cookingman.fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragReviewerBinding

class ReviewerFragment : BaseFragment<FragReviewerBinding,ReviewerViewModel>(){
    override fun getClassViewMode() = ReviewerViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recyclerComment.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun viewCreated() {
        viewModel.getArrComment().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.frag_reviewer
   // a chỉ e cái bind image đi a
}