package com.it114.android.oneframework.sample1.mvp.login;

/**
 * Created by andy on 10/15/2015.
 */
public interface LoginLinstner {
    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();
}
