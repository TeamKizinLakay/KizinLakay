package com.example.thodlydugue.kizinlakayapp.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thodlydugue.kizinlakayapp.R;

/**
 * Created by sonel on 8/23/2017.
 */

public class SearchActivity extends AppCompatActivity {
public com.example.thodlydugue.kizinlakayapp.Modele.recettes recettes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //initViews();
       /* Backendless.setUrl( BackendSettings.SERVER_URL );
        Backendless.initApp(getApplicationContext(),BackendSettings.AplicationID,BackendSettings.SecretKey);

        IDataStore<Map> contactStorage = Backendless.Data.of( "recettes" );
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        // set where clause
        queryBuilder.setWhereClause( "id_categorie=meats" );

        // set related columns
        queryBuilder.setRelated( "recettes", "categorie" );

        // request sorting
        queryBuilder.setSortBy( "nom_recette" );

        // set offset and page size
        queryBuilder.setPageSize( 20 );
        queryBuilder.setOffset( 40 );

        contactStorage.find( queryBuilder, new AsyncCallback<List<map>>()
        {
            @Override
            public void handleResponse( List<Map> contactObjects )
            {
               // Log.i( "MYAPP", "Retrieved " + contactObjects.size() + " objects" );

                initViews();
            }

            @Override
            public void handleFault( BackendlessFault fault )
            {
                Log.e( "MYAPP", "Server reported an error " );
            }
        } );


    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvrecettes);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

       // ArrayList<AndroidVersion> androidVersions = prepareData();
       // RecyclerViewRecetteAdapter adapter = new RecyclerViewRecetteAdapter(getApplicationContext(),androidVersions);
        //recyclerView.setAdapter(adapter);

    }*/
    }

}
