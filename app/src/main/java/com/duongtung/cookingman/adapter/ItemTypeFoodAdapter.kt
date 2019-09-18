package com.duongtung.cookingman.adapter


import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemRecycleTypeBinding
import com.duongtung.cookingman.model.TypeFood


class ItemTypeFoodAdapter : BaseAdapter<TypeFood,ItemRecycleTypeBinding>() {
    override fun getOnClick()=null

    override fun getIdVariableOnClick(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId() = R.layout.item_recycle_type

    override fun getIdVariable() = BR.typefood
    override fun onBindViewHolder(
        holder: BaseViewHolder<TypeFood, ItemRecycleTypeBinding>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        when(position){
            0 -> Glide.with(binding.imgTypeFood.context).load("https://draxe.com/wp-content/uploads/2018/10/VitaminforSkinThumbnail.jpg").apply(
                RequestOptions().fitCenter()).into(binding.imgTypeFood)
            1->  Glide.with(binding.imgTypeFood.context).load("https://cdn.shopify.com/s/files/1/0071/3637/8998/articles/mens-hair-growth-food_1024x1024.jpg?v=1542111480").apply(
                RequestOptions().fitCenter()).into(binding.imgTypeFood)
            2 -> Glide.with(binding.imgTypeFood.context).load("https://previews.123rf.com/images/baibakova/baibakova1709/baibakova170900375/86483200-food-rich-in-omega-3-fatty-acid-and-healthy-fats-healthy-diet-food-concept-flat-lay.jpg").apply(
                RequestOptions().fitCenter()).into(binding.imgTypeFood)
            3 -> Glide.with(binding.imgTypeFood.context).load("https://img.etimg.com/thumb/height-450,width-800,msid-68901287,imgsize-354672/protein-food-eat-meat-fruit.jpg").apply(
                RequestOptions().fitCenter()).into(binding.imgTypeFood)
        }
    }
}

