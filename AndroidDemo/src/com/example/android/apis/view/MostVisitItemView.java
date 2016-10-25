package com.example.android.apis.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MostVisitItemView extends TextView {
    private final String TAG = MostVisitItemView.class.getSimpleName();
    private final int DIVIDE_WIDTH = 5;
    private boolean DEBUG = true;

    /**
     * 如果是在左边,绘制右和下.如果是在右边,则绘制下边
     */
    private boolean mIsLeft = false;
    private boolean mIsMostVisisted = false;

    /*绘制细线的画笔*/
    private Paint mPaint = null;
    public MostVisitItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MostVisitItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MostVisitItemView(Context context) {
        super(context);
        init();
    }
    
    private void init() {
        mPaint = new Paint();
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(DIVIDE_WIDTH);
        mPaint.setStyle(Style.STROKE);
    }

    public void setIsLeft(boolean isLeft){
        this.mIsLeft = isLeft;
        this.mIsMostVisisted = true;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mIsMostVisisted) {
            int measuredHeight = getMeasuredHeight();
            int measureWidth = getMeasuredWidth();
            if (mIsLeft) {
                canvas.drawLine(measureWidth, 0, measureWidth, measuredHeight, mPaint);
                canvas.drawLine(0, measuredHeight, measureWidth, measuredHeight, mPaint);
            } else {//绘制底部下划线
                canvas.drawLine(0, measuredHeight, measureWidth, measuredHeight, mPaint);
            } 
        }
    }
}
