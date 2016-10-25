package com.example.android.apis.view.ray;

import java.io.IOException;
import java.io.InputStreamReader;

public class Debug {
    public static void executeCmd(){
        try {
            Process process = new ProcessBuilder("/system/bin/logcat",
                    "-v", "time", "-b", "events", "-b", "system", "-b", "main",
                    "-b", "crash",
                    "-t").redirectErrorStream(true).start();

            InputStreamReader input = new InputStreamReader(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
