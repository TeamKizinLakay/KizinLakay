package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Thodly on 8/17/2017.
 */
public class Search_details extends AppCompatActivity {

    private ImageView btHomeSearch;
   ImageView ivRecette;
    TextView Ingredients;
    TextView Description;
    TextView Nomrecette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //button pr
        btHomeSearch = (ImageView) findViewById(R.id.btnHomeSearch);
        btHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Search_details.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    Nomrecette = (TextView) findViewById(R.id.tvNomrecette);
        Description = (TextView) findViewById(R.id.tvDescription);
        Ingredients = (TextView) findViewById(R.id.tvIngredients);
        ivRecette = (ImageView) findViewById(R.id.ivRecette);
    }




}