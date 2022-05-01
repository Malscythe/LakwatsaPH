package com.example.lakwatsaph;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    EditText user, pass, email;
    Button btnsignup;
    DataConn DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        DB = new DataConn(this);
        signup();
    }

    private void signup(){
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pword);
        email = findViewById(R.id.email);
        btnsignup = findViewById(R.id.signupbtn);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("")) {
                    Toast.makeText(signup.this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
                }else if(user.getText().length() > 17) {
                    Toast.makeText(signup.this, "Username should be up to 17 characters", Toast.LENGTH_SHORT).show();
                }
                if(email.getText().toString().equals("")){
                    Toast.makeText(signup.this, "Enter your E-mail", Toast.LENGTH_SHORT).show();
                }
                if(pass.getText().toString().equals("")){
                    Toast.makeText(signup.this, "Enter your Password", Toast.LENGTH_SHORT).show();
                }
                String user_ = user.getText().toString();
                String pass_ = pass.getText().toString();
                String email_ = email.getText().toString();
                Boolean insertAcc = DB.insertAcc(user_,pass_,email_);
                if(insertAcc == true){
                    Intent intent = new Intent(signup.this,login.class);
                    startActivity(intent);
                }
            }
        });
    }
}
