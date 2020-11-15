package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class result extends AppCompatActivity {
    private Button button;
    int a,b,c;
    int vatap, pittap, kaphap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        LinearLayout linearlayout = findViewById(R.id.linearlayout2);
         a=getIntent().getIntExtra("a",0);
         b=getIntent().getIntExtra("b",0);
         c=getIntent().getIntExtra("c",0);

        vatap=(a*100)/11+1;
        pittap=(b*100)/11;
        kaphap=(c*100)/11;


        TextView textView1 = (TextView) findViewById(R.id.textView8);
        TextView textView2 = (TextView) findViewById(R.id.textView9);
        TextView textView3 = (TextView) findViewById(R.id.textView10);

        textView1.setText(" "+vatap +"%");
        textView2.setText(" "+kaphap +"%");
        textView3.setText(" "+pittap +"%");



        drawpie();

    }

    private void drawpie()
    {

        AnimatedPieView mAnimatedPieView = findViewById(R.id.AnimatedPieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo(a, Color.parseColor("#6ee1f5"), "VATA" + " "+vatap))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(b, Color.parseColor("#ffa647"), "PITTA"+ " "+pittap))
                .addData(new SimplePieInfo(c, Color.parseColor("#4c788a"), "KAPHA"+ " "+kaphap)).drawText(true) .strokeMode(false)

                .duration(2000).textSize(35);// draw pie animation duration

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }
    public void Goto_Dosha(View view) {
        Intent intent = new Intent(this, Fetch_Res.class);
        String txt = ((TextView) view).getText().toString();
        intent.putExtra("DOSHA", txt);
        startActivity(intent);
    }


}