package com.duongtung.cookingman.fragment.newfeed

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.User
import com.duongtung.cookingman.ui.home.HomeActivity
import com.duongtung.cookingman.ui.postnew.PostNewActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class NewFeedsFragment : BaseFragment<FragmentNewfeedsBinding, NewFeedsViewModel>() {
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
    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            Log.d("count","1")
            viewModel.adapter.setList(list as MutableList<Postres>)
            binding.progressCircular.visibility = View.INVISIBLE
            viewModel.adapter.setCallBack(object : PostCallback{
                override fun onImageFoodClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                   // CurentUser.post = post
                    findNavController().navigate(R.id.detailCookFragment,bundle)

                }

                override fun onAvatarClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    findNavController().navigate(R.id.profileFragment,bundle)
                }

                override fun onMoreClick(view: View, post: Postres) {
                    showBottomsheetDialog(post)
                }
            })
        })

    }

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.fabADD.setOnClickListener {
           activity!!.startActivity(Intent(context,PostNewActivity::class.java))
        }
    }

    override fun getClassViewMode() = NewFeedsViewModel::class.java

    override fun getLayoutId() = R.layout.fragment_newfeeds

    override fun onResume() {
        Log.d("test","on resume newfeed frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
    fun showBottomsheetDialog(post: Postres){
            var view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null)
            var like : LinearLayout = view.findViewById(R.id.SaveLinearLayout)
            var delete : LinearLayout = view.findViewById(R.id.DeleteLinearLayout)
            var report : LinearLayout = view.findViewById(R.id.ReportLinearLayout)
            var bottomsheet = BottomSheetDialog(this.requireContext())
            bottomsheet.setContentView(view)
            bottomsheet.show()
            like.setOnClickListener {
                viewModel.addFavorite(post.idphoto,context!!)
                bottomsheet.dismiss()
            }
            delete.setOnClickListener {
                Toast.makeText(context,"You cannot delete ^^",Toast.LENGTH_LONG).show()
                bottomsheet.dismiss()
            }
            report.setOnClickListener {
                Toast.makeText(context,"Đã report cho ad sơn tít",Toast.LENGTH_LONG).show()
                bottomsheet.dismiss()
            }
    }
}