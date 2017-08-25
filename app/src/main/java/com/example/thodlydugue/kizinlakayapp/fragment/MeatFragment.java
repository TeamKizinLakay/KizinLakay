package com.example.thodlydugue.kizinlakayapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.thodlydugue.kizinlakayapp.utils.BackendSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sonel on 8/17/2017.
 */

public class MeatFragment extends Fragment{
    public ArrayList<com.example.thodlydugue.kizinlakayapp.Modele.recettes> recettes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Backendless.setUrl( BackendSettings.SERVER_URL );
        Backendless.initApp(getActivity().getApplicationContext(),BackendSettings.AplicationID,BackendSettings.SecretKey);

       IDataStore<Map> recette = Backendless.Data.of( "recettes" );
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        recette.find( queryBuilder, new AsyncCallback<List<Map>>()
        {
            @Override
            public void handleResponse( List<Map> recetteObjects )
            {
               // Log.i( "MYAPP", "Retrieved " + recetteObjects.size() + " objects" );
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void handleFault( BackendlessFault fault )
            {
                Log.e( "MYAPP", "Server reported an error " + fault.getMessage() );
            }


        } );


       // View v = inflater.inflate(, null,false);

       // TextView tvrecette=(TextView)v.findViewById(R.id.txtrecette);


return null;

    }

}
