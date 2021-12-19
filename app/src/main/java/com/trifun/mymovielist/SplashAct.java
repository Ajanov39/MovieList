package com.trifun.mymovielist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashAct extends AppCompatActivity {

    private static int SPLASH_TIMEOUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_act);

        Animation zatemnuvanje = new AlphaAnimation(0,1) ;
        zatemnuvanje.setInterpolator(new AccelerateInterpolator());
        zatemnuvanje.setStartOffset(600);
        zatemnuvanje.setDuration(1700);
        ImageView logo = findViewById(R.id.movieLogo);
        logo.setAnimation(zatemnuvanje);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent tomain = new Intent(SplashAct.this,MainActivity.class);
                startActivity(tomain);
                finish();
            }
        },SPLASH_TIMEOUT);


    }


}
