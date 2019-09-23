package com.duongtung.cookingman.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.base.adapter.callback.CBAdapter

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
    fun getList() = dataList

    fun addElement(t: D) {
        dataList.add(t)
        notifyDataSetChanged()
    }

    fun addElementPosition(t: D, i: Int) {
        dataList.add(i, t)
        notifyDataSetChanged()
    }

    fun getElementPosition(i: Int): D {
        return dataList[i]
    }

    fun size(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewType
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    open fun isVisibility(item : D) : Boolean {
        return false
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewMultiHolder<D> {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),getLayoutId()[viewType]!!,parent,false)
        return BaseViewMultiHolder(binding)
    }


    override fun onBindViewHolder(holder: BaseViewMultiHolder<D>, position: Int) {
        if (!isVisibility(dataList[position])) {
            holder.itemView.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT)
            holder.setVariable(getVariableId()[getItemViewType(position)], dataList[position])
            if (getOnClick() != null && getIdVariableOnClick()?.get(getItemViewType(position)) != null)
                holder.setClickAdapter(
                    getIdVariableOnClick()?.get(getItemViewType(position))!!,
                    getOnClick()!!
                )
        }else{
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0,0)
        }
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