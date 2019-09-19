package com.duongtung.cookingman.base


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import com.google.android.material.appbar.AppBarLayout

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: VB
    private var menu: Menu? = null

    abstract fun getViewMode(): Class<VM>
    abstract fun getLayout(): Int
    abstract fun setBindingViewModel()
    abstract fun getToolbar(): Toolbar?
    protected var action: MutableList<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        viewModel = ViewModelProviders.of(this).get(getViewMode())
        setBindingViewModel()
        if (getToolbar() != null) {
            setSupportActionBar(getToolbar())
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

    }

    protected fun goToActivity(activity: Class<*>, key: String?, bundle: Bundle?) {
        val intent = Intent(this, activity)
        if (bundle != null) intent.putExtra(key, bundle)
        startActivity(intent)
    }

    private fun hideOption(views : MutableList<View>) {
        for (view in views) {
            view.visibility = View.INVISIBLE
        }
    }

    private fun showOption(views: MutableList<View>) {
        for (view in views) {
            view.visibility = View.VISIBLE
        }
    }

    var isShow = false
    var scrollRange = -1
    protected var getListener =
        AppBarLayout.OnOffsetChangedListener { appBarLayout: AppBarLayout, i: Int ->
            if (this.scrollRange == -1) {
                this.scrollRange = appBarLayout.totalScrollRange
            }
            if (scrollRange + i == 0) {
                isShow = true
                if (action != null) showOption(action!!)
            } else {
                isShow = false
                if (action != null) hideOption(action!!)
            }
        }
}