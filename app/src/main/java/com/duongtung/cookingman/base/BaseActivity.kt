package com.duongtung.cookingman.base


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.duongtung.cookingman.base.ui.base.BaseViewModel


abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: VB

    abstract fun getViewMode(): Class<VM>
    abstract fun getLayout(): Int
    abstract fun setBindingViewModel()
    abstract fun getToolbar() : Toolbar?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        viewModel = ViewModelProviders.of(this).get(getViewMode())
        setBindingViewModel()
        if (getToolbar()!=null) {
            setSupportActionBar(getToolbar())
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }

    }

    protected fun goToActivity(activity:Class<*>,key : String?,bundle: Bundle?){
        val intent = Intent(this, activity)
        if (bundle != null) intent.putExtra(key,bundle)
        startActivity(intent)
    }
}