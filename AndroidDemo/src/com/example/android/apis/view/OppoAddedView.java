
package com.example.android.apis.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.android.apis.R;

public class OppoAddedView extends ImageView {
    private boolean isChecked = false;
    private Paint paint = null;
    private Drawable mCheckedDrawable = null;
    public OppoAddedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(); 
    }

    private void init() {
        mCheckedDrawable = getResources().getDrawable(R.drawable.check_alt);
        paint = new Paint();
    }

    public OppoAddedView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OppoAddedView(Context context) {
        this(context, null);
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(null == mCheckedDrawable) init();
        int witdh  = mCheckedDrawable.getIntrinsicWidth();
        int height = mCheckedDrawable.getIntrinsicHeight();
        int heightDimen = (int) (getDrawable().getIntrinsicHeight()+height/2.0+0.5);
        int widthDimen = (int) (getDrawable().getIntrinsicWidth() + witdh/2.0+0.5);
        setMeasuredDimension(widthDimen,heightDimen);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(drawableToBitmap(getDrawable()), 0, 0, paint);
        if (isChecked) {
            Drawable drawableSrc = getDrawable();
            float topX = (float) (getPaddingLeft() / 1.0 + drawableSrc.getIntrinsicWidth() / 1.0 - (mCheckedDrawable
                    .getIntrinsicWidth() / 2.0));
            float topY = (float) (getPaddingTop() / 1.0 + drawableSrc.getIntrinsicHeight() / 1.0 - mCheckedDrawable
                    .getIntrinsicHeight() / 2.0);
            canvas.drawBitmap(drawableToBitmap(mCheckedDrawable), topX, topY, paint);
        }
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, 600, 600);
    }
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }
    
    public boolean isChecked(){
        return isChecked;
    }
}
