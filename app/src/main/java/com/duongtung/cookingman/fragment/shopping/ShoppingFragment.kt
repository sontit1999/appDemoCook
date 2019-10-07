package com.duongtung.cookingman.fragment.shopping

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragShoppingBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener

class ShoppingFragment  : BaseFragment<FragShoppingBinding,ShoppingViewmodel>(){
    private var  listener : ActionBarListener? = null
    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment shopping")
        super.onAttach(context)
        try {
            listener = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = ShoppingViewmodel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        addSwipeItemRecyclerview(binding.rcGredient)
    }

    override fun viewCreated() {
        viewModel.getArrIngredient().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.frag_shopping
    override fun onResume() {
        super.onResume()
        listener!!.onResumeFragment(this)
    }
    fun addSwipeItemRecyclerview(recyclerView: RecyclerView){
        // sự kiện swipe 1 item trong recyclerview
        ItemTouchHelper(object:
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder):Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i:Int) {
                viewModel.adapter.removeItem(viewHolder.adapterPosition)
            }
        }).attachToRecyclerView(recyclerView)
    }
}