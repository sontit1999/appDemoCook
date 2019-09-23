package com.duongtung.cookingman.ui.home

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.callback.MenuHomeCallback
import com.duongtung.cookingman.customview.FontCache
import com.duongtung.cookingman.databinding.ActivityHomeBinding
import com.duongtung.cookingman.databinding.NavMenuBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.fragment.home.HomeFragment
import com.duongtung.cookingman.fragment.recipe.RecipeFragment
import com.duongtung.cookingman.ui.chatlist.ChatlistActivity
import com.duongtung.cookingman.ui.profile.ProfileActivity
import com.duongtung.cookingman.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), ActionBarListener {
    lateinit var controller: NavController

    override fun initFragment(fragment: Fragment) {
        if (fragment is HomeFragment) {
            action = arrayListOf(binding.actionbar.tvRight, binding.actionbar.tvCenter)
            homeActionbar()
            binding.actionbar.collapsingToolbarLayout.layoutParams.height =
                CookingApplication.getResource().getResource()
                    .getDimensionPixelOffset(R.dimen.heigh_banner_home)
        } else if (fragment is RecipeFragment) {
            action = null
            recipeActionBar()
            binding.actionbar.tvCenter.visibility = View.VISIBLE
            binding.actionbar.tvRight.visibility = View.VISIBLE
        }

    }

    override fun getToolbar(): Toolbar? = binding.actionbar.tbBase

    override fun getViewMode() = HomeViewModel::class.java

    override fun getLayout() = R.layout.activity_home

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.actionbar.appBarLayout.addOnOffsetChangedListener(getListener)
        val bindingMenu = DataBindingUtil.findBinding<NavMenuBinding>(binding.navView.navMenu)
        bindingMenu!!.viewModel = viewModel
        controller = Navigation.findNavController(this, R.id.frameContent)
        NavigationUI.setupWithNavController(binding.navView, controller)
        binding.actionbar.tvleft.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
        viewModel.menuAdapter.setOnMHCallback(object : MenuHomeCallback {
            override fun onCloseDrawer(id: Int) {
                binding.drawer.closeDrawer(GravityCompat.START)
                when (id) {
                    1 -> {
                        controller.navigate(R.id.newFeedsFragment)
                    }
                    2 -> {
                        controller.navigate(R.id.recipeFragment)
                    }
                    3 -> {
                        goToActivity(ChatlistActivity::class.java,null,null)
                    }
                    5 -> {
                        goToActivity(ProfileActivity::class.java,null,null)
                    }
                    7 -> {
                        goToActivity(SettingActivity::class.java,null,null)
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    private fun homeActionbar() {
        viewModel.getMenuItem()
            .observe(this, Observer { list -> viewModel.menuAdapter.setList(list = list!!) })
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            title = getString(R.string.home),
            imageCollapsing = R.drawable.bg_home,
            rightBtn = getString(R.string.icon_search),
            context = this
        )
        binding.actionbar.tvRight.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }

    }

    private fun recipeActionBar() {
        viewModel.getMenuItemRecipe()
            .observe(this, Observer { list -> viewModel.menuAdapter.setList(list = list!!) })
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "RECIPE",
            null,
            getString(R.string.icon_more_v),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener{

        }
    }
}
