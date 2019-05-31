package com.example.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash,tvSupSplash;
    Button btnget;
    ImageView ivSplash;
    Animation atg,btgone,btgtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tv_splash);
        tvSupSplash = findViewById(R.id.tv_supSplash);
        btnget = findViewById(R.id.btn_get);
        ivSplash = findViewById(R.id.ivSplash);

        //load animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this,R.anim.btntwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSupSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        // Fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        //customize Fonts
        tvSplash.setTypeface(MRegular);
        tvSupSplash.setTypeface(MLight);
        btnget.setTypeface(MMedium);

        //passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,watchAct.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
}
