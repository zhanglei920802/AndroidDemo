package com.example.android.apis.view.tranlation;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by 80107442 on 2016-06-22.
 */
public class TestImageView extends ImageView {
    public TestImageView(Context context) {
        this(context, null);
    }

    public TestImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
