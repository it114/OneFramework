package com.it114.android.oneframework.sample1.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.Bind;
import butterknife.OnClick;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.sample1.R;

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


}
