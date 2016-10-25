package com.example.android.apis.deivces;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.android.apis.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.MemoryHandler;

public class IMETest extends Activity {
	EditText editText1 = null;
	private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ime_test);
		editText1 = (EditText) findViewById(R.id.editText1);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				testCollection();
				 editText1.setText(isKeyboardLoaded_Android(null) + "");
			}
		});
	}

	public boolean isKeyboardLoaded_Android(String deviceName) {
		String output = "";
		String[] cmd;
		try {
			cmd = new String[] {"dumpsys window InputMethod | grep \"mHasSurface\"" };
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line + "-");
			}
			output =  stringBuffer.toString();
			System.out.println("BaseUi.isKeyboardLoaded_Android():" + output);
		} catch (Exception e) {
			System.out.println("BaseUi.isKeyboardLoaded_Android() exception"+e.getMessage());
			e.printStackTrace();
		}
		return output.contains("isReadyForDisplay()=true");
	}

	private void testCollection() {
		final ArrayList<String> data = new ArrayList<String>();
		data.add("ddd");
		data.add("ddde");
		data.add("ddwed");
		data.add("dwerdd");
		data.add("dewrwerdd");
		for (String string : data) {
			System.out.println(string);
		}
		System.out.println("=========");
		for (final String string : data) {
			if ("ddde".equals(string)) {
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						data.remove(string);
					}
				});
			}
		}
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				for (String string : data) {
					System.out.println(string);
				}
			}
		});

	}
}
