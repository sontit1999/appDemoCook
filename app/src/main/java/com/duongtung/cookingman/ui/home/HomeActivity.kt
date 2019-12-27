package com.duongtung.cookingman.ui.home

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
import android.view.MotionEvent
import android.graphics.Rect
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.adapter.SlideCallback
import com.duongtung.cookingman.callback.CallbackHomeActivity
import com.duongtung.cookingman.callback.VoiceCallback
import com.duongtung.cookingman.customview.imageslide.ItemImageSlide
import com.duongtung.cookingman.fragment.detailcook.DetailCookFragment
import com.duongtung.cookingman.fragment.resultsearch.ResultSearchFragment
import com.duongtung.cookingman.fragment.shopping.ShoppingFragment
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.login.LoginRes
import com.duongtung.cookingman.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_home.view.*
import java.lang.Exception
import java.util.*


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), ActionBarListener,VoiceCallback{
    private lateinit var controller: NavController

    private lateinit var navHostFragment: Fragment

    private lateinit var toggle: ActionBarDrawerToggle

    private var imageList: MutableList<ItemImageSlide>? = mutableListOf()

    private val REQUEST_VOICE = 999

    override fun tvSearchClick() {
        speak()
    }
    override fun onResumeFragment(fragment: Fragment) {
        binding.actionbar.tvleft.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
            binding.drawer.setScrimColor(Color.TRANSPARENT)
        }
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()
        binding.actionbar.imageSlider.visibility = View.GONE

        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        val statusDimen = resources.getDimensionPixelSize(resourceId)
        when (fragment) {
            is HomeFragment -> {
                viewModel.menuAdapter.changVisibility(0)
                action = null
                homeActionbar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
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
            is ProfileFragment -> {
                action = null
                profileActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
            is ChatFragment -> {
                viewModel.menuAdapter.changVisibility(3)
                action = null
                chatActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
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
            is DetailCookFragment->{
                action = null
                detailcookActionBar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
            is ResultSearchFragment->{
                action = null
                searchActionbar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
            is ShoppingFragment->{
                viewModel.menuAdapter.changVisibility(6)
                action = null
                shoppingActionbar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
            is ProfileActivity->{
                viewModel.menuAdapter.changVisibility(5)
                action = null
                selfPrfofileActionbar()
                binding.actionbar.tvCenter.visibility = View.VISIBLE
                binding.actionbar.tvRight.visibility = View.INVISIBLE
            }
        }
        binding.drawer.closeDrawer(GravityCompat.START)
    }


    override fun initFragment(fragment: Fragment) {
    }

    override fun getToolbar(): Toolbar? = binding.actionbar.tbBase

    override fun getViewMode() = HomeViewModel::class.java

    override fun getLayout() = R.layout.activity_home

    override fun setBindingViewModel() {

        binding.navHeader.user = CurentUser.user
        binding.viewModel = viewModel
        binding.actionbar.appBarLayout.addOnOffsetChangedListener(getListener)
        val bindingMenu = DataBindingUtil.findBinding<NavMenuBinding>(binding.navView.navMenu)
        bindingMenu!!.viewModel = viewModel

        viewModel.getHomeSlider().observe(this, Observer {
            imageList = it
            binding.actionbar.imageSlider.setImageList(imageList!!)
        })
        controller = findNavController(R.id.frameContent)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.frameContent)!!
        val navigator =
            KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.frameContent)
        controller.navigatorProvider.addNavigator(navigator)
        controller.setGraph(R.navigation.nav_home)
        binding.navView.setupWithNavController(controller)

        binding.drawer.drawerElevation = 0f
        toggle = object : ActionBarDrawerToggle(
            this, binding.drawer,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ) {
            val scaleFactor = 2f
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * (slideOffset / scaleFactor / 2)
                val slideY = drawerView.height * (slideOffset / scaleFactor / 8)
                binding.content.translationX = slideX
                binding.content.translationY = slideY
                binding.content.scaleX = 1 - slideOffset / scaleFactor
                binding.content.scaleY = 1 - slideOffset / scaleFactor
                binding.navView.setBackgroundColor(Color.TRANSPARENT)
            }
        }

        viewModel.getMenuItem().observe(this, Observer {
            viewModel.menuAdapter.setListSort(it)
        })
        binding.navButton.btnLogout.setOnClickListener {
            goToActivityAndClearTask(SplashActivity::class.java)
        }
        viewModel.menuAdapter.setOnMHCallback(object : MenuHomeCallback {
            override fun onCloseDrawer(id: Int) {
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
                        controller.navigate(R.id.SelfProfileFragmenet)
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
            if (navHostFragment.childFragmentManager.findFragmentById(R.id.frameContent) is HomeFragment) {
                finish()
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun homeActionbar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "HOME",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
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
            var keyword = binding.actionbar.etSearch.text.toString()
            binding.actionbar.searchLayout.visibility = View.GONE
            Log.d("log",keyword)
            var bunde = Bundle()
            bunde.putString("keyword",keyword)
            controller.navigate(R.id.SearchResultFragment,bunde)
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
            var keyword = binding.actionbar.etSearch.text.toString()
            binding.actionbar.searchLayout.visibility = View.GONE
            Log.d("log",keyword)
            var bunde = Bundle()
            bunde.putString("keyword",keyword)
            controller.navigate(R.id.SearchResultFragment,bunde)

        }
    }
    private fun detailcookActionBar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "Detail Cook",
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
    }

    private fun profileActionBar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarHome(
            "Profile",
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
        binding.actionbar.tvleft.setOnClickListener {
            navHostFragment.childFragmentManager.popBackStack()
        }
    }
    private fun shoppingActionbar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarBackPress(
            "SHOPPING LIST",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvleft.setOnClickListener {
            navHostFragment.childFragmentManager.popBackStack()
        }
    }
    private fun selfPrfofileActionbar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarBackPress(
            "Profile",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.white1),
            this
        )
        binding.actionbar.tvleft.setOnClickListener {
            navHostFragment.childFragmentManager.popBackStack()
        }
    }
    private fun searchActionbar() {
        binding.actionbar.data = DataUtilsApplication.createActionBarBackPress(
            "Result Searching",
            null,
            getString(R.string.icon_search),
            ContextCompat.getColor(this, R.color.colorAccent),
            this
        )
        binding.actionbar.tvleft.setOnClickListener {
            navHostFragment.childFragmentManager.popBackStack()
        }
    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val viewRectMenu = Rect()
        val viewRectFooter = Rect()
        val viewRectHeader = Rect()
        binding.navView.navMenu.getGlobalVisibleRect(viewRectMenu)
        binding.navView.navFooterLayout.getGlobalVisibleRect(viewRectFooter)
        binding.navView.navHeader.getGlobalVisibleRect(viewRectHeader)
        if (!viewRectMenu.contains(ev.rawX.toInt(), ev.rawY.toInt()) &&
            !viewRectFooter.contains(ev.rawX.toInt(), ev.rawY.toInt()) &&
            !viewRectHeader.contains(ev.rawX.toInt(), ev.rawY.toInt())
        ) {
            if (binding.drawer.isDrawerOpen(GravityCompat.START))
                binding.drawer.closeDrawer(GravityCompat.START)
        }
        return super.dispatchTouchEvent(ev)
    }
    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent .EXTRA_PROMPT,"Hi, Speak recipe you want to search ?")

        try {

            startActivityForResult(intent,REQUEST_VOICE)
        }catch (e: Exception){
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_VOICE ->{
                if(data!= null){
                    // get string
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                   // Toast.makeText(baseContext,result.get(0),Toast.LENGTH_LONG).show()
                    var bunde = Bundle()
                    bunde.putString("keyword",result.get(0))
                    controller.navigate(R.id.SearchResultFragment,bunde)
                }
            }
        }
    }
}
