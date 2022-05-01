package com.example.lakwatsaph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class mainpage extends AppCompatActivity {
    RelativeLayout placeClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        clickPlace();
    }

    void clickPlace(){
        placeClicked = findViewById(R.id.minesviewpark);

        placeClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainpage.this,placedetail.class);
                startActivity(intent);
            }
        });
    }
}
