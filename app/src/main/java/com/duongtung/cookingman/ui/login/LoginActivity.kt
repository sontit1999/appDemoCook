package com.duongtung.cookingman.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityLoginBinding
import com.duongtung.cookingman.fragment.PhoneFragment
import com.duongtung.cookingman.fragment.PreferanceFragment
import com.duongtung.cookingman.fragment.VerifyFragment
//import devmike.jade.com.PageStepIndicator

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>() {
    override fun getViewMode() = LoginViewModel::class.java

    override fun getLayout() = R.layout.activity_login

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.viewPage.adapter = ViewPageAdapter(supportFragmentManager)
        binding.pageStepper.setupWithViewPager(binding.viewPage)
    }

    class ViewPageAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        val pageLists = arrayListOf(PhoneFragment(), VerifyFragment(), PreferanceFragment())

        override fun getItem(position: Int): Fragment {
           return pageLists.get(position)
        }

        override fun getCount(): Int {
            return pageLists.size
        }

    }
}
