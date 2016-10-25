package com.example.android.apis.view.ray.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.apis.R;

import java.util.zip.Inflater;

public class CallBrowserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this,R.layout.activity_call_browser,null);
        view.setFitsSystemWindows(true);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(view);
        findViewById(R.id.btn_call_no_block).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://fashion.qq.com/original/ruliu/r374.html"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_call_dlg_full_url).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://news.qq.com/a/20151111/055901.htm?tu_biz=1.114.1.0"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_call_none_tips).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://view.news.qq.com/original/intouchtoday/n3339.html"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_call_tips_dlg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://fashion.qq.com/original/ruliu/r385.html"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_call_tips_dlg_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://v.qq.com/cover/8/89szz5fgvcsmui4.html?vid=f0018vx5j2w"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ((EditText) findViewById(R.id.edt_url)).getText().toString();
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(CallBrowserActivity.this, "链接为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(Intent.createChooser(intent, "选择浏览器"));
                startActivity(intent);
            }
        });
        ((CheckBox) findViewById(R.id.switch_navigation_bar)).
                setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        showNavigationBar(isChecked);
                    }
                });


    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(0, R.anim.slide_out_down);
    }

    private void showNavigationBar(boolean show) {
        //API14 以下不支持虚拟按键
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }

        //如果没有虚拟按键,那么直接返回
        boolean hasVirtualKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        if (hasVirtualKey) {
            return;
        }

        if (show) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
