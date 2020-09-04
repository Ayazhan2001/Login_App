package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mname, memail, mpassword;
    Button mregister, mlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mname = findViewById(R.id.name);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mregister = findViewById(R.id.register);
        mlogin = findViewById(R.id.login);


        mregister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String fullname = mname.getText().toString().trim();
                        String email = memail.getText().toString().trim();
                        String password = mpassword.getText().toString().trim();

                        if(TextUtils.isEmpty(fullname)){
                            mname.setError("Full Name is Required!");
                            return;
                        }
                        if(TextUtils.isEmpty(email)){
                            memail.setError("Email is required!");
                            return;
                        }
                        if(TextUtils.isEmpty(password)){
                            mpassword.setError("Password is required!");
                            return;
                        }
                        if(password.length() < 6){
                            mpassword.setError("Password must be >= 6Characters");
                            return;
                        }
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);






                    }
                }
        );
        mlogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
        );











    }
}
