package com.example.android.apis.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OptionWrapperView extends RelativeLayout {
    private TextView mTitle = null;
    private ImageView mIcon  = null;
    public OptionWrapperView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public OptionWrapperView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OptionWrapperView(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        mTitle = (TextView) findViewWithTag(new String("textview"));
        mIcon = (ImageView) findViewWithTag(new String("icon"));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int iconCenterX = (int) ((mIcon.getRight() + mIcon.getLeft() + 0.5) /2);
        int titleCenterX =  (int) ((mTitle.getRight() + mTitle.getLeft() + 0.5) /2);
        int deltaX = Math.abs(iconCenterX - titleCenterX);
       // mTitle.layout(l-deltaX, t, r-deltaX, b);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
