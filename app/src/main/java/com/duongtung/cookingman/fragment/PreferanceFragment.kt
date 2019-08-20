package com.duongtung.cookingman.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.ItemTypeFoodAdapter
import com.duongtung.cookingman.adapter.TypeFood
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginPreferanceBinding

class PreferanceFragment : BaseFragment<FragLoginPreferanceBinding,PreferanceViewModel>(){
    override fun getClassViewMode() = PreferanceViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        lateinit var listTypeFood : ArrayList<TypeFood>
        listTypeFood = ArrayList()
        listTypeFood.add(TypeFood(R.drawable.protein, "Vitamins", "Vitamins are organic molecules essential for an organism that are not classified as amino acids."))
        listTypeFood.add(TypeFood(R.drawable.protein, "Minerals", "Minerals are the exogenous chemical elements indispensable for life."))
        listTypeFood.add(TypeFood(R.drawable.protein, "Fatty acids", "Essential fatty acids (EFAs) are fatty acids that humans and other animals must ingest"))
        listTypeFood.add(TypeFood(R.drawable.protein, "Protein", "Vitamins are organic molecules essential for an organism that are not classified as amino acids or fatty acids."))

        val adapter = this.activity?.let { ItemTypeFoodAdapter(listTypeFood, it) }
        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyPrefer.layoutManager = layoutmanager
        binding.recyPrefer.setHasFixedSize(true)
        binding.recyPrefer.setHasFixedSize(true)
        binding.recyPrefer.adapter = adapter
    }

    override fun getLayoutId() = R.layout.frag_login_preferance

}