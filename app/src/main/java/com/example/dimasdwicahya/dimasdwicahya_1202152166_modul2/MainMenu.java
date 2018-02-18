package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void actionDineIn(View view) {
        //nampilin toast
        Toast toast = Toast.makeText(getApplicationContext(), "anda memilih Menu Dine In", Toast.LENGTH_SHORT);
        toast.show();

        //pindah ke screen berikutnya
        Intent intent = new Intent(this, DineIn.class);
        startActivity(intent);

    }

    public void actionTakeAway(View view) {
        //nampilin toast
        Toast toast = Toast.makeText(getApplicationContext(), "anda memilih Menu Take Away", Toast.LENGTH_SHORT);
        toast.show();

        //pindah ke screen berikutnya
        Intent intent = new Intent(this, TakeAway.class);
        startActivity(intent);

    }
}
