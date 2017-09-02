package com.example.thodlydugue.kizinlakayapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.thodlydugue.kizinlakayapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private EditText UsernameField;
    private EditText PasswordField;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);

        Button button = (Button) view.findViewById(R.id.btnRegister);
        UsernameField = (EditText) view.findViewById(R.id.UsernameRegister);
        PasswordField = (EditText) view.findViewById(R.id.PasswordRegister);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String username = UsernameField.getText().toString();
                String password = PasswordField.getText().toString();

                //Register a User

                BackendlessUser backendlessUser = new BackendlessUser();
                backendlessUser.setPassword(password);
                backendlessUser.setProperty("email", username);

                Backendless.UserService.register(backendlessUser, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(getActivity(), "You registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getActivity(), "You are not registered", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "error" +fault.getDetail(), Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });

        return view;
    }

}
