package com.duongtung.cookingman.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySearchBinding
import com.duongtung.cookingman.model.FoodIngredient
import com.duongtung.cookingman.model.RecipeFood

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {
    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun getViewMode() = SearchViewModel::class.java

    override fun getLayout() = R.layout.activity_search

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel

        binding.recyclerSearch.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))

        viewModel.getArrRecipe().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })

        binding.run {
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //Log.d("test","beforeTextChanged")
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //Log.d("test","onTextChanged")
                }
            })
        }

    }

}
