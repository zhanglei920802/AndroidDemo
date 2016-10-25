package com.example.android.apis.view.ray.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.android.apis.R;
import com.example.android.apis.view.ray.eventbus.event.NewMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new NewMessageEvent("你有5条新消息"));
            }
        });
    }
}
