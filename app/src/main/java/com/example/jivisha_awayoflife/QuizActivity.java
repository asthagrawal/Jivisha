package com.example.jivisha_awayoflife;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List; //

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView ques,qno, timer;
    private Button opt1,opt2,opt3;
    private List<Question> qlist;
    private int quesNum;
    private CountDownTimer countdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        ques=findViewById(R.id.ques);
        qno=findViewById(R.id.qno);
        timer=findViewById(R.id.countdown);

        opt1=findViewById(R.id.opt1);
        opt2=findViewById(R.id.opt2);
        opt3=findViewById(R.id.opt3);


        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);

        getQuestions();


    }

    private void getQuestions()
    {
        qlist=new ArrayList<>();
        qlist.add(new Question("How would you best describe your body type and physical appearance?",
                "Slim, light frame","Balanced weight, muscular","Well-built, larger curvy frame"));
        qlist.add(new Question("Which best describes your personality?",
                "Responsible, nurturing and sensitive","Creative, joyful and introspective","Competitive, perceptive and efficient"));
        qlist.add(new Question("How is your memory?",
                "I learn quickly, but I also forget quickly","I have a great memory!","It takes me a while to learn but once I do I don't forget it"));
        qlist.add(new Question("How would you best describe your metabolism?",
                "Fast metabolism, difficult to gain weight","Balanced metabolism, can gain weight and lose weight easily","Slow metabolism, difficult to lose weight"));
        qlist.add(new Question("Which of these traits do you most identify with?",
                "I can get pretty stubborn","I get jealous easily","I'm often indecisive"));
        qlist.add(new Question("Which best describes your skin?",
                "Oily or soft with freckles or pimples","Thick, oily cool skin","Dry"));
        qlist.add(new Question("How do you usually sleep?"
                ,"My sleep is short, but deep","My sleep is rather inconsistent","My sleep is long and heavy"));
        qlist.add(new Question("Which best describes your hair?","Straight and fine","Thick and lustrous","Dry and curly"));
        qlist.add(new Question("How are your eyes?",
                "Large, pretty","Small","Medium sized, intense gaze"));
        qlist.add(new Question("What kind of weather is your favorite?"
                ,"Warm","Cool","Rainy"));
        qlist.add(new Question("How would you describe your way of faith or spirituality?",
                "My convictions are strong, sometimes even fanatical","My convictions are stable","I'm rather erratic and able to change"));


        setQuestions();


    }

    private void setQuestions()
    {
        timer.setText(String.valueOf(10));
        ques.setText(qlist.get(0).getQues());
        opt1.setText(qlist.get(0).getOpt1());
        opt2.setText(qlist.get(0).getOpt2());
        opt3.setText(qlist.get(0).getOpt3());
        qno.setText(String.valueOf(1)+"/"+String.valueOf(qlist.size()));

        startTimer();

        quesNum=0;
    }

    private void startTimer()
    {
        countdown=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {
                changeQuestion();

            }
        };
        countdown.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        int opt;
        switch(v.getId()){
            case R.id.opt1:   //check button clicked!!!!
                opt=1;
                ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.MAGENTA));
                break;
            case R.id.opt2:
                opt=2;
                ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                break;
            case R.id.opt3:
                opt=3;
                ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                break;
            default:

        }
        countdown.cancel();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        }, 2000);




    }

    private void changeQuestion()
    {
        if(quesNum!=qlist.size())   //Not last question
        {
            quesNum++;

            playAnim(ques,0,0);
            playAnim(opt1,0,1);
            playAnim(opt2,0,2);
            playAnim(opt3,0,3);

            qno.setText(String.valueOf(quesNum+1)+"/"+String.valueOf(qlist.size()));
            timer.setText(String.valueOf(10));
            startTimer();

        }
        else //Last ques
        {
            Intent intent=new Intent(QuizActivity.this,result.class);
            startActivity(intent);
            QuizActivity.this.finish();
        }
    }

    private void playAnim(final View v, final int value, final int vno)
    {
        v.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        if(value==0){
                            switch (vno){
                                case 0: ((TextView)v).setText(qlist.get(quesNum).getQues());
                                break;
                                case 1: ((Button)v).setText(qlist.get(quesNum).getOpt1());
                                break;
                                case 2: ((Button)v).setText(qlist.get(quesNum).getOpt2());
                                break;
                                case 3: ((Button)v).setText(qlist.get(quesNum).getOpt3());
                                break;
                            }

                            if(vno!=0)
                                ((Button)v).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E99c03")));

                            playAnim(v,1,vno);
                        }

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }

}