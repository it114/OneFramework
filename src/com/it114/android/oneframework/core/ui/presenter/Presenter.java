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

    /**
     * ���ݳ�ʼ������UI�߳�����
     */
    private void initData(){

    }

    /**
     * ���ݳ�ʼ�������߳�����
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
     * ��̨����ִ���ں�̨�߳�
     */
    protected void doTask(){

    }

    /**
     * ��̨������ɣ�ִ����UI�߳�
     */
    protected void doTaskFinish(){

    }

}
