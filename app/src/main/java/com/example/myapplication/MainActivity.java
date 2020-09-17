package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.myapplication.DatabaseStore.COLUMN_INFO;
import static com.example.myapplication.DatabaseStore.COLUMN_EMAIL;
import static com.example.myapplication.DatabaseStore.COLUMN_NUMBER;
import static com.example.myapplication.DatabaseStore.COLUMN_PASSWORD;
import static com.example.myapplication.DatabaseStore.TABLE_USER;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etEmail,etPhoneNumber,  etPassword;
    Button btnRegister, btnLogin;
    DatabaseStore databaseStore;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }
    public void initViews(){

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        databaseStore = new DatabaseStore(this);
        sqLiteDatabase = databaseStore.getReadableDatabase();


    }
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btnRegister:

                boolean Register = true;

                if(etName.getText().toString().isEmpty()) {
                    etName.setError("Try again!");
                    Register = false;
                }

                if(etEmail.getText().toString().isEmpty()) {
                    etEmail.setError("Try again!");
                    Register = false;
                }
                if(etPhoneNumber.getText().toString().isEmpty()) {
                    etPhoneNumber.setError("Try again!");
                    Register = false;
                }

                if(etPassword.getText().toString().isEmpty()) {
                    etPassword.setError("Try again!");
                    Register = false;
                }
                if(Register){
                    //insert database

                    ContentValues userValue = new ContentValues();
                    userValue.put(COLUMN_INFO, etName.getText().toString());
                    userValue.put(COLUMN_EMAIL, etEmail.getText().toString());
                    userValue.put(COLUMN_NUMBER, etPhoneNumber.getText().toString());
                    userValue.put(COLUMN_PASSWORD, etPassword.getText().toString());

                    sqLiteDatabase.insert(TABLE_USER,null, userValue);

                    Toast.makeText(this, "Registration was success!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Fill clearly & try again!", Toast.LENGTH_SHORT).show();
                }

        }
    }


}



