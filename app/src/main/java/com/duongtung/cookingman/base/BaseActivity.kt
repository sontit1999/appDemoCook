package com.duongtung.cookingman.base


import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.duongtung.cookingman.base.ui.base.BaseViewModel
import android.view.Menu
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    private var PERMISSION_ALL = 1
    private var PERMISSIONS  = arrayOf(
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        if(hasPermissions(this, *PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)
        }
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        viewModel = ViewModelProviders.of(this).get(getViewMode())
        if (getToolbar() != null) {
            setSupportActionBar(getToolbar())
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        setBindingViewModel()


    }

    protected fun goToActivity(activity: Class<*>, key: String?, bundle: Bundle?) {
        val intent = Intent(this, activity)
        if (bundle != null) intent.putExtra(key, bundle)
        startActivity(intent)
    }
    protected fun goToActivityAndClearTask(activity: Class<*>){
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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

    fun hasPermissions(context: Context, vararg permissions: String): Boolean = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }
}