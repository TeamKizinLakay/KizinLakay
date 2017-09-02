package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.backendless.Backendless;

/**
 * Created by Thodly on 8/21/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private ImageButton bthomelogin;
    private Button btconnecter;
    private Button btinscrire;

    public static final String APP_ID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SECRET_KEY="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";
    public static final String SERVER_URL = "http://localhost:8080/api";



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

        btconnecter = (Button) findViewById(R.id.btnConnecter);
        btconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, LogActivity.class);
                startActivity(intent);
            }

        });

        btinscrire = (Button) findViewById(R.id.btnInscrire);
        btinscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Backendless.initApp(this,APP_ID,SECRET_KEY);
    }
}