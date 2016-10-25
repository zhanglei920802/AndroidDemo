
package com.example.android.apis.view;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;

import com.example.android.apis.R;

public class PopupWindowTest extends Activity {
	private PopupWindow mPopupWindow = null;
	private View popView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup_window);
		findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showWindow();
			}
		});
	}

	private void showWindow() {
		if (null == popView) {
			popView = getLayoutInflater().inflate(R.layout.action_selection, null);
		}
		if (null == mPopupWindow) {
			mPopupWindow = new PopupWindow(popView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		}
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
		mPopupWindow.getContentView().measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int[] location = new int[2];
		findViewById(R.id.btn4).getLocationOnScreen(location);
		mPopupWindow.setFocusable(false);
		mPopupWindow.setOutsideTouchable(true);
//		mPopupWindow.update();
		mPopupWindow.showAtLocation(findViewById(R.id.btn4), 0, 0, location[1]);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_MENU:
				showWindow();
				break;

			default:
				break;
		}
		return super.onKeyDown(keyCode, event);
	}
}
