package com.example.android.apis.view.ray.eventbus.event;

public class NewMessageEvent {
    public String getMsg() {
        return msg;
    }

    public NewMessageEvent(String msg) {
        this.msg = msg;
    }

    String msg;
}
