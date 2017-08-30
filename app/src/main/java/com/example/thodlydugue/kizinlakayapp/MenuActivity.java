package com.example.thodlydugue.kizinlakayapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.thodlydugue.kizinlakayapp.search.ApetizerActivity;
import com.example.thodlydugue.kizinlakayapp.search.DessertActivity;
import com.example.thodlydugue.kizinlakayapp.search.JuiceActivity;
import com.example.thodlydugue.kizinlakayapp.search.MeatActivity;
import com.example.thodlydugue.kizinlakayapp.search.SoupActivity;

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

    ViewPager viewPager;

    CustomPagerAdapter mCustomPagerAdapter;
    int[] mResources = {
            R.drawable.home2,
            R.drawable.home21,
            R.drawable.homemenu,
            R.drawable.background
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutview_menu);



        mCustomPagerAdapter = new CustomPagerAdapter(this);

        viewPager = (ViewPager) findViewById(R.id.pagerrecette);
        viewPager.setAdapter(mCustomPagerAdapter);

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
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search1);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

         return true;
    }


//Slide Image

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView2);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

}
