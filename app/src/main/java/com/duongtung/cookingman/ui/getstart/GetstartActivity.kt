package com.duongtung.cookingman.ui.getstart

import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityGetstartBinding
import com.duongtung.cookingman.fragment.GetStartFourFragment
import com.duongtung.cookingman.fragment.GetStartOneFragment
import com.duongtung.cookingman.fragment.GetStartThreeFragment
import com.duongtung.cookingman.fragment.GetStartTwoFragment
import com.duongtung.cookingman.ui.home.HomeActivity
import com.duongtung.cookingman.ui.login.LoginEmailActivity

class GetstartActivity : BaseActivity<ActivityGetstartBinding, GetstartViewModel>() {
    override fun getToolbar(): Toolbar? {
        return null
    }
    var myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
    var next = false
    override fun getViewMode() = GetstartViewModel::class.java

    override fun getLayout() = R.layout.activity_getstart

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel

        binding.tvSkip.setOnClickListener {
            goToActivity(LoginEmailActivity::class.java, null, null)
        }
        binding.tvNext.setOnClickListener {
            nextFragment()
        }

        myViewPageStateAdapter.addFragment(GetStartOneFragment(), "DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartTwoFragment(), "DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartThreeFragment(), "DIRECTION")
        myViewPageStateAdapter.addFragment(GetStartFourFragment(), "DIRECTION")
        binding.viewpagerGetStart.adapter = myViewPageStateAdapter
        binding.circleIndicatorPager.setViewPager(binding.viewpagerGetStart)
        binding.viewpagerGetStart.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {
//                if (binding.viewpagerGetStart.currentItem  == myViewPageStateAdapter.count - 1) {
//                    if (next && state==0)
//                        goToActivity(
//                            HomeActivity::class.java,
//                            null,
//                            null
//                        )
//                    else next = true
//                }
//                else next = false
            }
        })
    }

    private fun nextFragment() {
        binding.viewpagerGetStart.setCurrentItem(binding.viewpagerGetStart.currentItem + 1, true)
    }
}