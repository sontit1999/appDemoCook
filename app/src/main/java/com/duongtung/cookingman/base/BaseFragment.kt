package com.duongtung.cookingman.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.duongtung.cookingman.base.ui.base.BaseViewModel

abstract class BaseFragment<VB : ViewDataBinding,VM : BaseViewModel> : Fragment(){
    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    abstract fun getClassViewMode() : Class<VM>
    abstract fun setBindingViewModel()
    abstract fun viewCreated()
    @LayoutRes
    abstract fun getLayoutId() : Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        setBindingViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewCreated()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(getClassViewMode())
        }?: throw Exception("Invalid Activity")
    }
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(getClassViewMode())
//    }
}