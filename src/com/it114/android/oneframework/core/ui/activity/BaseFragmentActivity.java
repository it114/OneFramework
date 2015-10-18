package com.it114.android.oneframework.core.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.it114.android.oneframework.core.ui.fragment.SupportFragment;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarListener;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarViewImpl;
import com.it114.android.oneframework.core.util.LogUtil;
import com.it114.android.oneframework.core.util.ViewFinder;

/**
 * Created by andy on 10/15/2015.
 */
public abstract class BaseFragmentActivity extends FragmentActivity  {
    protected final static String TAG = BaseFragmentActivity.class.getName();
    public ActivityCommon activityState = new ActivityCommonImpl();
    protected FragmentManager mFragmentManager = null;
    protected SupportFragment currentSupportFragment;
    protected ViewFinder mViewFinder;
    protected View titleBar;
    protected TitleBarViewImpl titleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
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

    public void showFragmentInContainer(int container, SupportFragment targetFragment) {
        if (currentSupportFragment != targetFragment) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (currentSupportFragment != null) {
                transaction.hide(currentSupportFragment);
            }
            // 显示传递进来的Fragment
            if (mFragmentManager.findFragmentByTag(targetFragment.getClass().getName()) == null) {
                transaction.add(container, targetFragment, targetFragment.getClass().getName());
            } else {
                transaction.show(targetFragment);
            }
            transaction.commitAllowingStateLoss();
            currentSupportFragment = targetFragment;
        }
    }

    protected abstract void init(Bundle savedInstanceState);

    /*
     * [ 不要删除该函数 ],该函数的空实现修复了FragmentActivity中的bug
     *
     * 来自umeng开源项目
     *
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }

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
