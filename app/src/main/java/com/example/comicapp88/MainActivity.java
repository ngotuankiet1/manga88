package com.example.comicapp88;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.comicapp88.Model.chuyenmuc;
import com.example.comicapp88.adapter.adapterchuyenmuc;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;

    adapterchuyenmuc adapterchuyenmuc;
    ArrayList<chuyenmuc> chuyenmucArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        ActionBar();
//        ActionViewFlipper();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                        Intent intent = new Intent(MainActivity.this,ManAdmin.class);
                        startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(MainActivity.this,ManTheLoai.class);
                    startActivity(intent);
                }else if(position == 2){
                    finish();
                }
            }
        });
    }

    private void ActionBar() {
        //hàm hỗ trợ toolbar
        setSupportActionBar(toolbar);

        //set nút cho actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tạo icon
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa(){
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
//        viewFlipper = findViewById(R.id.viewflipper);
        listView = findViewById(R.id.listviewmanhinhchinh);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);


        //thông tin
//        adapterthongtin = new adapterthongtin(this,R.layout.navigation_thongtin);
//        listViewThongTin.setAdapter(adapterthongtin);

        //chuyên mục
        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài",R.drawable.post));
        chuyenmucArrayList.add(new chuyenmuc("Thể loại",R.drawable.category));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất",R.drawable.logout));

        adapterchuyenmuc = new adapterchuyenmuc(this,R.layout.chuyenmuc,chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cmangaka.com/assets/tmp/book/avatar/1633276446-5873.jpg");
        mangquangcao.add("https://cmangaka.com/assets/tmp/book/avatar/1606176963-483.jpg");
        mangquangcao.add("https://cmangaka.com/assets/tmp/book/avatar/1640440456-1887.jpg");
        mangquangcao.add("https://cmangaka.com/assets/tmp/book/avatar/1640593211-3731.jpg");

        //load ảnh
        for (int i =0;i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());

            Picasso.get().load(mangquangcao.get(i)).into(imageView);

            //phương thức chỉnh tấm hình vừa khung quảng cáo
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            viewFlipper.addView(imageView);
        }

        // thiết lập tự động chạy trong 4s
        viewFlipper.setFlipInterval(4000);

        //run auto animation
        viewFlipper.setAutoStart(true);

        //gọi animation cho vào và ra
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);

        //gọi animation vào viewFlipper
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setInAnimation(animation_slide_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(MainActivity.this,ManTimKiem.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}