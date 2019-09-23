package com.duongtung.cookingman.ui.setting

import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.utils.DataUtilsApplication
import com.duongtung.cookingman.databinding.ActivitySettingBinding

class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>() {
    override fun getToolbar(): Toolbar = binding.actionbar.tbBase

    override fun getViewMode() = SettingViewModel::class.java

    override fun getLayout() = R.layout.activity_setting

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.actionbar.data = DataUtilsApplication.createActionBarBackPress(
            title = "SETTING",
            imageCollapsing = null,
            rightBtn = null,
            context = this,
            backgroundActionBar = ContextCompat.getColor(this,R.color.colorAccent)
        )
        binding.actionbar.tvleft.setOnClickListener{
            onBackPressed()
        }
    }

}