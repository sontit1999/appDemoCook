package com.duongtung.cookingman.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivitySettingBinding
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class SettingActivity : BaseActivity<ActivitySettingBinding,SettingViewModel>(){
    override fun getToolbar(): Toolbar? {
        return null
    }
    override fun getViewMode() = SettingViewModel::class.java

    override fun getLayout() = R.layout.activity_setting

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvReturn.setOnClickListener { finish() }
    }

}