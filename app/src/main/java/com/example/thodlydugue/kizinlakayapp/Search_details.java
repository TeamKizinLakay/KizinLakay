package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Thodly on 8/17/2017.
 */
public class Search_details extends AppCompatActivity {
    private ImageView btHomeSearch;
    private Button btDetails;
    private ImageButton btaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //button pr
        btHomeSearch = (ImageView) findViewById(R.id.btnHomeSearch);
        btHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Search_details.this,MenuActivity.class);
                startActivity(intent);
            }
        });


        btaccount = (ImageButton) findViewById(R.id.btnAccount);
        btaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Search_details.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        btDetails = (Button) findViewById(R.id.btnDetails);
        btDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Search_details.this,Details.class);
                startActivity(intent);
            }
        });
    }
}