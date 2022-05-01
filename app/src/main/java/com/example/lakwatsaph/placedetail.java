package com.example.lakwatsaph;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;

public class placedetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placedetail);
        getDirect();
    }

    private void getDirect(){
        Button btnGetdirect = findViewById(R.id.direction);
        btnGetdirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(placedetail.this,maps.class);
                startActivity(intent);
            }
        });
    }
}

