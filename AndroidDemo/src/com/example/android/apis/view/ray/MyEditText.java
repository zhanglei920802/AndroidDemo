package com.example.android.apis.view.ray;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by 80107442 on 2016-01-05.
 */
public class MyEditText extends EditText {
    private final String TAG = MyEditText.class.getSimpleName();

    public MyEditText(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        Log.d(TAG, "onTextContextMenuItem() called with: " + "id = [" + id + "]");
        return super.onTextContextMenuItem(id);
    }

}
