package com.it114.android.oneframework.core.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class BaseActivity extends Activity {

    public static enum ACTIVITY_STATE  {
        IDLE, //Œ¥ π”√
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY,
        NOT_ACTIVITY,//∑«activity
    }

    protected ACTIVITY_STATE activityState = ACTIVITY_STATE.IDLE;

    public ACTIVITY_STATE getActivityState(){
        return activityState;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        activityState = ACTIVITY_STATE.CREATE;
    }

    protected int getLayoutId() {
        return -1;
    }

    @Override
    public void onStart() {
        super.onStart();
        activityState = ACTIVITY_STATE.START;
    }

    @Override
    public void onStop() {
        super.onStop();
        activityState = ACTIVITY_STATE.STOP;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        activityState = ACTIVITY_STATE.START;
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityState = ACTIVITY_STATE.RESUME;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityState = ACTIVITY_STATE.PAUSE;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityState = ACTIVITY_STATE.DESTROY;
    }
}
