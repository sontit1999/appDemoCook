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
import com.duongtung.cookingman.fragment.preferance.PreferanceFragment
import com.duongtung.cookingman.fragment.verify.VerifyFragment
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.duongtung.cookingman.ui.MainActivity


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(),
    OnButtonClickListener {
    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun onButtonClicked(view: View, boolean : Boolean) {
        if (view.id == R.id.ivBtdone){
            goToActivity(MainActivity::class.java,null,null)
        }else {
            if (!boolean) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                binding.viewPage.currentItem += 1
            }
        }
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
            VerifyFragment(), PreferanceFragment()
        )
        override fun getItem(position: Int): Fragment {
            return pageLists[position]

        }

        override fun getCount(): Int {
            return pageLists.size
        }

    }
}
