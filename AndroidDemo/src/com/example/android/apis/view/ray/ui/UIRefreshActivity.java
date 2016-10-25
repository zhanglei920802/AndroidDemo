package com.example.android.apis.view.ray.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.android.apis.R;

/**
 * 用于测试Activity的刷新层次
 * <br/>
 *             ViewRoot
 *          DecorView
 *   ActionBar          ContentView
 *                LinearLayout  LinearLayout
 *                              LinearLayout
 *                      Button Button Button Button
 *
 */
public class UIRefreshActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uirefresh);

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:0800000123");
                Intent it = new Intent(Intent.ACTION_VIEW);
                it.putExtra("disable_url_override", true);
                it.setData(uri);
                startActivity(it);
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = getPackageManager().getLaunchIntentForPackage("com.android.browser");
                startActivity(browser);
            }
        });
    }
}
