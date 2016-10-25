package com.example.android.apis.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class TestButton extends Button {
    private final static String tag = "Ray";

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestButton-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "TestButton-onTouchEvent-ACTION_MOVE...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestButton-onTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestButton-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "TestButton-dispatchTouchEvent-ACTION_MOVE...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestButton-dispatchTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

}
