package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by asus a456 on 18/02/2018.
 */

class Food {

    //inisialisasi variable
    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    //konstruktor untuk mengambil sebuah integer sebagai parameter dan menetapkannya ke variabel anggota
    Food(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    //ngambil data title, info


    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }


    int getImageResource() {
        return imageResource;
    }

    //intent ke detail activity
    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
