package com.it114.android.oneframework.core.ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;

import java.util.Properties;

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

    protected BaseActivity.ACTIVITY_STATE getActivityState() {
        if (mContext instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) mContext;
            return activity.getActivityState();
        }
        return BaseActivity.ACTIVITY_STATE.NOT_ACTIVITY;
    }


}
