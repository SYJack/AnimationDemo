package com.jack.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.translation)
    ImageView translation;
    @InjectView(R.id.rotate)
    ImageView rotate;
    @InjectView(R.id.scale)
    ImageView scale;
    @InjectView(R.id.alpha)
    ImageView alpha;
    @InjectView(R.id.fire)
    AppCompatButton fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animationTranslation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);
                Animation animationAlpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                Animation animationRotate=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                translation.startAnimation(animationTranslation);
                alpha.startAnimation(animationAlpha);
                rotate.startAnimation(animationRotate);
            }
        });
    }
}
