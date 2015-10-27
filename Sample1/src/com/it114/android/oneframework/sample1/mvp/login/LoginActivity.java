package com.it114.android.oneframework.sample1.mvp.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.OnClick;
import com.it114.android.oneframework.core.ui.activity.BaseFragmentActivity;
import com.it114.android.oneframework.sample1.R;
import com.it114.android.oneframework.sample1.mvp.main.MainActivity;

/**
 * Created by andy on 10/15/2015.
 */
public class LoginActivity  extends BaseFragmentActivity implements LoginView{

    private ProgressDialog pd;
    @Bind(R.id.etUserName)
    EditText etUsername;
    @Bind(R.id.etPassword)
    EditText etPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        loginPresenter = new LoginPresenterImpl(this);
        return R.layout.login_activity_layout;
    }

    @OnClick(R.id.btnLogin)
    void onBtnLoginClick(){
        loginPresenter.vaildUser(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @Override
    public void showProgress() {
        if(pd == null ) {
            pd = ProgressDialog.show(this, "提示", "加载中...", true, false);
        }
        pd.show();
    }

    @Override
    public void hideProgress() {
        if(pd != null ) {
            pd.dismiss();
        }
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(this,"用户名错误",1).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"密码错误",1).show();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
