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
 * Created by Jerry on 8/20/2017.
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
        setContentView (R.layout.search_principal);
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

               // Recette recette = recette.get(position);
                //i.putExtra("article", article);
                startActivity(i);

            }
        });

    }



    public void onRecetteSearch(View view) {
        String query = etQuery.getText().toString();
        Toast.makeText(this, "Searching for" + query, Toast.LENGTH_SHORT).show();
        /*AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://api.nytimes.com/svc/search/v2/articlesearch.json";

        RequestParams params = new RequestParams();
        params.put("api-key", "198bc0cf37d3483692645939c3632343");
        params.put("page", 0);
        params.put("q", query);
        client.get(url,params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                //Log.d("DEBUG", response.toString());
                //System.out.println("Debug");
                JSONArray articleJsonResults = null;
                try{
                    articleJsonResults = response.getJSONObject("response").getJSONArray("docs");

                    adapter.addAll(Article.fromJSONArray(articleJsonResults));

                    //Log.d("DEBUG", response.toString());

                }catch(JSONException e){
                    e.printStackTrace();

                }
            }
        });*/
    }
}
