package com.duongtung.cookingman.ui.recipefood

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityRecipeBinding
import com.duongtung.cookingman.fragment.*
import com.duongtung.cookingman.ui.MapsActivity
import com.duongtung.cookingman.ui.chatdetail.DetailChatActivity
import com.duongtung.cookingman.ui.chatlist.ChatlistActivity
import com.duongtung.cookingman.ui.search.SearchActivity
import com.duongtung.cookingman.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class RecipeActivity : BaseActivity<ActivityRecipeBinding, RecipeViewModel>(){
    override fun getViewMode()  = RecipeViewModel::class.java

    override fun getLayout() = R.layout.activity_recipe

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.actionbar.iv_navigation.setOnClickListener {
            Log.d("Test","Thoát")
            finish()
        }
        binding.actionbar.tvReturn.setOnClickListener {
            Log.d("Test","Thoát")
            finish()
        }
        binding.actionbar.iv_earth.setOnClickListener {
            goToActivity(MapsActivity::class.java,null,null)
        }
        binding.actionbar.iv_search.setOnClickListener {
            goToActivity(SearchActivity::class.java,null,null)
        }

        binding.fab.setOnClickListener {
            goToActivity(ChatlistActivity::class.java,null,null)
        }

        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(DirectionFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(IngredientFoodFragment(),"INGREDIENT")
        myViewPageStateAdapter.addFragment(ReviewerFragment(),"REVIEWS")
        myViewPageStateAdapter.addFragment(RecipeFragment(),"AUTHOR")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)
    }

}
