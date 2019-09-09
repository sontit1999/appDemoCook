package com.duongtung.cookingman.fragment

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding
import com.duongtung.cookingman.ui.MainActivity
import com.duongtung.cookingman.ui.MapsActivity
import com.duongtung.cookingman.ui.recipefood.RecipeActivity
import kotlinx.android.synthetic.main.item_post.*

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