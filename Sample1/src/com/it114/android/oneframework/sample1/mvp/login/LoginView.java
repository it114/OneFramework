package com.it114.android.oneframework.sample1.mvp.login;

/**
 * Created by andy on 10/15/2015.
 */
public interface LoginView  {
    public void showProgress();

    public void hideProgress();

    public void setUsernameError();

    public void setPasswordError();

    public void navigateToHome();
}
