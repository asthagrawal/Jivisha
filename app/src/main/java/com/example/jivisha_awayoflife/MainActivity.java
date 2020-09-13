package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    CardView card_view = (CardView) findViewById(R.id.card1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void button1_click(View view) {

        Intent intent=new Intent(this,Doctors.class);
        startActivity(intent);
    }

    public void button2_click(View view) {

        Intent intent=new Intent(this,Home_Remedies.class);
        startActivity(intent);
    }

    public void button3_click(View view) {

        Intent intent=new Intent(this,About_You.class);
        startActivity(intent);
    }

    public void button4_click(View view) {

        Intent intent=new Intent(this,Lifestyle.class);
        startActivity(intent);
    }
}
