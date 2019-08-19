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

class PreferanceFragment : Fragment() {

   lateinit var listTypeFood : ArrayList<TypeFood>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.frag_login_preferance, container, false)
        val recyTypeFood : RecyclerView = view.findViewById(R.id.recyPrefer)
        listTypeFood = ArrayList()
        listTypeFood.add(TypeFood(R.drawable.protein, "Protein", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor"))
        listTypeFood.add(TypeFood(R.drawable.protein, "Protein", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor"))
        listTypeFood.add(TypeFood(R.drawable.protein, "Protein", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor"))
        listTypeFood.add(TypeFood(R.drawable.protein, "Protein", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor"))
        val adapter = this.activity?.let { ItemTypeFoodAdapter(listTypeFood, it) }
        val layoutmanager = LinearLayoutManager(activity)
        layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
        recyTypeFood.layoutManager = layoutmanager
        recyTypeFood.setHasFixedSize(true)
        recyTypeFood.itemAnimator = DefaultItemAnimator()
        recyTypeFood.setHasFixedSize(true)
        recyTypeFood.addItemDecoration(DividerItemDecoration(recyTypeFood.context, DividerItemDecoration.VERTICAL))
        recyTypeFood.adapter = adapter
        return view
    }
}