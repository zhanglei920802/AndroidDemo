package com.example.android.apis.view.ray;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.apis.R;

public class HistoryInsert extends Activity {
    public static final String AUTHORITY = "com.android.browser";

    /** A content:// style uri to the authority for the browser provider */
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "history");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_insert);

        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((TextView) findViewById(R.id.editText)).getText().toString();
                int count = Integer.parseInt(text);
                String title = "1、不同的人对间隔年有不同的看法（，opinion）翻译成英语，";
                String url =
                        "http://zhidao.baidu.com/question/498195331687451004" +
                                ".html?device=mobile&ssid=0&from=1014243b&uid=0&pu=usm@0,sz@1320_1001,ta@iphone_2_4.4_3_537&bd_page_type=1&baiduid=48D3EE9D43DA88DDD1D6C8765989B365&tj=www_zhidao_normal_1_0_10_title";
                ContentValues ContentValues;
                int begin_id = 2000;
                for (int i = 0; i < count; i++) {
                    ContentValues = new ContentValues();
                    begin_id++;
                    title = title + i;
                    url = url + i;
                    ContentValues.put("_id", begin_id);
                    ContentValues.put("title", title);
                    ContentValues.put("url", url);
                    ContentValues.put("created", 0);
                    ContentValues.put("date", System.currentTimeMillis());
                    ContentValues.put("visits", 1);
                    ContentValues.put("user_entered", 0);

                    getContentResolver().insert(CONTENT_URI, ContentValues);
                }
            }
        });

    }
}
