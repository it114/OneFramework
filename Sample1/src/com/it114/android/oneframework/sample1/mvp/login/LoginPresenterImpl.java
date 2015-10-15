package com.it114.android.oneframework.sample1.mvp.login;

/**
 * Created by andy on 10/15/2015.
 */
public class LoginPresenterImpl implements LoginPresenter ,LoginLinstner{


    LoginView loginView;
    LoginInteractor loginInteractor;
    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void vaildUser(String userName, String password) {
        loginView.showProgress();
        this.loginInteractor.login(userName,password,this);
    }

    @Override
    public void onUsernameError() {
        loginView.hideProgress();
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgress();
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.navigateToHome();
    }

}
