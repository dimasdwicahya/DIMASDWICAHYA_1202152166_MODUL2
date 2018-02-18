package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DineIn extends AppCompatActivity {

    private Spinner spinner1;
    public TextView nama2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        //inisiasi variable
        spinner1 = (Spinner) findViewById(R.id.Test);
        nama2 = (TextView) findViewById(R.id.inputNama2);

        //menset item ke spinner
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //class adapter untuk spiiner
    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner1.getSelectedItem()); //ngambil data item yg dipilih
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // Dilakukan ketika item dipilih
            } else {
                Toast.makeText(parent.getContext(),
                        String.valueOf(nama2.getText()) + " memilih :" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    }

    //class untuk aksi dari button lanjutan
    public void actionLanjutkan2(View view) {

        //cek kondisi nama sudah diisi apa blm
        nama2 = (EditText) findViewById(R.id.inputNama2);
        if(nama2.getText().toString().length()==0){
            nama2.setError("Masukkan nama anda!");
        }else{
            //pindah ke screen berikutnya
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


}
