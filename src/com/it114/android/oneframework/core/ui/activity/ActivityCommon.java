package com.it114.android.oneframework.core.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public interface ActivityCommon {
    enum ACTIVITY_STATE  {
        IDLE, //未使用
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY,
        NOT_ACTIVITY,//非activity
    }

    ACTIVITY_STATE getActivityState();

    void create(Bundle savedInstanceState);

    void start() ;

    void stop();

    void restart() ;

    void resume() ;

    void pause() ;

    void destroy() ;

}
