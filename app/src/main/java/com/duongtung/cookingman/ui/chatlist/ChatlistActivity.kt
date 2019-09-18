package com.duongtung.cookingman.ui.chatlist

import androidx.appcompat.widget.Toolbar
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.MyViewPageStateAdapter
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityChatlistBinding
import com.duongtung.cookingman.fragment.PopularAuthorFragment
import kotlinx.android.synthetic.main.actionbar_chatlist.view.*

class ChatlistActivity : BaseActivity<ActivityChatlistBinding,ChatlistViewModel>(){
    override fun getToolbar(): Toolbar? {
        return null
    }
    override fun getViewMode() = ChatlistViewModel::class.java

    override fun getLayout() = R.layout.activity_chatlist

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.actionbar.tvReturn.setOnClickListener { finish() }
        binding.actionbar.tvReturn.setOnClickListener {
            finish()
        }
        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Popular Author")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Recent People")
        myViewPageStateAdapter.addFragment(PopularAuthorFragment(),"Other Author")
        binding.viewPager.adapter = myViewPageStateAdapter
        binding.tabs.setupWithViewPager(binding.viewPager,true)
    }

}
