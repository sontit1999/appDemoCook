package com.duongtung.cookingman.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseMultiViewHolderAdapter<D : DataAdapter>(list: List<ViewDataBinding>) :
    RecyclerView.Adapter<BaseMultiViewHolderAdapter.BaseViewMultiHolder>() {

    abstract fun getLayoutId() : List<Int>

    private var dataList: MutableList<D> = arrayListOf()

    fun setList(list: MutableList<D>) {
        this.dataList = list
        notifyDataSetChanged()
    }

    fun addElement(t: D) {
        dataList.add(t)
        notifyDataSetChanged()
    }

    fun addElementPosition(t: D, i: Int) {
        dataList.add(i, t)
        notifyDataSetChanged()
    }

    fun getElementPossition(i: Int): D {
        return dataList[i]
    }

    fun size(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewMultiHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseViewMultiHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class BaseViewMultiHolder(view: View) : RecyclerView.ViewHolder(view)
}