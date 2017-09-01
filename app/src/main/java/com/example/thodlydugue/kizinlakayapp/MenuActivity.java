package com.example.thodlydugue.kizinlakayapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thodlydugue.kizinlakayapp.Adapter.SlidingImage_Adapter;
import com.example.thodlydugue.kizinlakayapp.search.ApetizerActivity;
import com.example.thodlydugue.kizinlakayapp.search.DessertActivity;
import com.example.thodlydugue.kizinlakayapp.search.JuiceActivity;
import com.example.thodlydugue.kizinlakayapp.search.MeatActivity;
import com.example.thodlydugue.kizinlakayapp.search.SoupActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by sonel on 8/17/2017.
 */

public class MenuActivity extends AppCompatActivity {
   Button btnmeat;

    Button btndessert;

    Button btndrink;

    Button btnapptizer;

    Button btnaperitif;

    Button btnsoup;

    ImageButton btnaccount;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    private static final Integer[] IMAGES= {
            R.drawable.home2,
            R.drawable.home21,
            R.drawable.home1,
            R.drawable.boissons
    };
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutview_menu);
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

        btnaccount = (ImageButton) findViewById(R.id.btnAccount);
        btnaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
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
        }, 3000, 3000);

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
        final MenuItem searchItem = menu.findItem(R.id.action_search1);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

         return true;
    }


//Slide Image



}
