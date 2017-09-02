package com.example.thodlydugue.kizinlakayapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.thodlydugue.kizinlakayapp.fragment.RegisterFragment;

/**
 * Created by Jerry on 9/2/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterFragment register = new RegisterFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.registerContainer,register).commit();
    }
}
