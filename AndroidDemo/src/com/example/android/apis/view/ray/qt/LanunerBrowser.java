package com.example.android.apis.view.ray.qt;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.android.apis.R;

public class LanunerBrowser extends Activity {
    private static final int SLEEP_TIME  = 8000;
    private static final int MSG_RUN  = 1;
    private Handler mHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_RUN: {
                    startBrowser();
                    break;
                }
                default: {
                    super.handleMessage(msg);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuner_browser);
    }

    public void startActicity(View v) {
        startBrowser();
    }

    private void startBrowser() {
        Log.e("ray", "start browser");
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra("FROM_TEST", false);
        intent.setPackage("com.android.browser");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        mHander.sendEmptyMessageDelayed(MSG_RUN, SLEEP_TIME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHander.removeMessages(MSG_RUN);
    }
}
