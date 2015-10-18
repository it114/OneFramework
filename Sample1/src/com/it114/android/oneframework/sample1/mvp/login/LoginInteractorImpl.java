package com.it114.android.oneframework.sample1.mvp.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by andy on 10/15/2015.
 */
public class LoginInteractorImpl implements LoginInteractor  {
    @Override
    public void login(final String userName, final String password, final LoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        },3000);
    }
}
