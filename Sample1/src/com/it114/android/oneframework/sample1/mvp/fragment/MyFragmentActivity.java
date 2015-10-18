package com.it114.android.oneframework.sample1.mvp.fragment;

import android.os.Bundle;
import com.it114.android.oneframework.core.ui.activity.BaseFragmentActivity;
import com.it114.android.oneframework.sample1.R;

/**
 * Created by andy on 10/18/2015.
 */
public class MyFragmentActivity extends BaseFragmentActivity {

    MyFragment myFragment;


    @Override
    protected void init(Bundle savedInstanceState) {
        if(myFragment == null ){
            myFragment = new MyFragment();
        }
        showFragmentInContainer(R.id.fragment_container,myFragment);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_activity_layout;
    }
}
