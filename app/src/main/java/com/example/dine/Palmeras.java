package com.example.dine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Palmeras extends AppCompatActivity {
    ImageButton btnHeart;
    ImageButton btnShare;
    private boolean isLike;
    Button reserveNowBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palmeras);

        //        back button
        ImageButton button = findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
        //        like button
        btnHeart=findViewById(R.id.btnHeart);
        btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isLike){
                    isLike=true;
                    btnHeart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_btn_heart_filled
                    ));
                    Toast.makeText(Palmeras.this, "You liked this location", Toast.LENGTH_SHORT).show();
                }
                else{
                    isLike=false;
                    btnHeart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_btn_heart
                    ));
                    Toast.makeText(Palmeras.this, "You removed like in this location", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //        share button
        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Body = "Download this App";
                String Sub = "http://play.google.com";
                intent.putExtra(Intent.EXTRA_TEXT, Body);
                intent.putExtra(Intent.EXTRA_TEXT, Sub);
                startActivity(Intent.createChooser(intent, "Share using"));
                Toast.makeText(Palmeras.this, "You are sharing SanPabLOOK", Toast.LENGTH_SHORT).show();
            }
        });

//        reserve now button
        Button reserveNowBtn1 = findViewById(R.id.reserveNowBtn1);
        reserveNowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Palmeras.this, com.example.dine.reservation_palmeras.class);
                startActivity(intent);

            }
        });

    }
}