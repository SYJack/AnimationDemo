package com.jack.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/23.
 */
public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        ButterKnife.inject(this);
    }

    public void tween(View view){
        startActivity(new Intent(AnimationActivity.this,TweenActivity.class));
    }

    public void property(View view){
        startActivity(new Intent(AnimationActivity.this,PropertyActivity.class));
    }
}
