package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

//    String city;
//    EditText location;
//    Button button;

//    CardView card_view = (CardView) findViewById(R.id.card1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        location=(EditText) findViewById(R.id.location) ;
//        button=(Button)findViewById(R.id.button) ;





//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                city= location.getText().toString();
//
//                Intent intent=new Intent(MainActivity.this,Doctors.class);
//                intent.putExtra("Location", city);
//                startActivity(intent);
//
//            }
//        });

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
