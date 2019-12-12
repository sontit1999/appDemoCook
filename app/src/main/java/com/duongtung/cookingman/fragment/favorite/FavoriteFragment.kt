package com.duongtung.cookingman.fragment.favorite

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragFavoriteBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.User
import kotlinx.android.synthetic.main.frag_detail_chat.*
import java.util.*

class FavoriteFragment : BaseFragment<FragFavoriteBinding,FavoriteViewModel>(){
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment newfeed")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }

    override fun getClassViewMode() = FavoriteViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recipeFavorite.layoutManager = GridLayoutManager(context,2)
        // sự kiện swipe 1 item trong recyclerview
        ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView:RecyclerView,viewHolder:RecyclerView.ViewHolder,viewHolder1:RecyclerView.ViewHolder):Boolean {
                return false
            }
            override fun onSwiped(viewHolder:RecyclerView.ViewHolder, i:Int) {
                viewModel.deleteFavorite(viewModel.adapter.getElementPossition(viewHolder.adapterPosition).idphoto,context!!)
                viewModel.adapter.removeItem(viewHolder.adapterPosition)

            }
        }).attachToRecyclerView(binding.recipeFavorite)
    }

    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
            viewModel.adapter.setCallBack(object : PostCallback{
                override fun onImageFoodClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    findNavController().navigate(R.id.detailCookFragment,bundle)
                }

                override fun onAvatarClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    findNavController().navigate(R.id.profileFragment,bundle)
                }

                override fun onMoreClick(view: View, post: Postres) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        })
    }

    override fun getLayoutId() = R.layout.frag_favorite
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }

}