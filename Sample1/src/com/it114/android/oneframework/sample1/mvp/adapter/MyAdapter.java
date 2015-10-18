package com.it114.android.oneframework.sample1.mvp.adapter;

import android.widget.AbsListView;
import android.widget.ImageView;
import com.it114.android.oneframework.core.ui.widget.adapter.AdapterHolder;
import com.it114.android.oneframework.core.ui.widget.adapter.OneAdapter;
import com.it114.android.oneframework.sample1.R;
import com.it114.android.oneframework.sample1.bean.TestBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.Collection;

/**
 * Created by andy on 10/18/2015.
 */
public class MyAdapter extends OneAdapter<TestBean> {

    public MyAdapter(AbsListView view, Collection mDatas, int itemLayoutId) {
        super(view, mDatas, R.layout.adapter_item_layout);
    }

    @Override
    public void convert(AdapterHolder helper, TestBean item, boolean isScrolling) {
        ImageView imgIcon = helper.getView(R.id.img_user_icon);
        ImageLoader.getInstance().displayImage(item.icoImageUrl,imgIcon);
        helper.setText(R.id.tv_username,item.username);
        helper.setText(R.id.tv_singature,item.signature);
    }
}
