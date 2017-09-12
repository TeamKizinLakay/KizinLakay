package com.example.thodlydugue.kizinlakayapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thodlydugue.kizinlakayapp.Adapter.SlidingImage_Adapter;
import com.example.thodlydugue.kizinlakayapp.search.ApetizerActivity;
import com.example.thodlydugue.kizinlakayapp.search.DessertActivity;
import com.example.thodlydugue.kizinlakayapp.search.JuiceActivity;
import com.example.thodlydugue.kizinlakayapp.search.MeatActivity;
import com.example.thodlydugue.kizinlakayapp.search.SoupActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sonel on 8/17/2017.
 */

public class MenuActivity extends AppCompatActivity {
    Button btnmeat;
    Button btndessert;
    Button btndrink;
    Button btnaperitif;
    Button btnsoup;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    private static final Integer[] IMAGES= {
            R.drawable.slide1,
            R.drawable.slide3,
            R.drawable.slide2,
            R.drawable.slide4,
            R.drawable.slide5
    };
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutview_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        btnmeat=(Button)findViewById(R.id.btnmeat);

        btnmeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(MenuActivity.this,MeatActivity.class);
                // intent.putExtra("movie", movie);

                //intent.putExtra("item",adapter.getItem(position));
                startActivity(intent);


            }
        });
        btndessert=(Button)findViewById(R.id.btndessert);

        btndessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(MenuActivity.this, DessertActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });



        btnsoup=(Button)findViewById(R.id.btnsoup);

        btnsoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, SoupActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });

        btndrink=(Button)findViewById(R.id.btndrink);

        btndrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, JuiceActivity.class);
                // intent.putExtra("movie", movie);

                startActivity(intent);

            }
        });
        btnaperitif=(Button)findViewById(R.id.btnAperitif);

        btnaperitif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MenuActivity.this, ApetizerActivity.class);
                startActivity(intent);

            }
        });



        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pagerrecette);


        mPager.setAdapter(new SlidingImage_Adapter(MenuActivity.this,ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        //final MenuItem searchItem = menu.findItem(R.id.action_search1);
        //final MenuItem eventitem = menu.findItem(R.id.action_event);
        // final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        // final SearchView searchView1 = (SearchView) MenuItemCompat.getActionView(eventitem);

        return true;
    }


//Set Events in item button in Toolbar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_event:
                showEvent();
                return true;
            case R.id.action_account:
                // showHelp();
                Account();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showEvent()
    {
        Intent intent = new Intent(MenuActivity.this, Event_Activity.class);
        startActivity(intent);
    }
    private void Account()
    {
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}