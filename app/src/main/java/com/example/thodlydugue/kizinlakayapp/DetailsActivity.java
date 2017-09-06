package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thodlydugue.kizinlakayapp.Modele.recettes;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;


public class DetailsActivity extends AppCompatActivity {

    TextView tvRecette;
    TextView tvIngredients;
    TextView tvpreparation;
    ImageView ivImage;
    FloatingActionButton btshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbardetails);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backbuttonlight);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //retrieve recette that's been 'sent' from main activity

        recettes recette = (recettes) getIntent().getSerializableExtra("recettes");

        //retrieve all fields and set their value
        tvRecette = ButterKnife.findById(this, R.id.titlerecette);
        tvRecette.setText(recette.getNom_recette());

        tvIngredients = ButterKnife.findById(this, R.id.tvIngredients);
        tvIngredients.setText(recette.getIngredients());

        tvpreparation = ButterKnife.findById(this, R.id.preparation);
        tvpreparation.setText(recette.getPreparation());


        ivImage = ButterKnife.findById(this, R.id.ivrecette);


        final String text =  recette.getNom_recette()+ " " +recette.getIngredients()+ "" +recette.getPreparation();
        Picasso.with(this).load(recette.getImage_recette())
                .into(ivImage);
        btshare = (FloatingActionButton)findViewById(R.id.btnshare);
        btshare.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        text + ""+ "Pour plus de recettes: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
