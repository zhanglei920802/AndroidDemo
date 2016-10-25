package com.example.android.apis.view.ray.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.apis.R;
import com.example.android.apis.view.Cheeses;


public class ListViewTestActivity extends Activity {
    private String[] mStrings = Cheeses.sCheeseStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);

        MyListView listView = (MyListView) findViewById(R.id.list1);
        listView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mStrings.length;
        }

        @Override
        public String getItem(int position) {
            return mStrings[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView =
                        LayoutInflater.from(ListViewTestActivity.this).inflate(R.layout.list_iten_textview,
                                null);
            }

            ItemView textView = (ItemView) convertView.findViewById(android.R.id.text1);
            textView.setText(getItem(position));
            return convertView;
        }
    }
}
