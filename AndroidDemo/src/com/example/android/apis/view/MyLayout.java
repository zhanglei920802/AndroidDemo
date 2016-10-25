package com.example.android.apis.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.android.apis.R;

public class MyLayout extends FrameLayout {
    private ImageView icon= null;
    private ImageView close= null;
    public MyLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout(Context context) {
        this(context,null);
    }

    @Override
    protected void onFinishInflate() {
        icon = (ImageView) findViewById(R.id.icon);
        close = (ImageView)findViewById(R.id.closeButton);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // TODO Auto-generated method stub
        final int closeW = close.getMeasuredWidth();
        final int closeH = close.getMeasuredHeight();
        final int closeViewRight = close.getWidth();
        final int closeViewLeft = closeViewRight - closeW;
        final int closeViewTop = 0;
        final int closeViewBottom = closeViewTop + closeH;
        close.layout(closeViewLeft, closeViewTop, closeViewRight, closeViewBottom);
        
        final int iconViewRight = closeViewRight - closeW/2;
        final int iconViewLeft = closeW/2;
        final int iconViewTop = closeH/2;
        final int iconViewBottom = icon.getHeight();
        icon.layout(iconViewLeft, iconViewTop, iconViewRight, iconViewBottom);
//        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable closeViewDrawable = icon.getDrawable();
        final int closeW = closeViewDrawable.getIntrinsicWidth();
        final int closeH = closeViewDrawable.getIntrinsicHeight();
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams)icon.getLayoutParams();
        lp.rightMargin = closeW / 2;
        lp.topMargin = closeH / 2;
        lp.leftMargin = closeW / 2;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

