package com.example.android.apis.view.ray.browser;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.util.Log;

import com.example.android.apis.R;

import java.util.ArrayList;

public class BookmarkTestActivity extends Activity {
    private ArrayList<ContentValues> mBookmarksBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_test);

        mBookmarksBackup = new ArrayList<ContentValues>();
        // Disable sync
        // backup the current contents in database
        Cursor cursor = getContentResolver().query(Browser.BOOKMARKS_URI, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String[] colNames = cursor.getColumnNames();
            ContentValues value = new ContentValues();
            for (int i = 0; i < colNames.length; i++) {
                switch (cursor.getType(i)) {
                    case Cursor.FIELD_TYPE_BLOB:
                        value.put(colNames[i], cursor.getBlob(i));
                        break;
                    case Cursor.FIELD_TYPE_FLOAT:
                        value.put(colNames[i], cursor.getFloat(i));
                        break;
                    case Cursor.FIELD_TYPE_INTEGER:
                        if (!"_ID".equalsIgnoreCase(colNames[i])) {
                            value.put(colNames[i], cursor.getLong(i));
                        }
                        break;
                    case Cursor.FIELD_TYPE_STRING:
                        value.put(colNames[i], cursor.getString(i));
                        break;
                }
            }
            mBookmarksBackup.add(value);
        }

        Log.w("ray", "onCreate: " + mBookmarksBackup.toString());
    }
}
