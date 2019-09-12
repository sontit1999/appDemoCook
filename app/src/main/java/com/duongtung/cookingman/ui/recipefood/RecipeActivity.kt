package com.duongtung.cookingman.ui.recipefood


import android.util.Log
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityRecipeBinding
import com.duongtung.cookingman.fragment.*
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.ui.MapsActivity
import com.duongtung.cookingman.ui.chatlist.ChatlistActivity
import com.duongtung.cookingman.ui.search.SearchActivity

import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeViewModel>(){
    override fun getViewMode()  = RecipeViewModel::class.java

    override fun getLayout() = R.layout.activity_recipe

    override fun setBindingViewModel() {
        Glide.with(baseContext).load(intent.getStringExtra("image")).into(binding.ivBanner)
        binding.viewmodel = viewModel
        binding.actionbar.tvReturn.setOnClickListener { finish() }
        binding.actionbar.tvReturn.setOnClickListener {
            Log.d("Test","Thoát")
            finish()
        }
        binding.actionbar.tvEarth.setOnClickListener {
            goToActivity(MapsActivity::class.java,null,null)
        }
        binding.actionbar.tvSearch.setOnClickListener {
            goToActivity(SearchActivity::class.java,null,null)
        }

        binding.fab.setOnClickListener {
            goToActivity(ChatlistActivity::class.java,null,null)
        }

        binding.actionbar.tvReturn.setOnClickListener {
            Log.d("Test","Thoát")
            finish()
        }
        binding.actionbar.tvEarth.setOnClickListener {
            goToActivity(MapsActivity::class.java,null,null)
        }
        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(DirectionFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(IngredientFoodFragment(),"INGREDIENT")
        myViewPageStateAdapter.addFragment(ReviewerFragment(),"REVIEWS")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)
    }

}
