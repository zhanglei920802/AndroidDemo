package com.example.android.apis.view.ray;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.example.android.apis.R;

public class AnimationTestActivity extends Activity {
    private View mView1 = null;
    private View mView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);

        mView1 = findViewById(R.id.view1);
        mView2 = findViewById(R.id.view2);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });


    }

    private LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    private final int HEIGHT = 54 * 3;

    private void doAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1f);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(mLinearInterpolator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float aFloat = (Float) animation.getAnimatedValue();
                //view1
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mView1.getLayoutParams();
                layoutParams.height = (int) (HEIGHT * (1 - aFloat));
                mView1.setLayoutParams(layoutParams);

                //view2
                layoutParams = (LinearLayout.LayoutParams) mView2.getLayoutParams();
                layoutParams.height = (int) (HEIGHT * (aFloat));
                mView2.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        valueAnimator.start();
    }

}
