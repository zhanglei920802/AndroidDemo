package com.example.android.apis.view.ray.roateview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * <br>
 * @Author<br>
 *             ZhangLei
 * @Since<br>
 *            2015年9月2日
 */
public class CustomeRotateView extends View {
    private Paint p1, p2,p3;

    public CustomeRotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 
     */
    private void init() {
        p1 = new Paint();
        p1.setColor(Color.RED);
        p2 = new Paint();
        p2.setColor(Color.BLUE);
        p3 = new Paint();
        p3.setColor(Color.GREEN);
    }

    public CustomeRotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomeRotateView(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 前期定义 Canvas canvas
        canvas.drawRect(100, 100, 150, 150, p1); // p1 是红色画笔
        int saveCount = canvas.save();
        canvas.rotate(30);
        canvas.drawRect(200, 200, 250, 250, p2); // p2 是蓝色画笔
        //旋转后再恢复到制定位置
        //canvas.restoreToCount(saveCount);
        canvas.drawRect(300, 300, 350, 350, p3); // p2 是绿色画笔
    }
}
