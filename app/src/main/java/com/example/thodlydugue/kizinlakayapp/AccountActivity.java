package com.example.thodlydugue.kizinlakayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;

/**
 * Created by sonel on 9/11/2017.
 */

public class AccountActivity extends AppCompatActivity{


    public static final String AplicationID="268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SecretKey="F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";

    TextView txtemail;
String userid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        userid = LoginActivity.idUser;

        // txtemail = ButterKnife.findById(this, R.id.txtaccount);
        //txtemail.setText(user.getEmail());
        BackendlessUser user;

        try
        {
            user = Backendless.UserService.login( userid,userid );
        }
        catch( BackendlessException exception )
        {
            // login failed, to get the error code, call exception.getFault().getCode()
        }

        try
        {
            // now log out:
            Backendless.UserService.logout();
        }
        catch( BackendlessException exception )
        {
            // logout failed, to get the error code, call exception.getFault().getCode()
        }
    }


}
