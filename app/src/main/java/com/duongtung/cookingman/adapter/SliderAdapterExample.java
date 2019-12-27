package com.duongtung.cookingman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.duongtung.cookingman.R;
import com.duongtung.cookingman.model.Postres;
import com.duongtung.cookingman.ui.home.HomeActivity;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {
    ArrayList<Postres> arrayList = new ArrayList<>();
    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }
    public void setlist(ArrayList<Postres> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
          viewHolder.bind(arrayList.get(position));
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return arrayList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
        public void bind(Postres postres){
            textViewDescription.setText(postres.getNamereipe());
            Glide.with(itemView.getContext())
                    .load(postres.getImage())
                    .into(imageViewBackground);
        }
    }
}