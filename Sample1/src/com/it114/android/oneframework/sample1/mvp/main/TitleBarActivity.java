package com.it114.android.oneframework.sample1.mvp.main;

import android.os.Bundle;
import android.view.View;
import butterknife.Bind;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarListener;
import com.it114.android.oneframework.core.ui.widget.titlebar.TitleBarViewImpl;
import com.it114.android.oneframework.sample1.R;

/**
 * Created by andy on 10/18/2015.
 */
public class TitleBarActivity extends BaseActivity implements TitleBarListener {

    @Bind(R.id.layout_title_bar)
    View titleBar;

    private TitleBarViewImpl titleBarView;
    @Override
    protected void init(Bundle savedInstanceState) {
        titleBarView = new TitleBarViewImpl(this,titleBar);
        titleBarView.setTitleBarListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.titlebar_activity_layout;
    }


    @Override
    public void onRightImgBtnClick(View view) {

    }

    @Override
    public void onRightTextBtnClick(View view) {

    }
}
