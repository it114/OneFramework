package com.it114.android.oneframework.sample1.eventbus;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.sample1.R;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by andy on 10/10/2015.
 */
public class EventBusActivity extends BaseActivity {

    @Bind(R.id.btn_PostThread)
    Button btnPostThread;
    @Bind(R.id.btn_MainThread)
    Button btnMainThread;
    @Bind(R.id.btn_BackgroundThread)
    Button btnBackgroundThread;
    @Bind(R.id.btn_Async)
    Button btnAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventbus_activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_PostThread)
    public void onPostThreadClick(){
        EventBus.getDefault().post(new PostThreadEvent("hello post thread !"));
    }

    @OnClick(R.id.btn_Async)
    public void onAsync(){

    }

    @OnClick(R.id.btn_BackgroundThread)
    public void onBackgroundThread(){

    }

    @OnClick(R.id.btn_MainThread)
    public void onMainThread(){

    }

    @Subscribe
    public void onEvent(PostThreadEvent event){
        Toast.makeText(this, event.message, 1).show();
    }


}
