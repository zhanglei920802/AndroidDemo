package com.example.android.apis.view.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * <a link="http://blog.csdn.net/yanzi1225627/article/details/22592831">http://blog.csdn.net/yanzi1225627/article/details/22592831</a>
 * <br>
 *
 * @Author<br>leizhang
 * @Since<br>2015年5月25日
 */
public class TestLinearLayout extends LinearLayout {
    private final static String tag = "Ray";

    public TestLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        System.out.println("TestLinearLayout.dispatchTouchEvent()");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestLinearLayout-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestLinearLayout-dispatchTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * For as long as you return false from this function, each following event (up to and including the final up) will be delivered first here and then to the target's onTouchEvent().
     * 这句话的意思是:只要是{@link #onTouchEvent(MotionEvent)} 这个函数返回为false，默认的返回false.接下来的事件都会分发到这里然后传递到目标对象的 {@link #onTouchEvent(MotionEvent)}
     * <BR>
     * 所有相关函数返回为默认值，那么事件传递顺序如下:
     * 对象                                  函数                                                  事件
     * Activity                            dispatchTouchEvent                      ACTION_DOWN
     * ViewGroup                      dispatchTouchEvent                       ACTION_DOWN
     * ViewGroup                      onInterceptTouchEvent                ACTION_DOWN
     * View                                  dispatchTouchEvent                        ACTION_DOWN
     * View                                  onTouchEvent                                   ACTION_DOWN
     * View                                  listener.onTouch                                ACTION_DOWN
     * <p/>
     * Activity                            dispatchTouchEvent                      ACTION_MOVE
     * ViewGroup                      dispatchTouchEvent                       ACTION_MOVE
     * ViewGroup                      onInterceptTouchEvent                ACTION_MOVE
     * View                                  dispatchTouchEvent                        ACTION_MOVE
     * View                                  onTouchEvent                                   ACTION_MOVE
     * View                                  listener.onTouch                                ACTION_MOVE
     * <p/>
     * Activity                            dispatchTouchEvent                      ACTION_UP
     * ViewGroup                      dispatchTouchEvent                       ACTION_UP
     * ViewGroup                      onInterceptTouchEvent                ACTION_UP
     * View                                  dispatchTouchEvent                        ACTION_UP
     * View                                  onTouchEvent                                   ACTION_UP
     * View                                  listener.onTouch                                ACTION_UP
     * View                                  listener.onClick                                 点击事件
     * <BR>
     * If you return true from here, you will not receive any following events: the target view will receive the same event but with the action ACTION_CANCEL, and all further events will be delivered to your onTouchEvent() method and no longer appear here.
     * 修改 {@link #onInterceptTouchEvent(MotionEvent)} 的返回值为true,其他的为默认，那么事件传递顺序如下:
     * 对象                                     函数                                                                事件
     * Activity                            dispatchTouchEvent                      ACTION_DOWN
     * ViewGroup                      dispatchTouchEvent                       ACTION_DOWN
     * ViewGroup                      onInterceptTouchEvent                ACTION_DOWN
     * ViewGroup                      listener.onTouch                              ACTION_DOWN
     * ViewGroup                     onTouchEvent                                   ACTION_DOWN
     * <p/>
     * Activity                            dispatchTouchEvent                      ACTION_MOVE
     * ViewGroup                      dispatchTouchEvent                       ACTION_MOVE
     * ViewGroup                      listener.onTouch                       ACTION_MOVE
     * ViewGroup                     onTouchEvent                                  ACTION_MOVE
     * <p/>
     * Activity                            dispatchTouchEvent                      ACTION_UP
     * ViewGroup                      dispatchTouchEvent                       ACTION_UP
     * ViewGroup                      listener.onTouch                       ACTION_UP
     * ViewGroup                     onTouchEvent                                  ACTION_UP
     * ViewGroup                                  listener.onClick                                 点击事件
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestLinearLayout-onInterceptTouchEvent-ACTION_DOWN...");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "TestLinearLayout-onInterceptTouchEvent-ACTION_MOVE...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestLinearLayout-onInterceptTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
        //return false;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        System.out.println("TestLinearLayout.onTouchEvent()");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestLinearLayout-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(tag, "TestLinearLayout-onTouchEvent-ACTION_MOVE...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestLinearLayout-onTouchEvent-ACTION_UP...");
                break;
            default:
                break;
        }
//		return true;
        return super.onTouchEvent(event);
    }


}
