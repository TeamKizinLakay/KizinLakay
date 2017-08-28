package com.example.thodlydugue.kizinlakayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thodlydugue.kizinlakayapp.Modele.recettes;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;

import static com.example.thodlydugue.kizinlakayapp.R.id;

/**
 * Created by sonel on 8/27/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    TextView tvRecette;
    TextView tvIngredients;
    TextView tvpreparation;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //retrieve recette that's been 'sent' from main activity
        final recettes recette = (recettes) getIntent().getSerializableExtra("recette");


        //retrieve all fields and set their value
        tvRecette = ButterKnife.findById(this, R.id.titlerecette);
        tvRecette.setText(recette.getNom_recette());

        tvIngredients = ButterKnife.findById(this, R.id.tvIngredients);
        tvIngredients.setText("Ingredients: " + recette.getIngredients());

        tvpreparation = ButterKnife.findById(this, R.id.preparation);
        tvpreparation.setText(recette.getPreparation());

        ivImage = ButterKnife.findById(this, id.imrecette);

    /*    ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                //launch video activity
               // intent = new Intent(MovieDetails.this, YouTubeActivity.class);

                if (intent != null) {
                    // put movie as "extra" into the bundle for access in YouTubeActivity
                 intent.putExtra("recette", recette);
                    startActivity(intent);
                }

            }
        });*/

        Picasso.with(this).load(recette.getImage_recette())
                .into(ivImage);

    }


}
