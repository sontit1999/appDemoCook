package com.duongtung.cookingman.fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentIngredientBinding

class IngredientFoodFragment : BaseFragment<FragmentIngredientBinding,IngredientFoodViewModel>(){
    override fun getClassViewMode() = IngredientFoodViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recyclerviewIngredient.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun viewCreated() {
        viewModel.getArrIngredient().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_ingredient

}