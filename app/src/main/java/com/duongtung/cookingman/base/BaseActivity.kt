package com.duongtung.cookingman.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.duongtung.cookingman.base.ui.base.BaseViewModel


abstract class BaseActivity<VB : ViewDataBinding,VM : BaseViewModel> : AppCompatActivity(){
    protected lateinit var viewModel : VM
    protected lateinit var binding : VB

    abstract fun getViewMode() : Class<VM>
    abstract fun getLayout() : Int
    abstract fun setBindingViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayout())
        viewModel = ViewModelProviders.of(this).get(getViewMode())
        setBindingViewModel()
    }

}