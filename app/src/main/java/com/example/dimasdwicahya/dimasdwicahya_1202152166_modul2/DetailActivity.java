package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by asus a456 on 18/02/2018.
 */

class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //inisialisasi ImageView dan TextView judul
        TextView foodsTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView foodsImage = (ImageView) findViewById(R.id.foodsImageDetail);


        //ambil drawabel
        Drawable drawable = ContextCompat.getDrawable
                (this, getIntent().getIntExtra(Food.IMAGE_KEY, 0));

        //untuk grading warna aja
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //sesuaikan sizenya dengan gambar
        if (drawable != null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Dapatkan judul dari Intent yang masuk dan setel ke TextView
        foodsTitle.setText(getIntent().getStringExtra(Food.TITLE_KEY));

        //memuat gambar ke dalam ImageView
        Glide.with(this).load(getIntent().getIntExtra(Food.IMAGE_KEY, 0))
                .placeholder(gradientDrawable).into(foodsImage);
    }
}
