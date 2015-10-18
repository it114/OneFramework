package com.it114.android.oneframework.core.ui.widget.titlebar;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.it114.android.oneframework.core.R;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.core.util.LogUtil;
import com.it114.android.oneframework.core.util.ViewFinder;


/**
 * Created by andy on 10/18/2015.
 * 这里准确的说不是一个实质意义上的view，只是为了把view的功能封装起来，这样做比较实用，而且作用上和view的功能最接近
 */
public class TitleBarViewImpl implements TitleBarView {
    private final static String TAG = "TitleBarViewImpl";
    private View titleBarView;
    private Activity outActivity;
    private ViewFinder viewFinder;

    public ImageView imgTitleBarBg;
    public ImageButton imgBtnLeft;
    public ImageButton imgBtnRight;
    public TextView tvTitleBarText;
    public TextView tvRightTextBtn;

    private TitleBarListener titleBarListener;

    public TitleBarViewImpl(Activity outActivity, View titleBarView){
        this.titleBarView = titleBarView;
        this.viewFinder = new ViewFinder(titleBarView);
        this.outActivity = outActivity;
        initWidgets();
        initBackBtnWithBackgroundImage(-1);
        initTitleText((getOutActivity().getTitle() !=null) ?getOutActivity().getTitle().toString():"");
    }

    private void initWidgets() {
        this.imgTitleBarBg = viewFinder.findViewById(R.id.imgTitleBarBg);
        this.imgBtnLeft  = viewFinder.findViewById(R.id.img_header_left_btn);
        this.imgBtnRight = viewFinder.findViewById(R.id.img_header_right_btn);
        this.tvRightTextBtn = viewFinder.findViewById(R.id.tv_header_right_btn);
        this.tvTitleBarText = viewFinder.findViewById(R.id.tv_header_title_text);

        this.tvRightTextBtn.setVisibility(View.GONE);
        this.imgBtnRight.setVisibility(View.GONE);
    }

    public void setTitleBarListener(TitleBarListener listener){
        if(listener!=null) {
            this.titleBarListener = listener;
        }
    }

    @Override
    public Activity getOutActivity() {
        return this.outActivity;
    }

    @Override
    public void initBackBtnWithBackgroundImage(int backImgRes) {
        this.imgBtnLeft.setVisibility(View.VISIBLE);
        if(backImgRes>0){
            this.imgBtnLeft.setBackgroundResource(backImgRes);
        } else {
            LogUtil.w(TAG," invalid resImg .");
        }
        this.imgBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOutActivity().finish();
            }
        });
    }

    @Override
    public void initTitleText(String titleText) {
        this.tvTitleBarText.setVisibility(View.VISIBLE);
        this.tvTitleBarText.setText(titleText);
    }

    @Override
    public void initTitleBarWithBackgroundImage(int resImg) {
        this.imgTitleBarBg.setVisibility(View.VISIBLE);
        if(resImg >0) {
            this.imgTitleBarBg.setBackgroundResource(resImg);
        } else {
            LogUtil.w(TAG," invalid resImg .");
        }
    }

    @Override
    public void initRightText(String rightText) {
        this.tvRightTextBtn.setText(rightText);
        this.tvRightTextBtn.setVisibility(View.VISIBLE);
        this.imgBtnRight.setVisibility(View.GONE);
        this.tvRightTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titleBarListener !=null) {
                    titleBarListener.onRightTextBtnClick(view);
                }
            }
        });
    }

    @Override
    public void initRightImage(int resImg) {
        if(resImg >0){
            this.imgBtnRight.setBackgroundResource(resImg);
        } else {
            LogUtil.w(TAG," invalid resImg .");
        }
        this.tvRightTextBtn.setVisibility(View.GONE);
        this.imgBtnRight.setVisibility(View.VISIBLE);
        this.imgBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleBarListener.onRightImgBtnClick(view);
            }
        });
    }
}
