package com.example.dz1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SlashActivity extends AppCompatActivity {
private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        ImageView mAnimAndroid = (ImageView) findViewById(R.id.imViewLogo);
        Drawable drawable = mAnimAndroid.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable) drawable).start();

            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //SlashActivity.this.finish();
                    startActivity(new Intent(SlashActivity.this,MenuActivity.class));
                    SlashActivity.this.finish();
                }
            },8000);
        }



    }




}

