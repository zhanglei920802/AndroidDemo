
package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.android.apis.R;

public class MyImageViewTest extends Activity {
private com.example.android.apis.view.OppoAddedView img = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oppo_imagevie_test);
        img = (OppoAddedView) findViewById(R.id.imageView1);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                img.setChecked(!img.isChecked());
            }
        });
    }
    
}
