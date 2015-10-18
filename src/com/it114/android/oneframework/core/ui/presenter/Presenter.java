package com.it114.android.oneframework.core.ui.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;

/**
 * Created by andy on 10/15/2015.
 */
public class Presenter {
    private final static int MSG_CODE_TASK_FINISH = -1;
    protected Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == MSG_CODE_TASK_FINISH ){
                doTaskFinish();
            }
        }
    };

    protected void init(){
        initData();
        initDoInBackground();
    }

    protected void destroy(){
        // avoid memory leak
        handler.removeCallbacksAndMessages(null);
    }

    /**
     * 数据初始化，在UI线程运行
     */
    private void initData(){

    }

    /**
     * 数据初始化在子线程运行
     */
    private void initDoInBackground() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doTask();
                handler.sendEmptyMessage(MSG_CODE_TASK_FINISH);
            }
        }).start();
    }

    /**
     * 后台任务，执行在后台线程
     */
    protected void doTask(){

    }

    /**
     * 后台任务完成，执行在UI线程
     */
    protected void doTaskFinish(){

    }


}
