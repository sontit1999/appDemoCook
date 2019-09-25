package com.duongtung.cookingman.customview.imageslide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.duongtung.cookingman.R
import com.duongtung.cookingman.databinding.SlidePageItemBinding

class ViewPagerAdapter(context: Context?, imageList: List<ItemImageSlide>) : PagerAdapter() {
    interface ItemClickListener {
        fun onItemSelected(position : Int){}
    }
    private var imageList: List<ItemImageSlide>? = imageList
    private var layoutInflater: LayoutInflater? = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    private lateinit var binding : SlidePageItemBinding
    private var itemClickListener: ItemClickListener? = null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return imageList!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View{
        binding = DataBindingUtil.inflate(layoutInflater!!,R.layout.slide_page_item,container,false)
        binding.item = imageList!![position]
        binding.root.setOnClickListener{
            itemClickListener?.onItemSelected(position)
        }
        return binding.root
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}