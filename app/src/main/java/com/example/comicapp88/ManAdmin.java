package com.example.comicapp88;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManAdmin extends AppCompatActivity {

    Button buttonThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_admin);

        buttonThem = findViewById(R.id.buttonThemTruyen);

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManAdmin.this,ManDangBai.class);
                startActivity(intent);
            }
        });
    }
}