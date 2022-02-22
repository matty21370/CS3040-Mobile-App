package com.matty.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText editTextUsername, editTextPassword;
    private TextView textViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.btnLogin);
        editTextUsername = findViewById(R.id.edtTxtUsername);
        editTextPassword = findViewById(R.id.edtTxtPassword);
        textViewUsername = findViewById(R.id.txtUsername);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = User.authenticate(editTextUsername.getText().toString(), editTextPassword.getText().toString(), MainActivity.this);
                if(user != null) {
                    textViewUsername.setText(user.getUsername());
                }
                else {
                    textViewUsername.setText(R.string.user_failed);
                }
            }
        });
    }
}