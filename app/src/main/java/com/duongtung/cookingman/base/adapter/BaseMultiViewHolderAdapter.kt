package com.duongtung.cookingman.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import kotlin.Comparator


abstract class BaseMultiViewHolderAdapter<D : DataAdapter> :
    RecyclerView.Adapter<BaseMultiViewHolderAdapter.BaseViewMultiHolder<D>>() {
    abstract fun getVariableId(): MutableList<Int>
    abstract fun getIdVariableOnClick(): MutableList<Int?>?
    abstract fun getOnClick(): CBAdapter?
    private var dataList: MutableList<D> = mutableListOf()
    abstract fun getLayoutId(): MutableList<Int>

    fun setList(list: MutableList<D>) {
        this.dataList = list
        notifyDataSetChanged()
    }

    fun setListSort(list: MutableList<D>) {
        list.sortWith(Comparator { object1, object2 -> object1.groupType!!.compareTo(object2.groupType!!) })
        this.dataList = list
        notifyDataSetChanged()
    }
    fun getList() = dataList

    fun addElement(t: D) {
        addElementPosition(t,0)
    }

    fun addElementPosition(t: D, i: Int) {
        dataList.add(i, t)
        notifyItemRangeChanged(i,dataList.size-1)
    }

    fun getElementPosition(i: Int): D {
        return dataList[i]
    }

    fun size(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return getElementPosition(position).viewType!!
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    open fun isVisibility(item : D) : Boolean {
        return false
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewMultiHolder<D> {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            getLayoutId()[viewType],parent,false)
        return BaseViewMultiHolder(binding)
    }
    open fun updateViewHolder(holder: BaseViewMultiHolder<D>, objects : D,viewType : Int,position: Int){}

    override fun onBindViewHolder(holder: BaseViewMultiHolder<D>, position: Int) {
        if (!isVisibility(getElementPosition(position))) {
            holder.itemView.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT)
            holder.setVariable(getVariableId()[getItemViewType(position)], getElementPosition(position))
            if (getOnClick() != null && getIdVariableOnClick()?.get(getItemViewType(position)) != null)
                holder.setClickAdapter(
                    getIdVariableOnClick()?.get(getItemViewType(position))!!,
                    getOnClick()!!
                )
        }else{
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0,0)
        }
        updateViewHolder(holder, getElementPosition(position),getItemViewType(position),position)
    }


    class BaseViewMultiHolder<D : DataAdapter>(var binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setVariable(id: Int, t: D) {
            binding.setVariable(id, t)
        }

        fun setClickAdapter(id: Int, onClick: CBAdapter) {
            binding.setVariable(id, onClick)
        }

    }
}