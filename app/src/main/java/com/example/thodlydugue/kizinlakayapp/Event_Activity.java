package com.example.thodlydugue.kizinlakayapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by sonel on 9/2/2017.
 */

public class Event_Activity extends AppCompatActivity {


    String currentUrl;

    WebView webvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        setToolbar();

        if (getSupportActionBar() != null) // button option
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webvalue = (WebView)findViewById(R.id.web_value);

        webvalue.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        webvalue.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        webvalue.loadUrl("https://www.instagram.com/kinamhotel/");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        finish();


        return super.onOptionsItemSelected(item);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


    }

    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.coordinator), msg, Snackbar.LENGTH_LONG)
                .show();
    }
}




