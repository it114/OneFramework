package com.it114.android.oneframework.sample1.mvp.webview;

import android.graphics.Color;
import android.os.Bundle;
import com.it114.android.oneframework.core.ui.activity.BrowserActivity;
import com.it114.android.oneframework.sample1.R;

/**
 * Created by andy on 10/18/2015.
 */
public class WebViewActivity extends BrowserActivity {

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle("webView示例页面");
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initTitleBar(R.id.titlebar_layout,null);
        this.titleBarView.initTitleBarWithBackgroundColor(Color.GREEN);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.webview_activity_layout;
    }

    @Override
    public int getProgressBarId() {
        return R.id.progressBar;
    }

    @Override
    public int getWebViewId() {
        return R.id.webview;
    }
}
