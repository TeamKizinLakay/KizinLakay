package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);






        bt = (Button) findViewById(R.id.btnStart);
        // bt.setBackgroundColor(Color.BLUE);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(HomeActivity.this,MenuActivity.class);
               // intent.putExtra("movie", movie);
                //intent.putExtra("item",adapter.getItem(position));
                startActivity(intent);



            }
        });


            }

}
