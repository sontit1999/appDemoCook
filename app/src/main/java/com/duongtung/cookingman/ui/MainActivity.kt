package com.duongtung.cookingman.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityMainBinding
import com.duongtung.cookingman.fragment.NewFeedsFragment

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){
    override fun getViewMode() = MainViewModel::class.java

    override fun getLayout() = R.layout.activity_main

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        loadFragment(NewFeedsFragment())
    }

    private fun loadFragment(fragment : Fragment){
        val fragmentManager : FragmentManager = supportFragmentManager
        val transition : FragmentTransaction = fragmentManager.beginTransaction()
        transition.replace(R.id.containerBangtin,fragment)
        transition.commit()
    }
}
