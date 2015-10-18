package com.it114.android.oneframework.core.ui.presenter;

import android.content.Context;
import com.it114.android.oneframework.core.ui.activity.ActivityCommon;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.core.ui.activity.BaseFragmentActivity;

/**
 * Created by andy on 10/15/2015.
 */
public abstract class BaseFragmentPresenter extends Presenter{

    protected Context mContext;
    public void attach(Context context) {
        mContext = context;
        init();
    }

    public void detach() {
        mContext = null;
    }

    protected ActivityCommon.ACTIVITY_STATE getActivityState() {
        if (mContext instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) mContext;
            return activity.activityState.getActivityState();
        } else if(mContext instanceof BaseFragmentActivity ) {
            BaseFragmentActivity activity = (BaseFragmentActivity) mContext;
            return activity.activityState.getActivityState();
        }
        return ActivityCommon.ACTIVITY_STATE.NOT_ACTIVITY;
    }


}
