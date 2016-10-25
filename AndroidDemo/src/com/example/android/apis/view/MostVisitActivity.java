package com.example.android.apis.view;

import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;

public class MostVisitActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_item_menu);
        //MostVisitItemView itemView  = (MostVisitItemView) findViewById(R.id.most_tv);
        ///itemView.setIsLeft(false);
    }
}
