package com.example.android.apis.view.ray.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.example.android.apis.R;
import com.example.android.apis.view.ray.eventbus.event.NewMessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_first);

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ttt(NewMessageEvent event) {
        Toast.makeText(this, "ttt" + event.getMsg(), Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ddd(final NewMessageEvent event) {
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(FirstActivity.this, "ddd" + event.getMsg(), Toast.LENGTH_LONG).show();
            }
        }, 3000);
    }

}
