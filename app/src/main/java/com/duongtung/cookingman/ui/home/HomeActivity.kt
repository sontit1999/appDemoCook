package com.duongtung.cookingman.ui.home

import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.databinding.ActivityHomeBinding
import com.duongtung.cookingman.databinding.NavMenuBinding
import com.google.android.gms.common.util.DataUtils
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>(){
    override fun getToolbar(): Toolbar? = binding.actionbar.tbBase

    override fun getViewMode() = HomeViewModel::class.java

    override fun getLayout() = R.layout.activity_home

    override fun setBindingViewModel() {
        action = arrayListOf(binding.actionbar.tvRight,binding.actionbar.tvCenter)
        binding.viewModel = viewModel
        val bindingMenu = DataBindingUtil.findBinding<NavMenuBinding>(binding.navView.navMenu)
        bindingMenu!!.viewModel = viewModel

        binding.recyclerRamadan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclerfollow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclerFoodStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclervegetarian.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        viewModel.getArrPost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
        viewModel.getMenuItem().observe(this, Observer { list -> viewModel.menuAdapter.setList(list = list!!)})
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(title=getString(R.string.home),imageCollapsing= R.drawable.bg_home,context=this)
        binding.actionbar.appBarLayout.addOnOffsetChangedListener(getListener)
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
