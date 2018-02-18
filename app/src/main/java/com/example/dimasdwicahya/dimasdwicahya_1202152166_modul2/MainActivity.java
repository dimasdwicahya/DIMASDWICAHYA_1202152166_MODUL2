package com.example.dimasdwicahya.dimasdwicahya_1202152166_modul2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //variable
    private RecyclerView mRecyclerView;
    private ArrayList<Food> mFoodsData;
    private FoodsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ambil integer dari file sumber daya integers.xml
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        setContentView(R.layout.activity_main);

        //inisialisasi RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //mengatur layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //wadah /aray untuk data
        mFoodsData = new ArrayList<>();

        //inisiasi adapter
        mAdapter = new FoodsAdapter(this, mFoodsData);
        mRecyclerView.setAdapter(mAdapter);

        //ngambil data
        initializeData();


        //cek kondisi untuk menonaktifkan tindakan gesek jika terdapat lebih dari satu kolom
        int swipeDirs;
        if (gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        //Class Helper untuk membuat funsgi swipe, drag, drop
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //ngambil dari mana ke mana
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //mengswap item
                Collections.swap(mFoodsData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //hapus item dari set data
                mFoodsData.remove(viewHolder.getAdapterPosition());

                //kirim ke adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }


        });
        //masukkan helper ke RecyclerView
        helper.attachToRecyclerView(mRecyclerView);

    }

    private void initializeData() {
        //mengambil resources dari xml
        String[] foodsList = getResources().getStringArray(R.array.foods_titles);
        String[] foodsInfo = getResources().getStringArray(R.array.foods_info);
        TypedArray foodsImageResources = getResources().obtainTypedArray(R.array.foods_images);
        //hapus apabila sudah ada
        mFoodsData.clear();

        //membuat ArrayList dari Sports objects with the titles, images dan informasi tentang sport lainnya
        for (int i = 0; i < foodsList.length; i++) {
            mFoodsData.add(new Food(foodsList[i], foodsInfo[i],
                    foodsImageResources.getResourceId(i, 0)));
        }

        //untuk membersihkan data di TypedArray setelah Anda membuat ArrayList data Sport
        foodsImageResources.recycle();

        //Pemberitahuan ketika ada perubahan
        mAdapter.notifyDataSetChanged();
    }

    //method untuk menyetel ulang data
    public void resetFoods(View view) {
        initializeData();
    }

}
