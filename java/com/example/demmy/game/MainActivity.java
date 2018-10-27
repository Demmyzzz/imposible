package com.example.demmy.game;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer life = 100;
    int score = 0;

    public TextView tv;

    private CountDownTimer countDownTimer;
    private long timeLeftMillisecond = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.timer);
        start();
    }

    public void start(){ startTimer(); }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftMillisecond, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftMillisecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }



    public void updateTimer(){
        int min = (int) timeLeftMillisecond / 60000;
        int sec = (int) timeLeftMillisecond % 60000 / 1000;

        String timeLeftText;
        timeLeftText = "" + min;
        timeLeftText += ":";
        if (sec < 10 ) timeLeftText += "0";
        timeLeftText += sec;

        tv.setText(timeLeftText);
    }

    public void click(View view) {

        life--;
        if (life==0){ expl(); }

    }

    private void expl() {

        String scoreText;
        score = score +100;
        scoreText = "" + score;
        TextView tv = findViewById(R.id.Score_num);
        tv.setText(scoreText);

        ImageView iv = findViewById(R.id.img);
//        iv.setImageDrawable(getResources().getDrawable(R.mipmap.bang2));
        iv.setImageResource(R.mipmap.bang2);

    }

}
