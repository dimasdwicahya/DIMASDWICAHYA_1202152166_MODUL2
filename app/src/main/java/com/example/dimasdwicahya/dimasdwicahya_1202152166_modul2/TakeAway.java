package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TakeAway extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
    }

    //class untuk aksi dari button lanjutan
    public void actionLanjutkan(View view) {


        //inisiasi variable
        EditText nama = (EditText) findViewById(R.id.inputNama);
        EditText nohp = (EditText) findViewById(R.id.inputNoHp);
        EditText alamat = (EditText) findViewById(R.id.inputAlamat);


        //cek kondisi apakah inputan sudah terisi apa blm
        if(nama.getText().toString().length()==0){
            nama.setError("Masukkan nama anda!");
        }else if(nohp.getText().toString().length()==0){
            nohp.setError("Masukkan no hp anda!");
        }else if(alamat.getText().toString().length()==0){
            alamat.setError("Masukkan alamat anda!");
        } else{
            //pindah ke screen berikutnya
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }



    }
}
