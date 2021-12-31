package com.example.comicapp88;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class ManDangBai extends AppCompatActivity {

    TextInputLayout mntheloai,mntrangthai;
    AutoCompleteTextView theloai,trangthai;

    ArrayAdapter<String> adapterItem1;
    ArrayAdapter<String> adapterItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_bai);


        String[] item1 = {"Hoàn thiện","Chưa Hoàn Thiện"};
        String[] item2 = {"Tình Cảm","Kinh Dị","Hành Động","Ngôn Tình"};

        mntheloai = findViewById(R.id.menutheloai);
        theloai = findViewById(R.id.theloai);
        mntrangthai = findViewById(R.id.menutrangthai);
        trangthai = findViewById(R.id.trangthai);

        ArrayAdapter<String> tl = new ArrayAdapter<>(ManDangBai.this,R.layout.text_color_layout,item1);
        theloai.setAdapter(tl);

        ArrayAdapter<String> tt = new ArrayAdapter<>(ManDangBai.this,R.layout.text_color_layout,item2);
        trangthai.setAdapter(tt);

    }
}