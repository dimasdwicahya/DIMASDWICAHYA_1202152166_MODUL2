package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //nampilin toast
        Toast toast = Toast.makeText(getApplicationContext(), "DIMAS DWI CAHYA 1202152166", Toast.LENGTH_SHORT);
        toast.show();


        //untuk pindah ke screen main menu
        final Intent intent;
        intent = new Intent(this, MainMenu.class);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3500); // waktu untuk jeda
                    startActivity(intent); //mulai pindah ke screen berikutnya
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}
