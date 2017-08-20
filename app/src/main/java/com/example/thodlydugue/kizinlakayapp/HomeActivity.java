package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
//private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//Set Splash Effect to main activity
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(HomeActivity.this, MenuActivity.class));
                finish();
            }
        }, secondsDelayed * 4000);


      //  bt = (Button) findViewById(R.id.btnStart);
        // bt.setBackgroundColor(Color.BLUE);
       // bt.setOnClickListener(new View.OnClickListener() {
         //   @Override
            //public void onClick(View v) {

               // Intent intent= new Intent(HomeActivity.this,MenuActivity.class);
               // intent.putExtra("movie", movie);
                //intent.putExtra("item",adapter.getItem(position));
                //startActivity(intent);



        //    }
       // });


            }

}
