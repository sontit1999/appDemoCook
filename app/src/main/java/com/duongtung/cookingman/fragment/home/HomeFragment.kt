package com.duongtung.cookingman.fragment.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.adapter.SlideCallback
import com.duongtung.cookingman.adapter.SliderAdapterExample
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.callback.VoiceCallback
import com.duongtung.cookingman.customview.imageslide.ViewPagerAdapter
import com.duongtung.cookingman.databinding.FragmentHomeBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.User
import java.util.ArrayList


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(){
    var adapter  = SliderAdapterExample(context)
    private var actionBarHomeOnClick: ActionBarListener? = null
    private var listener : VoiceCallback? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
            listener = context as VoiceCallback
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = HomeFragmentViewModel::class.java

    override fun setBindingViewModel() {
        actionBarHomeOnClick!!.initFragment(this)
        binding.viewModel = viewModel
        binding.tvMicro.setOnClickListener {
            Log.d("test","click micro")
            listener?.tvSearchClick()
        }
        binding.imageSlider.sliderAdapter = adapter
        binding.imageSlider.scrollTimeInSec = 3
    }



    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list->
            adapter.setlist( list.shuffled().take(6) as ArrayList<Postres>?)
        })
        viewModel.getSpecial().observe(this, Observer { list->
            viewModel.adapterSpecial.setList(list.shuffled().take(10) as MutableList<Postres>)
            viewModel.adapterSpecial.setCallBack(object : PostCallback{
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
                }
            })
        })
        viewModel.getDrink().observe(this, Observer { list->
            viewModel.adapterDrink.setList(list.shuffled().take(10) as MutableList<Postres>)
            viewModel.adapterDrink.setCallBack(object : PostCallback{
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
                }
            })
        })
    }

    override fun getLayoutId()= R.layout.fragment_home
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}