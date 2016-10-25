package com.example.android.apis.view.ray.rxjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.apis.R;
import com.example.android.apis.view.ray.rxjava.entity.Subject;
import com.example.android.apis.view.ray.rxjava.http.HttpMethods;
import com.example.android.apis.view.ray.rxjava.subscribers.ProgressSubscriber;
import com.example.android.apis.view.ray.rxjava.subscribers.SubscriberOnNextListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxJavaActivity extends Activity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity_main);
        ButterKnife.bind(this);

        getTopMovieOnNext = new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subjects) {
                resultTV.setText(subjects.toString());
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie() {
        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(getTopMovieOnNext, RxJavaActivity.this), 0, 10);
    }
}
