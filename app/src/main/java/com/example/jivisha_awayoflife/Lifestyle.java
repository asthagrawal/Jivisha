package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lifestyle extends AppCompatActivity {

    Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);

        b1=(Button)findViewById(R.id.l1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lifestyle.this,Lifestyle1.class);
                startActivity(intent);
            }
        });

        b2=(Button)findViewById(R.id.l2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lifestyle.this,Lifestyle2.class);
                startActivity(intent);
            }
        });

        b3=(Button)findViewById(R.id.l3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Lifestyle.this,Lifestyle3.class);
                startActivity(intent);
            }
        });



    }




}
