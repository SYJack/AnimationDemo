package com.jack.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/5/23.
 */
public class PropertyActivity extends AppCompatActivity {
    @InjectView(R.id.imageView1)
    ImageView imageView1;
    @InjectView(R.id.imageView2)
    ImageView imageView2;
    @InjectView(R.id.imageView3)
    ImageView imageView3;
    @InjectView(R.id.imageView4)
    ImageView imageView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.inject(this);
        initEvent();
    }

    private void initEvent() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator alpha=ObjectAnimator.ofFloat(imageView1,"alpha",0.0f,1.0f);
                alpha.setRepeatCount(-1);//设置动画重复次数，这里-1代表无限
                alpha.setRepeatMode(Animation.REVERSE);//设置动画循环模式。
                alpha.setDuration(1000);
                alpha.start();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet=new AnimatorSet();
                ObjectAnimator scalex=ObjectAnimator.ofFloat(imageView2,"scaleX",0.0f,1.0f);
                ObjectAnimator scaley=ObjectAnimator.ofFloat(imageView2,"scaleY",0.0f,1.0f);
                animatorSet.setDuration(1000);
                animatorSet.play(scalex).with(scaley);
                animatorSet.start();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator translate=ObjectAnimator.ofFloat(imageView3,"X",0,imageView3.getX());
                translate.start();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = new AnimatorSet() ;
                ObjectAnimator anim = ObjectAnimator .ofFloat(imageView4, "rotationX", 0f, 360f);
                anim.setDuration(2000);
                ObjectAnimator anim2 = ObjectAnimator .ofFloat(imageView4, "rotationX", 360f, 0f);
                anim2.setDuration(2000);
                ObjectAnimator anim3 = ObjectAnimator .ofFloat(imageView4, "rotationY", 0f, 360f);
                anim3.setDuration(2000);
                ObjectAnimator anim4 = ObjectAnimator .ofFloat(imageView4, "rotationY", 360f, 0f);
                anim4.setDuration(2000);

                set.play(anim).before(anim2); //先执行anim动画之后在执行anim2
                set.play(anim3).before(anim4) ;
                set.start();
//                ObjectAnimator rotate= ObjectAnimator.ofFloat(imageView4,"rotationX",0.0f,360.0f);
//                rotate.setDuration(1000);
//                //设置负值为无限重复
//                rotate.setRepeatCount(-1);
//                rotate.setRepeatMode(ValueAnimator.REVERSE);
//                rotate.start();
            }
        });
    }

}
