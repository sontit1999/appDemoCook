package com.duongtung.cookingman.ui.home

import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.navigation.KeepStateNavigator
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.callback.MenuHomeCallback
import com.duongtung.cookingman.databinding.ActivityHomeBinding
import com.duongtung.cookingman.databinding.NavMenuBinding
import com.duongtung.cookingman.fragment.chat.ChatFragment
import com.duongtung.cookingman.fragment.favorite.FavoriteFragment
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.fragment.home.HomeFragment

import com.duongtung.cookingman.fragment.newfeed.NewFeedsFragment
import com.duongtung.cookingman.fragment.profile.ProfileFragment
import com.duongtung.cookingman.fragment.recipe.RecipeFragment
import com.duongtung.cookingman.fragment.setting.SettingFragment
import com.duongtung.cookingman.ui.splash.SplashActivity
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), ActionBarListener {
    override fun onResumeFragment(fragment: Fragment) {
        binding.actionbar.tvleft.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
        when (fragment) {
            is HomeFragment -> {
                viewModel.menuAdapter.changVisibility(0)
                action = arrayListOf(binding.actionbar.tvRight, binding.actionbar.tvCenter)
                homeActionbar()
                binding.actionbar.collapsingToolbarLayout.layoutParams.height =
                    CookingApplication.getResource().getResource()
                        .getDimensionPixelOffset(R.dimen.heigh_banner_home)
            }
            is NewFeedsFragment -> {
                viewModel.menuAdapter.changVisibility(1)
                action = null
                newFeedsActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.VISIBLE
            }
            is RecipeFragment -> {
                viewModel.menuAdapter.changVisibility(2)
                action = null
                recipeActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.VISIBLE
            }
            is ProfileFragment->{
                viewModel.menuAdapter.changVisibility(5)
                action = null
                profileActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.VISIBLE
            }
            is ChatFragment ->{
                viewModel.menuAdapter.changVisibility(3)
                action = null
                chatActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.VISIBLE
            }
            is SettingFragment -> {
                viewModel.menuAdapter.changVisibility(6)
                action = null
                settingActionbar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
            is FavoriteFragment -> {
                viewModel.menuAdapter.changVisibility(4)
                action = null
                favoriteActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
        }
    }

    private lateinit var controller: NavController

    private lateinit var navHostFragment : Fragment

    override fun initFragment(fragment: Fragment) {
    }

    override fun getToolbar(): Toolbar? = binding.actionbar.tbBase

    override fun getViewMode() = HomeViewModel::class.java

    override fun getLayout() = R.layout.activity_home

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.actionbar.appBarLayout.addOnOffsetChangedListener(getListener)
        val bindingMenu = DataBindingUtil.findBinding<NavMenuBinding>(binding.navView.navMenu)
        bindingMenu!!.viewModel = viewModel


        controller = findNavController(R.id.frameContent)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.frameContent)!!
        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.frameContent)
        controller.navigatorProvider.addNavigator(navigator)
        controller.setGraph(R.navigation.nav_home)
        binding.navView.setupWithNavController(controller)


        binding.actionbar.tvleft.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
        viewModel.getMenuItem().observe(this, Observer {
            viewModel.menuAdapter.setList(it)
        })
        binding.navButton.btnLogout.setOnClickListener{
            goToActivityAndClearTask(SplashActivity::class.java)
        }
        viewModel.menuAdapter.setOnMHCallback(object : MenuHomeCallback {
            override fun onCloseDrawer(id: Int) {
                binding.drawer.closeDrawer(GravityCompat.START)
                when (id) {
                    0 -> {
                        controller.navigate(R.id.homeFragment)
                    }
                    1 -> {
                        controller.navigate(R.id.newFeedsFragment)
                    }
                    2 -> {
                        controller.navigate(R.id.recipeFragment)
                    }
                    3 -> {
                        controller.navigate(R.id.chatFragment)
                    }
                    4 -> {
                        controller.navigate(R.id.favoriteFragment)
                    }
                    5 -> {
                        controller.navigate(R.id.profileFragment)
                    }
                    6 -> {
                        controller.navigate(R.id.settingFragment)
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            if (navHostFragment.childFragmentManager.findFragmentById(R.id.frameContent) is HomeFragment){
                finish()
            }else {
                super.onBackPressed()
            }
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.nav_home).navigateUp()
//        val hostedFragment = navHost?.childFragmentManager?.primaryNavigationFragment
//        return when(hostedFragment){
//            is FragmentB -> {
//                if(hostedFragment.isInnerFragmentB2Showing()){
//                    findNavController(R.id.embeddedNavHostFragment).navigateUp()
//                } else {
//                    findNavController(R.id.navHost).navigateUp()
//                }
//            }
//            is FragmentA -> {
//                findNavController(R.id.navHost).navigateUp()
//            }
//            else -> false
//        }
//    }

    private fun homeActionbar() {
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
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "RECIPES",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener {

            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }
    }

    private fun newFeedsActionBar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "NEW FEEDS",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener {

            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }
    }
    private fun favoriteActionBar() {
        Log.d("test","favorite actiobbar")
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "Favorite",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener {

            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }
    }
    private fun chatActionBar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "CHATTING",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener {

            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }
    }
    private fun profileActionBar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "PROFILE",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvRight.setOnClickListener {

            binding.actionbar.searchLayout.visibility = View.VISIBLE
        }
        binding.actionbar.ivSearch.setOnClickListener {
            binding.actionbar.searchLayout.visibility = View.GONE
        }
    }
    private fun settingActionbar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarBackPress(
            "Setting",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvleft.setOnClickListener{
            navHostFragment.childFragmentManager.popBackStack()
        }
    }

}
