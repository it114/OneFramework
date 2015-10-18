package com.it114.android.oneframework.core.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;

public abstract class BaseActivity extends Activity{

    public ActivityCommon activityState = new ActivityStateImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        activityState.create(savedInstanceState);
        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);

    protected int getLayoutId() {
        return -1;
    }

    @Override
    public void onStart() {
        super.onStart();
        activityState.start();

    }

    @Override
    public void onStop() {
        super.onStop();
        activityState.stop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        activityState.restart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        activityState.resume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityState.pause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityState.destroy();
    }




}
