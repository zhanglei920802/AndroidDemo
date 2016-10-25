package com.example.android.apis.view.dispatch;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import com.example.android.apis.R;
public class DispatchEventActivity extends Activity {
	private final static String tag = "yan";
	TestButton testBtn;
	TestLinearLayout testLinelayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dispatch);
		testBtn = (TestButton)findViewById(R.id.btn_test);
	testBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "testBtn---onClick...");
			}
		});
		testBtn.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					Log.i(tag, "testBtn-onTouch-ACTION_DOWN...");
					break;
				case MotionEvent.ACTION_UP:
					Log.i(tag, "testBtn-onTouch-ACTION_UP...");
					break;
				default:break;

				}
				return false;
			}
		});
		
	testLinelayout = (TestLinearLayout)findViewById(R.id.linearlayout_test);
		testLinelayout.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					Log.i(tag, "testLinelayout-onTouch-ACTION_DOWN...");
					break;
				case MotionEvent.ACTION_UP:
					Log.i(tag, "testLinelayout-onTouch-ACTION_UP...");
					break;
				default:break;

				}
				return false;
			}
		});
		
		testLinelayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "testLinelayout---onClick...");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:
			Log.i(tag, "RxJavaActivity-dispatchTouchEvent-ACTION_DOWN...");
			break;
		case MotionEvent.ACTION_UP:
			Log.i(tag, "RxJavaActivity-dispatchTouchEvent-ACTION_UP...");
			break;
		default:break;
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			Log.i(tag, "RxJavaActivity-onTouchEvent-ACTION_DOWN...");
			break;
		case MotionEvent.ACTION_UP:
			Log.i(tag, "RxJavaActivity-onTouchEvent-ACTION_UP...");
			break;
		default:break;
		}
		return super.onTouchEvent(event);
	}
	
	

}
