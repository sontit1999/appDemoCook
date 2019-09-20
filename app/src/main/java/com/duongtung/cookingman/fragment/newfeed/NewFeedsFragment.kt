package com.duongtung.cookingman.fragment.newfeed

import android.util.Log
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding

class NewFeedsFragment : BaseFragment<FragmentNewfeedsBinding, NewFeedsViewModel>() {
    override fun viewCreated() {
        // observe lắng nghe sự thay đổi set lại lít từ dưới lên cái này của livedata rất rõ trong document android
        // vâng :D
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })

    }

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.fabADD.setOnClickListener {
            Log.d("test","Đăng tin")
        }
    }

    override fun getClassViewMode() = NewFeedsViewModel::class.java

    override fun getLayoutId() = R.layout.fragment_newfeeds
}