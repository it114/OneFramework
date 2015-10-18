package com.it114.android.oneframework.core.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarListener;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarViewImpl;
import com.it114.android.oneframework.core.util.LogUtil;
import com.it114.android.oneframework.core.util.ViewFinder;

public abstract class BaseActivity extends Activity{
    protected final static String TAG = BaseFragmentActivity.class.getName();
    public ActivityCommon activityState = new ActivityCommonImpl();
    protected ViewFinder mViewFinder;
    protected View titleBar;
    protected TitleBarViewImpl titleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        activityState.create(savedInstanceState);
        init(savedInstanceState);
    }

    public void initTitleBar(int titleBarLayoutId,TitleBarListener listener){
        if(titleBarLayoutId>0){
             if(this.titleBar == null)
                 this.titleBar = findViewByIdWithFinder(titleBarLayoutId);
            this.titleBarView = new TitleBarViewImpl(this,titleBar);
            if(listener!=null){
                this.titleBarView.setTitleBarListener(listener);
            }
        } else {
            LogUtil.w(TAG, "invalid titleBarLayoutId");
        }
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mViewFinder = new ViewFinder(getWindow().getDecorView());
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mViewFinder = new ViewFinder(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        mViewFinder = new ViewFinder(view);
    }

    public <T extends View> T findViewByIdWithFinder(int id) {
        return mViewFinder.findViewById(id);
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutId();

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
