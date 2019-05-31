package com.example.stopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class watchAct extends AppCompatActivity {
    Button btnStart,btnStop;
    ImageView icanchor;
    Animation roundinglone,stoprounding;
    Chronometer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        icanchor = findViewById(R.id.icanchor);
        timer = findViewById(R.id.timer);

        //create optional animation
        btnStop.setAlpha(0);

        //load animation
        roundinglone = AnimationUtils.loadAnimation(this,R.anim.roundinglone);
        stoprounding = AnimationUtils.loadAnimation(this,R.anim.stoprounding);

        // Fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //customize Fonts
        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MMedium);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(roundinglone);
                btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();
                //start timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(stoprounding);
                btnStart.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnStop.animate().alpha(0).setDuration(300).start();

                //stop timer
                timer.stop();
            }
        });

    }
}
