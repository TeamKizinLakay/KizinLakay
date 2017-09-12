package com.example.thodlydugue.kizinlakayapp.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.thodlydugue.kizinlakayapp.Adapter.favoriteAdapter;
import com.example.thodlydugue.kizinlakayapp.LoginActivity;
import com.example.thodlydugue.kizinlakayapp.Modele.favorites;
import com.example.thodlydugue.kizinlakayapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sonel on 9/11/2017.
 */

public class FavoriteActivity extends AppCompatActivity {
    public static final String AplicationID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SecretKey="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";

    private favorites fav;


    public ArrayList<favorites> listfavorite;
    public ListView lvfavorite;
    public favoriteAdapter adapterfavorite;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backbuttonlight);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setTitle("Recettes Favories");

        Backendless.initApp(getApplicationContext(), AplicationID, SecretKey);


        lvfavorite = (ListView) findViewById(R.id.lvfavorite);
        listfavorite = new ArrayList<>();
        adapterfavorite = new favoriteAdapter(this, listfavorite);

        lvfavorite.setAdapter(adapterfavorite);

        //StringBuilder whereClause = new StringBuilder();
        //whereClause.append( "categories[nom_categorie]" );
        //whereClause.append( ".objectId='" ).append( "1D075E85-8468-6319-FF44-4831E11AB400"  );


        //  String whereClause = "categorie=Viandes";
        IDataStore<Map> recettesStorage = Backendless.Data.of("favorites");


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        // queryBuilder.setWhereClause( whereClause.toString());

        queryBuilder.setWhereClause("id_user=" + LoginActivity.idUser);

      //  setloading();
        recettesStorage.find(queryBuilder, new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                //recette = (recettes.fromListMap(response));
                adapterfavorite.addAll(favorites.fromListMap(response));
                // progress.dismiss();
                adapterfavorite.notifyDataSetChanged();
                Log.d("DEBUG", lvfavorite.toString());
                //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
//Set up Method details view
       /* lvfavorite.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view is an instance of MovieView
                //Expose details of movie (ratings (out of 10), popularity, and synopsis
                //ratings using RatingBar
                favorites favorite = listfavorite.get(position);

                Intent intent = new Intent(FavoriteActivity.this, FavoriteDetails.class);
                intent.putExtra("favorites", favorite);
                startActivity(intent);

            }
        });*/



    }

/*
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
                fetchmeat(query);
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                // Set activity title to search query
                MeatActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;

    }*/

   /* private void fetchmeat(String query) {
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

    public void setloading(){
        progress = new ProgressDialog(this);
        // progress.setTitle("Loading");
        progress.setMessage("Chargement...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
// To dismiss the dialog
        //progress.dismiss();

    }*/






}
