package com.example.thodlydugue.kizinlakayapp.search;

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
 * Created by sonel on 8/27/2017.
 */

public class JuiceActivity extends AppCompatActivity {


    public static final String AplicationID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SecretKey="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";


   public  ArrayList<recettes> listRecette;
    public  ListView lvrecette;
    public  ListviewrecetteAdapter adapterRecette;


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

        //StringBuilder whereClause = new StringBuilder();
        //whereClause.append( "categories[nom_categorie]" );
        //whereClause.append( ".objectId='" ).append( "1D075E85-8468-6319-FF44-4831E11AB400"  );


        //  String whereClause = "categorie=Viandes";
        IDataStore<Map> personneStorage = Backendless.Data.of( "recettes" );


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        // queryBuilder.setWhereClause( whereClause.toString());

        queryBuilder.setWhereClause("id_categorie='0B7514AA-A148-1ACD-FFF5-A00438A61100'");

        personneStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {

            @Override
            public void handleResponse(List<Map> response) {

                //recette = (recettes.fromListMap(response));
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
                //view is an instance of MovieView
                //Expose details of movie (ratings (out of 10), popularity, and synopsis
                //ratings using RatingBar
                recettes recette = listRecette.get(position);

                Intent intent = new Intent(JuiceActivity.this, DetailsActivity.class);
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
        //// Expand the search view and request focus
        //searchItem.expandActionView();
        //searchView.requestFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                fetchjuice(query);
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                // Set activity title to search query
                JuiceActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;


    }

    private void fetchjuice(String query) {
        lvrecette = (ListView) findViewById(R.id.lvrecette);
        listRecette = new ArrayList<>();
        adapterRecette = new ListviewrecetteAdapter(this, listRecette);

        lvrecette.setAdapter(adapterRecette);




        //StringBuilder whereClause = new StringBuilder();
        //whereClause.append( "categories[nom_categorie]" );
        //whereClause.append( ".objectId='" ).append( "1D075E85-8468-6319-FF44-4831E11AB400"  );


        //  String whereClause = "categorie=Viandes";
        IDataStore<Map> recettesStorage = Backendless.Data.of( "recettes" );


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        // queryBuilder.setWhereClause( whereClause.toString());

        queryBuilder.setWhereClause("nom_recette like'%"+query+"%'");

        recettesStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                //recette = (recettes.fromListMap(response));
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

}
