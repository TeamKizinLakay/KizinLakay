package com.example.thodlydugue.kizinlakayapp.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.thodlydugue.kizinlakayapp.Adapter.ListviewrecetteAdapter;
import com.example.thodlydugue.kizinlakayapp.DetailsActivity;
import com.example.thodlydugue.kizinlakayapp.Modele.recettes;
import com.example.thodlydugue.kizinlakayapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Thodly on 8/29/2017.
 */

public class ApetizerActivity extends AppCompatActivity {

    public static final String AplicationID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SecretKey="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";

    private recettes recette;


    public ArrayList<recettes> listRecette;
    public ListView lvrecette;
    public ListviewrecetteAdapter adapterRecette;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backbuttonlight);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Backendless.initApp(getApplicationContext(), AplicationID, SecretKey);


        lvrecette = (ListView) findViewById(R.id.lvrecette);
        listRecette = new ArrayList<>();
        adapterRecette = new ListviewrecetteAdapter(this, listRecette);

        lvrecette.setAdapter(adapterRecette);

        IDataStore<Map> recettesStorage = Backendless.Data.of( "recettes" );

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setWhereClause("id_categorie='EDDE2B68-53E6-FE35-FFDF-A555E20A9800'");

        recettesStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                adapterRecette.addAll(recettes.fromListMap(response));
                adapterRecette.notifyDataSetChanged();
                Log.d("DEBUG",lvrecette.toString());
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        lvrecette.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                recettes recette = listRecette.get(position);

                Intent intent = new Intent(ApetizerActivity.this, DetailsActivity.class);
                intent.putExtra("recettes", recette);
                startActivity(intent);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                fetchmeat(query);
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
              ApetizerActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;

    }

    private void fetchmeat(String query) {
        lvrecette = (ListView) findViewById(R.id.lvrecette);
        listRecette = new ArrayList<>();
        adapterRecette = new ListviewrecetteAdapter(this, listRecette);

        lvrecette.setAdapter(adapterRecette);
        IDataStore<Map> recettesStorage = Backendless.Data.of( "recettes" );


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setWhereClause("nom_recette like'%"+query+"%'");

        recettesStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {
                adapterRecette.addAll(recettes.fromListMap(response));
                adapterRecette.notifyDataSetChanged();
                Log.d("DEBUG",lvrecette.toString());
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }



    private void setUpClickListener() {
        lvrecette.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view is an instance of MovieView
                //Expose details of movie (ratings (out of 10), popularity, and synopsis
                //ratings using RatingBar
                recettes recette = listRecette.get(position);

                Intent intent = new Intent(ApetizerActivity.this, DetailsActivity.class);
                intent.putExtra("recettes",recette);
                startActivity(intent);
            }
        });

    }



}
