package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jerry on 8/22/2017.
 */

public class PrincipalSearch extends AppCompatActivity {


    EditText etQuery;
    GridView gvResults;
    Button btnSearch;

    ArrayList<Recette> recette;
    RecetteArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.principal_search);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar(toolbar);


        setupViews();
    }



    public void setupViews(){

        etQuery = (EditText) findViewById (R.id.etQuery);
        gvResults = (GridView) findViewById (R.id.gvResults);
        btnSearch = (Button) findViewById (R.id.btnSearch);
        recette = new ArrayList<>();
        adapter = new RecetteArrayAdapter(this,recette);
       gvResults.setAdapter(adapter);

        gvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), Search_details.class);

                 Recette recet = recette.get(position);
                //i.putExtra("article", article);
                startActivity(i);

            }
        });

    }



    public void onRecetteSearch(View view) {
        String query = etQuery.getText().toString();
        Toast.makeText(this, "Searching for" + query, Toast.LENGTH_SHORT).show();

                    //Log.d("DEBUG", response.toString());





    }
}

