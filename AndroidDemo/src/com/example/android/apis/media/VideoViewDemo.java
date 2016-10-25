/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.apis.media;

import com.example.android.apis.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoViewDemo extends Activity {

    /**
     * TODO: Set the path variable to a streaming video URL or a local media
     * file path.
     */
    private String path = "";
    private VideoView mVideoView;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setFullScreen(true);
        setContentView(R.layout.videoview);
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/device-2015-11-19-184950.mp4";
        if (path == "") {
            // Tell the user to provide a media file URL/path.
            Toast.makeText(
                    VideoViewDemo.this,
                    "Please edit VideoViewDemo Activity, and set path"
                            + " variable to your media file URL/path",
                    Toast.LENGTH_LONG).show();

        } else {

            /*
             * Alternatively,for streaming media you can use
             * mVideoView.setVideoURI(Uri.parse(URLstring));
             */
            mVideoView.setVideoPath(path);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.requestFocus();

        }
    }

    private void setFullScreen(final boolean fullscreen) {
        // Hide/show the system bar
        Window window = getWindow();
        window.setFlags(fullscreen ?
                WindowManager.LayoutParams.FLAG_FULLSCREEN : 0,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (fullscreen) {
            // Keep the system bar hidden in full screen mode
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) != 0) {
                        getWindow().setFlags(
                                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    } else {
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | 0x4);
                    }
                }
            });
        }
        else {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        }
        window.getDecorView().setSystemUiVisibility(
                fullscreen ? (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | 0x4) : 0);
    }
}
