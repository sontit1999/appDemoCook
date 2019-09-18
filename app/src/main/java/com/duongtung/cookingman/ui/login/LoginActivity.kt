package com.duongtung.cookingman.ui.login

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityLoginBinding
import com.duongtung.cookingman.fragment.phone.PhoneFragment
import com.duongtung.cookingman.fragment.PreferanceFragment
import com.duongtung.cookingman.fragment.verify.VerifyFragment
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),
    OnButtonClickListener {
    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun onButtonClicked(view: View,error : Boolean) {
        if(!error)binding.viewPage.currentItem = 1
    }

    override fun getViewMode() = LoginViewModel::class.java

    override fun getLayout() = R.layout.activity_login


    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.viewPage.adapter = ViewPageAdapter(supportFragmentManager)
        binding.pageStepper.setupWithViewPager(binding.viewPage)
        binding.pageStepper.isClickable=false
    }

    class ViewPageAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val pageLists = arrayListOf(PhoneFragment(),
            VerifyFragment(), PreferanceFragment())
        override fun getItem(position: Int): Fragment {
            return pageLists[position]

        }

        override fun getCount(): Int {
            return pageLists.size
        }

    }
}
