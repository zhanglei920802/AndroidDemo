
package com.example.android.apis.deivces;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import com.example.android.apis.R;

public class DevicesInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_info);
        ((TextView) findViewById(R.id.px2dip))
                .setText("1px=[" + Utils.px2dip(this, 1.0f) + "] dip");
        ((TextView) findViewById(R.id.dip2px))
                .setText("1dip=[" + Utils.dip2px(this, 1.0f) + "] px");
        ((TextView) findViewById(R.id.px2sp)).setText("1px=[" + Utils.px2sp(this, 1.0f) + "] sp");
        ((TextView) findViewById(R.id.sp2px)).setText("1sp=[" + Utils.sp2px(this, 1.0f) + "] px");
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        registerReceiver(new PhoneReceiver(), filter);
    }

    public  class PhoneReceiver extends BroadcastReceiver {
        public PhoneReceiver() {

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            System.out.println("action" + intent.getAction());
            if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
                // 如果是去电（拨出）
                System.out.println("拨出");
            } else {
                // 查了下android文档，貌似没有专门用于接收来电的action,所以，非去电即来电
                System.out.println("来电");
                TelephonyManager tm = (TelephonyManager) context
                        .getSystemService(Service.TELEPHONY_SERVICE);
                tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
                // 设置一个监听器
            }
        }

        PhoneStateListener listener = new PhoneStateListener() {

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                // TODO Auto-generated method stub
                // state 当前状态 incomingNumber,貌似没有去电的API
                super.onCallStateChanged(state, incomingNumber);
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE:
                        System.out.println("挂断");
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        System.out.println("接听");
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        System.out.println("响铃:来电号码" + incomingNumber);
                        // 输出来电号码
                        break;
                }
            }

        };
    }
}
