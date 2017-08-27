package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.example.thodlydugue.kizinlakayapp.search.DessertActivity;


import com.example.thodlydugue.kizinlakayapp.search.JuiceActivity;
import com.example.thodlydugue.kizinlakayapp.search.MeatActivity;
import com.example.thodlydugue.kizinlakayapp.search.SoupActivity;

/**
 * Created by sonel on 8/17/2017.
 */

public class MenuActivity extends AppCompatActivity {
   Button btnmeat;

    Button btndessert;

    Button btndrink;
    Button btnjus;
    Button btnsoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutview_menu);

     btnmeat=(Button)findViewById(R.id.btnmeat);

        btnmeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(MenuActivity.this,MeatActivity.class);
               // intent.putExtra("movie", movie);

                //intent.putExtra("item",adapter.getItem(position));
                startActivity(intent);


            }
        });
        btndessert=(Button)findViewById(R.id.btndessert);

        btndessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, DessertActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });

        btnsoup=(Button)findViewById(R.id.btnsoup);

        btnsoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, SoupActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });

        btndrink=(Button)findViewById(R.id.btndrink);

        btndrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, JuiceActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });
    }
}
