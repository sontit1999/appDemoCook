 package com.duongtung.cookingman.base.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

 abstract class BaseAdapter<T,VB : ViewDataBinding> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T, VB>>() {
    private var list : MutableList<T> = arrayListOf()
    protected lateinit var binding : VB

    fun setList(list : MutableList<T>){
        this.list = list
        notifyDataSetChanged()
    }

    fun addElement(t:T){
        list.add(t)
        notifyDataSetChanged()
    }

    fun addElementPosition(t:T,i:Int){
        list.add(i,t)
        notifyDataSetChanged()
    }

    abstract fun getLayoutId() : Int
    abstract fun getIdVariable() : Int

    override fun onCreateViewHolder(viewHolder: ViewGroup, i: Int): BaseViewHolder<T, VB> {
        binding = DataBindingUtil.inflate(LayoutInflater.from(viewHolder.context),getLayoutId(),viewHolder,false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder : BaseViewHolder<T, VB>, i : Int) {
        viewHolder.setVariable(getIdVariable(), list[i])

    }

    class BaseViewHolder<T,VB : ViewDataBinding>(var binding : VB) : RecyclerView.ViewHolder(binding.root) {
            fun setVariable(id : Int, t: T){
                binding.setVariable(id,t)
            }
    }
    override fun getItemCount() = list.size
}