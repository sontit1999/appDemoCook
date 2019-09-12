package com.duongtung.cookingman.ui

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityMainBinding
import com.duongtung.cookingman.fragment.NewFeedsFragment
import com.duongtung.cookingman.fragment.RecipeFragment
import com.duongtung.cookingman.ui.recipefood.RecipeActivity
import com.duongtung.cookingman.ui.search.SearchActivity
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){
    private lateinit var  txt: TextView
    override fun getViewMode() = MainViewModel::class.java

    override fun getLayout() = R.layout.activity_main

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        loadFragment(NewFeedsFragment())

        binding.containerActionbar.iv_logo.setOnClickListener {
            loadFragment(RecipeFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        val fragmentManager : FragmentManager = supportFragmentManager
        val transition : FragmentTransaction = fragmentManager.beginTransaction()
        transition.replace(R.id.containerBangtin,fragment)
        transition.commit()
    }

}
