package com.it114.android.oneframework.sample1.demo.serverrequest;

import android.os.Bundle;
import android.widget.Toast;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.it114.android.oneframework.core.bean.UserBean;
import com.it114.android.oneframework.core.http.HttpRequestHandler;
import com.it114.android.oneframework.core.http.RequestManager;
import com.it114.android.oneframework.core.http.UserApi;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.core.util.LogUtil;
import com.it114.android.oneframework.sample1.R;

import java.io.StringReader;
import java.util.HashMap;

/**
 * Created by andy on 10/29/2015.
 */
public class RequestActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {
        //在这里对requestManager初始化
        HashMap<String,String> map = new HashMap<>();
        map.put("os","android");
        map.put("version", "4.4");
        RequestManager.initCommonParams(map);
        RequestManager.setHost("http://10.128.7.71","http://10.128.7.71");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.request_activity_layout;
    }

    @OnClick(R.id.btnRequest)
    public void onRequest(){
        UserApi.getUserList(new HttpRequestHandler() {
            @Override
            public void onSuccess(Object data) {
                super.onSuccess(data);
                Gson gson  = new Gson();
                String str = (String) data;
                UserBean userBean = gson.fromJson(str, UserBean.class);
                Toast.makeText(RequestActivity.this,userBean.name,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, String error) {
                super.onFailure(statusCode, error);
                Toast.makeText(RequestActivity.this,error,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Toast.makeText(RequestActivity.this,"onFinish",Toast.LENGTH_LONG).show();
            }
        });

        UserApi.login("username", "pwd", new HttpRequestHandler() {
            @Override
            public void onSuccess(Object data) {
                super.onSuccess(data);
                LogUtil.d(null,"login data :"+data);
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }

            @Override
            public void onFailure(int statusCode, String error) {
                super.onFailure(statusCode, error);
                LogUtil.d(null, "login data :" + error);
            }
        });
    }
}
