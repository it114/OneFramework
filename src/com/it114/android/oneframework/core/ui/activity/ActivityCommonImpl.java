package com.it114.android.oneframework.core.ui.activity;

import android.os.Bundle;

/**
 *
 */
public class ActivityCommonImpl implements ActivityCommon {
    ACTIVITY_STATE activityState = ACTIVITY_STATE.IDLE;

    @Override
    public ACTIVITY_STATE getActivityState() {
        return activityState;
    }
    @Override
    public void create(Bundle savedInstanceState) {
        activityState = ACTIVITY_STATE.CREATE;
    }
    @Override
    public void start() {
        activityState = ACTIVITY_STATE.START;
    }
    @Override
    public void stop() {
        activityState = ACTIVITY_STATE.STOP;
    }
    @Override
    public void restart() {
        activityState = ACTIVITY_STATE.START;
    }
    @Override
    public void resume() {
        activityState = ACTIVITY_STATE.RESUME;
    }
    @Override
    public void pause() {
        activityState = ACTIVITY_STATE.PAUSE;
    }
    @Override
    public void destroy() {
        activityState = ACTIVITY_STATE.DESTROY;
    }

}
