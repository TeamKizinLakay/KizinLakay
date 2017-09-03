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
public class LogInFragment extends Fragment {

    private EditText UsernameField;
    private EditText PasswordField;


    public LogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);

        Button button = (Button) view.findViewById(R.id.btnLogIn);
        UsernameField = (EditText) view.findViewById(R.id.UsernameLogIn);
        PasswordField = (EditText) view.findViewById(R.id.PasswordLogIn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = UsernameField.getText().toString();
                String password = PasswordField.getText().toString();

                BackendlessUser backendlessUser = new BackendlessUser();
                backendlessUser.setPassword(password);
                backendlessUser.setProperty("email", username);

                Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(getActivity(), "You logged in", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(getActivity(), "Error logging in", Toast.LENGTH_SHORT).show();

                    }
                },true);

            }

        });
        return view;
    }
}



