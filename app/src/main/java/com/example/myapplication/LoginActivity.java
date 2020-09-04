package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    String mystring = "Welcome!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        Toast.makeText(getApplicationContext(), mystring, Toast.LENGTH_SHORT).show();

    }
}
