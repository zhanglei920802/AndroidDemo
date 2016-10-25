package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;

import com.example.android.apis.R;

/**
 * 测试EditText 的drawablebottom属性，通过图片可以显示出来，通过自定义drawable好像不行 <br>
 * @Author<br>
 * 			ZhangLei
 * @Since<br>
 * 			2015年8月31日
 */
public class EditTextDrawableBottomTestActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ray_edittext_drawable_bottom_test);
	}
}
