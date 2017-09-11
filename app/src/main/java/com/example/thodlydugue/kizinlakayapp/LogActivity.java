package com.example.thodlydugue.kizinlakayapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.thodlydugue.kizinlakayapp.fragment.LogInFragment;

/**
 * Created by Jerry on 9/2/2017.
 */

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LogInFragment register = new LogInFragment();
        //getSupportFragmentManager().beginTransaction().add(R.id.registerContainer,register).commit();
    }
}
