package com.example.thodlydugue.kizinlakayapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thodlydugue.kizinlakayapp.fragment.MenuFragment;

/**
 * Created by Thodly on 8/21/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private ImageButton bthomelogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        bthomelogin = (ImageButton) findViewById(R.id.btnHomeLogin);
        bthomelogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    });
}
}