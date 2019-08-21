package com.duongtung.cookingman.fragment


import android.content.Intent
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginPreferanceBinding
import com.duongtung.cookingman.ui.MainActivity


class PreferanceFragment : BaseFragment<FragLoginPreferanceBinding,PreferanceViewModel>(){
    override fun getClassViewMode() = PreferanceViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.ivBtdone.setOnClickListener {
            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun viewCreated() {
        viewModel.getArrItemTypeFood().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
   }

    override fun getLayoutId() = R.layout.frag_login_preferance

}