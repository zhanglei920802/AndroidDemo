package com.example.android.apis.view.ray.browser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.apis.R;

public class PushActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createIntent("http://baidu.com/", "http://news.163.com/", "32323232"));
            }
        });
    }

    public Intent createIntent(String url, String backUrl, String pushId) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setPackage("com.android.browser");
        intent.putExtra("backUrl", backUrl);
        intent.putExtra("pushID", pushId);
        return intent;
    }

}
