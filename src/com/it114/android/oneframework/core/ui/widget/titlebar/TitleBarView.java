package com.it114.android.oneframework.core.ui.widget.titlebar;

import android.app.Activity;
import android.view.View;

/**
 * Created by andy on 10/18/2015.
 */
public interface TitleBarView {

    public Activity getOutActivity();

    public void initBackBtnWithBackgroundImage(int res);

    public void initTitleText(String titleText);

    public void initTitleBarWithBackgroundImage(int resImg);

    public void initRightText(String rightText);

    public void initRightImage(int resImg);

}
