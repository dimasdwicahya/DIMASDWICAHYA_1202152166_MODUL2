/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the sports data
 */
class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder> {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Food> mFoodsData;
    private Context mContext;


    //adapter untuk food (ngambil data dsb)
    FoodsAdapter(Context context, ArrayList<Food> foodsData) {
        this.mFoodsData = foodsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext, R.drawable.food_1);
        if (drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public FoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FoodsViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(FoodsAdapter.FoodsViewHolder holder, int position) {

        //mengambil posisi food saat ini
        Food currentFood = mFoodsData.get(position);

        //taruh untuk ditampilkan
        holder.bindTo(currentFood);

    }


    @Override
    public int getItemCount() {
        return mFoodsData.size();
    }

    static class FoodsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //variable yang akan dipakai
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mFoodsImage;
        private Context mContext;
        private Food mCurrentFood;
        private GradientDrawable mGradientDrawable;


        //Constructor untuk SportsViewHolder, yg digunakan di onCreateViewHolder()

        FoodsViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //inisialisasi View
            mTitleText = (TextView) itemView.findViewById(R.id.title);
            mInfoText = (TextView) itemView.findViewById(R.id.subTitle);
            mFoodsImage = (ImageView) itemView.findViewById(R.id.foodsImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Setel  OnClickListener di setiap view ini
            itemView.setOnClickListener(this);
        }

        void bindTo(Food currentFood) {
            //Masukkan data ke textviews
            mTitleText.setText(currentFood.getTitle());
            mInfoText.setText(currentFood.getInfo());

            //Ngambil food saat ini
            mCurrentFood = currentFood;


            //Menampung gambar ke ImageView menggunakan Glide library
            Glide.with(mContext).load(currentFood.
                    getImageResource()).placeholder(mGradientDrawable).into(mFoodsImage);
        }

        @Override
        public void onClick(View view) {

            //Atur detail intent
            Intent detailIntent = Food.starter(mContext, mCurrentFood.getTitle(),
                    mCurrentFood.getImageResource());

            //Memulai detail activity
            mContext.startActivity(detailIntent);
        }
    }
}
