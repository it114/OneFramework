package com.it114.android.oneframework.core.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.it114.android.oneframework.core.ui.presenter.BaseFragmentPresenter;



/**
 * Created by andy on 10/15/2015.
 */
public class SupportFragment extends Fragment {

    protected LayoutInflater mLayoutInflater;
    protected View mRootView;
    protected BaseFragmentPresenter mPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        mRootView = mLayoutInflater.inflate(getFragmentLayout(), container, false);
        createPresenters();
        initWidgets(mRootView);
        initOther();
        if (mPresenter != null) {
            mPresenter.attach(getActivity());
        }
        return mRootView;
    }

    /**
     * 其他业务初始化
     */
    protected void initOther() {

    }

    protected int getFragmentLayout() {
        return 0;
    }

    protected void initWidgets(View mRootView) {
        ButterKnife.bind(this, mRootView);
    }

    protected void createPresenters() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDetach();
    }



}
