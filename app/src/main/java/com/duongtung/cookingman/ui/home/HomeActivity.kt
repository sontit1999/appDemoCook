package com.duongtung.cookingman.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityHomeBinding
import com.duongtung.cookingman.fragment.NewFeedsFragment

class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>(){
    override fun getViewMode() = HomeViewModel::class.java

    override fun getLayout() = R.layout.activity_home

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.recyclerSpecialFood.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclerFoodFollew.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclerFood.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        viewModel.getArrPost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
        binding.recyclerSpecialFood.setNestedScrollingEnabled(false)
    }
}
