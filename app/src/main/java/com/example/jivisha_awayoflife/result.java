package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class result extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        LinearLayout linearlayout = findViewById(R.id.linearlayout2);



        drawpie();
    }

    private void drawpie()
    {
        AnimatedPieView mAnimatedPieView = findViewById(R.id.AnimatedPieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo( 49, Color.parseColor("#6ee1f5"), "VATA \t 49"))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(43.0f, Color.parseColor("#ffa647"), "PITTA \t 43"))
                .addData(new SimplePieInfo(37.0f, Color.parseColor("#4c788a"), "KAPHA \t 37")).drawText(true) .strokeMode(false)

                .duration(2000).textSize(35);// draw pie animation duration

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }


}