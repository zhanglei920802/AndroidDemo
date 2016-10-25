package com.example.android.apis.view.ray;

import android.app.Activity;
import android.os.Bundle;

import com.example.android.apis.R;

/**
 * 测试自定义view的canvas旋转 <br>
 * @Author<br>
 *             ZhangLei
 * @Since<br>
 *            2015年9月2日
 */
public class CustomViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ray_customview_roate);
    }
}
