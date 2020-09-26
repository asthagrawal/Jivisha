package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_You extends AppCompatActivity {

    Button button_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__you);

        button_quiz=(Button)findViewById(R.id.button_quiz);

        button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About_You.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}