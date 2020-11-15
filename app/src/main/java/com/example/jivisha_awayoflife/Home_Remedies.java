package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Remedies extends AppCompatActivity {


    Button btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15, btn16, btn17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn1 = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn2);
        btn4 = findViewById(R.id.btn3);
        btn5 = findViewById(R.id.btn4);
        btn6 = findViewById(R.id.btn5);
        btn7 = findViewById(R.id.btn6);
        btn8 = findViewById(R.id.btn7);
        btn9 = findViewById(R.id.btn8);
        btn10 = findViewById(R.id.btn9);
        btn11 = findViewById(R.id.btn10);
        btn12 = findViewById(R.id.btn11);
        btn13 = findViewById(R.id.btn12);
        btn14 = findViewById(R.id.btn13);
        btn15 = findViewById(R.id.btn14);
        btn16 = findViewById(R.id.btn15);
        btn17 = findViewById(R.id.btn16);

        setContentView(R.layout.activity_home__remedies);

    }
    public void Goto_Remedies(View view){
        Intent intent = new Intent(this, Fetch.class);
        String txt = ((Button) view).getText().toString();
        intent.putExtra("DISEASE", txt);
        startActivity(intent);
    };

    public void lifestyle1(View view) {
        setContentView(R.layout.lifestyle1);

    }

    public void lifestyle2(View view) {
        setContentView(R.layout.lifestyle2);
    }

    public void lifestyle3(View view) {
        setContentView(R.layout.lifestyle3);
    }
}