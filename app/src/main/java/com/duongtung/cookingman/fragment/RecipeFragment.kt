package com.duongtung.cookingman.fragment

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentRecipeBinding

class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel> (){
    private lateinit var adapter : RecipeAdapter
    override fun getClassViewMode() = RecipeViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        adapter = RecipeAdapter()
        binding.recyclerviewRecipe.adapter = adapter
        viewModel.getArrRecipe().observe(this, Observer { list ->
            adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe
}