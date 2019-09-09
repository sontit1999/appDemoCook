package com.duongtung.cookingman.ui.recipefood

import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityRecipeBinding
import com.duongtung.cookingman.fragment.DirectionFragment
import com.duongtung.cookingman.fragment.PopularAuthorFragment

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeViewModel>(){
    override fun getViewMode()  = RecipeViewModel::class.java

    override fun getLayout() = R.layout.activity_recipe

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel

        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(DirectionFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(DirectionFragment(),"INGREDIENT")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"REVIEWS")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"ABOUT AUTHOR")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)
    }

}
