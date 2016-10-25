package com.example.android.apis.ray.graphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/**
 * 贝塞尔曲线测试
 * 
 * @author 80107442
 *
 */
public class BezierLineTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BezierView bezierView = new BezierView(this);
		ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		bezierView.setLayoutParams(layoutParams);
		setContentView(bezierView);
	}

	/**
	 * 贝塞尔曲线测试
	 * 
	 * @author 80107442
	 *
	 */
	public class BezierView extends View {

		private Paint mPaint = null;
		private Path mPath = null;

		public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
			super(context, attrs, defStyleAttr);
			init();
		}

		private void init() {
			mPaint = new Paint();
			mPaint.setStyle(Style.STROKE);
			mPaint.setColor(Color.RED);
			mPaint.setAntiAlias(true);
			mPaint.setTextSize(20);

			mPath = new Path();
			mPath.moveTo(0, getHeight() / 2);
			mPath.quadTo(getWidth() / 2, 0, getWidth(), getHeight() / 2);
		}

		public BezierView(Context context, AttributeSet attrs) {
			this(context, attrs, 0);
		}

		public BezierView(Context context) {
			this(context, null);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			//绘制贝塞尔曲线
			mPath.reset();
			mPath.moveTo(0, getHeight() / 2);
			mPath.quadTo(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
			mPath.moveTo(getWidth() / 2, getHeight() / 2);
			mPath.quadTo(getWidth() * 3 / 4, 3 * getHeight() / 4, getWidth(), getHeight() / 2);
			canvas.drawPath(mPath, mPaint);
		}
	}
}
