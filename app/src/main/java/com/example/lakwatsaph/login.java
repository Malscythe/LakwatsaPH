package com.example.lakwatsaph;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText user, pass;
    private Button btnlogin;
    TextView signup, alterbtn;
    DataConn DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        DB = new DataConn(this);
        login();
        signup();
        goMainPage();
    }
    private void login(){
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnlogin = findViewById(R.id.signinbtn);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_ = user.getText().toString();
                String pass_ = pass.getText().toString();
                Cursor res = DB.checkUser(user_, pass_);

                if(res.getCount() == 0) {
                    Toast.makeText(login.this, "Username and Password is incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    while(res.moveToNext()) {
                        if(user.getText().toString().equals(res.getString(0)) && pass.getText().toString().equals(res.getString(1))) {
                            Toast.makeText(login.this, "Username and Password is correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this, mainpage.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }

    private void signup(){
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });
    }

    private void goMainPage(){
        alterbtn = findViewById(R.id.prototype);
        alterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,mainpage.class);
                startActivity(intent);
            }
        });
    }




}