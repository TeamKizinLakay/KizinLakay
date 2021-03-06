package com.example.thodlydugue.kizinlakayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;

/**
 * Created by Thodly on 8/21/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private ImageButton bthomelogin;
    public static String idUser;
public com.example.thodlydugue.kizinlakayapp.Validator validator;



    private static final int REGISTER_REQUEST_CODE = 1;

    private Button btconnecter;
    private Button btinscrire;

    public static final String APP_ID = "268BBE9A-360E-B2F3-FF8D-C85C0FF31D00";
    public static final String SECRET_KEY = "F07AD7DB-2B05-C77E-FF2A-9BA63E0C1E00";
   // public static final String SERVER_URL = "http://localhost:8080/api";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    /*    bthomelogin = (ImageButton) findViewById(R.id.btnHomeLogin);
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
        if (Backendless.UserService.loggedInUser()== ""){

        }else{
            
        }


    }*/


        Backendless.initApp(this, APP_ID, SECRET_KEY);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(createLoginButtonListener());


        makeRegistrationLink();
    }

    /**
     * Makes registration link clickable and assigns it a click listener.
     */
    public void makeRegistrationLink() {
        SpannableString registrationPrompt = new SpannableString(getString(R.string.register_prompt));

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startRegistrationActivity();
            }
        };

        String linkText = getString(R.string.register_link);
        int linkStartIndex = registrationPrompt.toString().indexOf(linkText);
        int linkEndIndex = linkStartIndex + linkText.length();
        registrationPrompt.setSpan(clickableSpan, linkStartIndex, linkEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView registerPromptView = (TextView) findViewById(R.id.registerPromptText);
        registerPromptView.setText(registrationPrompt);
        registerPromptView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * Sends a request for registration to RegistrationActivity,
     * expects for result in onActivityResult.
     */
    public void startRegistrationActivity()
    {
        Intent registrationIntent = new Intent( this, RegisterActivity.class );
        startActivityForResult( registrationIntent, REGISTER_REQUEST_CODE );
    }

    /**
     * Sends a request to Backendless to log in user by email and password.
     *
     * @param email         user's email
     * @param password      user's password
     * @param loginCallback a callback, containing actions to be executed on request result
     */
    public void loginUser(String email, String password, AsyncCallback<BackendlessUser> loginCallback) {
        Backendless.UserService.login(email, password, loginCallback);
    }

    /**
     * Sends a request to Backendless to log in user with Facebook account.
     * Fetches Facebook user's name and saves it on Backendless.
     *
     * @param loginCallback a callback, containing actions to be executed on request result
     */
   /* public void loginFacebookUser( AsyncCallback<BackendlessUser> loginCallback )
    {
        Map<String, String> fieldsMappings = new HashMap<>();
        fieldsMappings.put( "name", "name" );
        Backendless.UserService.loginWithFacebook( this, null, fieldsMappings, Collections.<String>emptyList(), loginCallback );
    }*/

    /**
     * Sends a request to Backendless to log in user with Twitter account.
     * Fetches Twitter user's name and saves it on Backendless.
     *
     * @param loginCallback a callback, containing actions to be executed on request result
     */
   /* public void loginTwitterUser( AsyncCallback<BackendlessUser> loginCallback )
    {
        Map<String, String> fieldsMappings = new HashMap<>();
        fieldsMappings.put( "name", "name" );
        Backendless.UserService.loginWithTwitter( this, null, fieldsMappings, loginCallback );
    }*/

    /**
     * Creates a listener, which proceeds with login by email and password on button click.
     *
     * @return a listener, handling login button click
     */
    public View.OnClickListener createLoginButtonListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailField = (EditText) findViewById(R.id.emailField);
                EditText passwordField = (EditText) findViewById(R.id.passwordField);

                CharSequence email = emailField.getText();
                CharSequence password = passwordField.getText();

                if (isLoginValuesValid(email, password)) {
                    LoadingCallback<BackendlessUser> loginCallback = createLoginCallback();

                    loginCallback.showLoading();
                    loginUser(email.toString(), password.toString(), loginCallback);
                    //onBackPressed();
                }
            }
        };
    }

    /**
     * Creates a listener, which proceeds with login with Facebook on button click.
     *
     * @return a listener, handling login with Facebook button click
     */

    /**
     * Validates the values, which user entered on login screen.
     * Shows Toast with a warning if something is wrong.
     *
     * @param email    user's email
     * @param password user's password
     * @return true if all values are OK, false if something is wrong
     */
    public boolean isLoginValuesValid(CharSequence email, CharSequence password) {
        return validator.isEmailValid(this, email) && validator.isPasswordValid(this, password);
    }

    /**
     * Creates a callback, containing actions to be executed on login request result.
     * Shows a Toast with BackendlessUser's objectId on success,
     * show a dialog with an error message on failure.
     *
     * @return a callback, containing actions to be executed on login request result
     */
    public LoadingCallback<BackendlessUser> createLoginCallback() {
        return new LoadingCallback<BackendlessUser>(this, getString(R.string.loading_login)) {
            @Override
            public void handleResponse(BackendlessUser loggedInUser) {
                super.handleResponse(loggedInUser);
                Toast.makeText(LoginActivity.this, String.format(getString(R.string.info_logged_in), loggedInUser.getObjectId()), Toast.LENGTH_LONG).show();

                idUser=loggedInUser.getObjectId();

            }
        };
    }

   @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data )
    {
        if( resultCode == RESULT_OK )
        {
            switch( requestCode )
            {
                case REGISTER_REQUEST_CODE:
                    String email = data.getStringExtra( BackendlessUser.EMAIL_KEY );
                    EditText emailField = (EditText) findViewById( R.id.emailField );
                    emailField.setText( email );

                    EditText passwordField = (EditText) findViewById( R.id.passwordField );
                    passwordField.requestFocus();

                    Toast.makeText( this, getString( R.string.info_registered_success ), Toast.LENGTH_SHORT ).show();
            }
        }
    }




}