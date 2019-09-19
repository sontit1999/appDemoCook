package com.duongtung.cookingman.fragment

import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginBottom
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.customview.CustomTextView
import com.duongtung.cookingman.customview.TextViewWithFontAwesome
import com.duongtung.cookingman.databinding.FragDirectionBinding

class DirectionFragment : BaseFragment<FragDirectionBinding,DirectionViewModel>(){
    override fun getClassViewMode() = DirectionViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        // Create TextView programmatically.
        for(i in viewModel.listStep){
            val textView = TextViewWithFontAwesome(context)
            var param =  LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            param.setMargins(0,40,0,40)
            textView.layoutParams = param
            textView.gravity = Gravity.LEFT
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
            textView.setBackgroundResource(R.drawable.bg_step)
            textView.setText(i)
            // Add TextView to LinearLayout
            binding.rootlayout.addView(textView)
        }


    }

    override fun getLayoutId() = R.layout.frag_direction
}