package com.it114.android.oneframework.sample1.demo.main;

import android.content.Intent;
import android.os.Bundle;
import butterknife.OnClick;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.sample1.R;
import com.it114.android.oneframework.sample1.demo.adapter.AdapterActivity;
import com.it114.android.oneframework.sample1.demo.fragment.MyFragmentActivity;
import com.it114.android.oneframework.sample1.demo.serverrequest.RequestActivity;
import com.it114.android.oneframework.sample1.demo.titlebar.TitleBarActivity;
import com.it114.android.oneframework.sample1.demo.webview.WebViewActivity;

/**
 * Created by andy on 10/15/2015.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
       return  R.layout.main_activity_layout;
    }

    @OnClick(R.id.btnTitlebar)
    public void onBtnTitlebarClick(){
        Intent intent = new Intent(this,TitleBarActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.fragment)
    public void onFragmentClick(){
        Intent intent = new Intent(this,MyFragmentActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.adapter)
    public void onAdapterBtnClick(){
        Intent intent = new Intent(this,AdapterActivity.class);
        this.startActivity(intent);
    }

    @OnClick(R.id.webview)
    public void onWebViewBtnClick(){
        Intent intent = new Intent(this,WebViewActivity.class);
        intent.putExtra("url","http://m.baidu.com");
        this.startActivity(intent);
    }

    @OnClick(R.id.http_Request)
    public void onHttpRequest(){
        Intent intent = new Intent(this,RequestActivity.class);
        this.startActivity(intent);
    }


}
