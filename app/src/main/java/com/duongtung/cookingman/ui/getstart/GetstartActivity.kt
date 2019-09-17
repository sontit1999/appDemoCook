package com.duongtung.cookingman.ui.getstart

import android.content.Intent
import android.view.View
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityGetstartBinding
import com.duongtung.cookingman.fragment.GetStartFourFragment
import com.duongtung.cookingman.fragment.GetStartOneFragment
import com.duongtung.cookingman.fragment.GetStartThreeFragment
import com.duongtung.cookingman.fragment.GetStartTwoFragment
import com.duongtung.cookingman.ui.MainActivity
import com.duongtung.cookingman.ui.home.HomeActivity

class GetstartActivity : BaseActivity<ActivityGetstartBinding,GetstartViewModel>(){
    override fun getViewMode() =GetstartViewModel::class.java

    override fun getLayout() = R.layout.activity_getstart

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel

        binding.tvSkip.setOnClickListener {
            var intent = Intent(baseContext, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.tvNext.setOnClickListener {
            next_fragment()
        }

        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(GetStartOneFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartTwoFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartThreeFragment(),"DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartFourFragment(),"DIRECTION")
        binding.viewpagerGetStart.adapter = myViewPageStateAdapter
        binding.viewpagerGetStart.beginFakeDrag()
        binding.circleIndicatorPager.setViewPager(binding.viewpagerGetStart)
    }
    fun next_fragment() {
        binding.viewpagerGetStart.setCurrentItem(binding.viewpagerGetStart.getCurrentItem()+1)
    }
}