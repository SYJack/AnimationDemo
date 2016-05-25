package com.jack.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TweenActivity extends AppCompatActivity {

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
    @InjectView(R.id.code)
    Button code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animationTranslation = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.translate);
                Animation animationAlpha = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.alpha);
                Animation animationRotate = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.rotate);
                Animation animationScale = AnimationUtils.loadAnimation(TweenActivity.this, R.anim.scale);
                translation.startAnimation(animationTranslation);
                alpha.startAnimation(animationAlpha);
                rotate.startAnimation(animationRotate);
                scale.startAnimation(animationScale);
            }
        });
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AnimationSet animationSet=new AnimationSet(true);
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 0.0f,
                        Animation.RELATIVE_TO_PARENT, 1.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f);
//                translateAnimation1.setInterpolator(new LinearInterpolator());

//                TranslateAnimation translateAnimation2 = new TranslateAnimation(
//                        Animation.RELATIVE_TO_PARENT, 0.0f,
//                        Animation.RELATIVE_TO_PARENT, 0.0f,
//                        Animation.RELATIVE_TO_PARENT, 0.0f,
//                        Animation.RELATIVE_TO_PARENT, 1.0f);
//                translateAnimation2.setInterpolator(new AccelerateInterpolator());

                translateAnimation.setDuration(1000);
                translateAnimation.setInterpolator(new BounceInterpolator());
                translation.startAnimation(translateAnimation);

                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                alpha.startAnimation(alphaAnimation);

                ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.5f,1.0f,1.5f,
                        Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(1000);
                scale.startAnimation(scaleAnimation);

                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                rotate.startAnimation(rotateAnimation);

//                animationSet.setDuration(1000);
//                animationSet.addAnimation(translateAnimation);
////                animationSet.addAnimation(translateAnimation2);
//                animationSet.addAnimation(alphaAnimation);
//                animationSet.addAnimation(scaleAnimation);
//                animationSet.addAnimation(rotateAnimation);
//                translation.startAnimation(animationSet);
            }
        });
    }
}
