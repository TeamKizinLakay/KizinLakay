package com.example.thodlydugue.kizinlakayapp.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.thodlydugue.kizinlakayapp.Adapter.ListviewrecetteAdapter;
import com.example.thodlydugue.kizinlakayapp.Modele.recettes;
import com.example.thodlydugue.kizinlakayapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sonel on 8/26/2017.
 */

public class DessertActivity extends AppCompatActivity {


    public static final String AplicationID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SecretKey="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        Backendless.initApp(getApplicationContext(), AplicationID, SecretKey);

        final ArrayList<recettes> listRecette;
        final ListView lvrecette;
        final ListviewrecetteAdapter adapterRecette;


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

        queryBuilder.setWhereClause("id_categorie='214D0C44-AA8D-CE09-FFA1-C4307EAE5700'");

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



    }
}
