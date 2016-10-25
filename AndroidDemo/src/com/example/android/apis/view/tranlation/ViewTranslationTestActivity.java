package com.example.android.apis.view.tranlation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.apis.R;

/**
 * 测试:
 * <p/>
 * 1.测试View的setTranslationY()方法<br/>
 * 2.测试View的offsetLeftAndRight<br/>
 * 测试结果
 * <p/>
 * setTranslationX()和setTranslationY(),offsetLeftAndRight()都能移动view。offsetLeftAndRight不会重新进行measure,layout,draw
 * .但是setTranslationX，和setTranslationY会进行measure,layout,draw
 */
public class ViewTranslationTestActivity extends Activity {
    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView test_img;
    private int mTranLationY = 0;
    private int mOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ray_view_tranlationy);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        test_img = (TestImageView) findViewById(R.id.test_img);
        button3.setText(String.valueOf(mTranLationY));
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTranLationY--;
                test_img.setTranslationY(mTranLationY);
                button3.setText(String.valueOf(mTranLationY));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mTranLationY++;
                test_img.setTranslationY(mTranLationY);
                button3.setText(String.valueOf(mTranLationY));
            }
        });
        Button button4 = findViewByID(this, R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOffset++;
                test_img.offsetLeftAndRight(mOffset);
            }
        });

    }


    public <T extends View> T findView(View view, int id) {
        return (T) view.findViewById(id);
    }

    public <T extends View> T findViewByID(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }
}
