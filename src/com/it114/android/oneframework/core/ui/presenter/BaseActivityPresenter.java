package com.it114.android.oneframework.core.ui.presenter;


import android.content.Context;
import android.os.Bundle;


/**
 * Created by andy on 10/15/2015.
 */
public abstract class BaseActivityPresenter extends Presenter {

    public void onCreate(Bundle bundle){
        init();
    }

    public void onResume(){}

    public void onDestroy(){
        destroy();
    }

}
