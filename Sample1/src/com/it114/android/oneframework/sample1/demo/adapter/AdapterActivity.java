package com.it114.android.oneframework.sample1.demo.adapter;

import android.os.Bundle;
import android.widget.ListView;
import butterknife.Bind;
import com.it114.android.oneframework.core.ui.activity.BaseActivity;
import com.it114.android.oneframework.sample1.R;
import com.it114.android.oneframework.sample1.bean.TestBean;

/**
 * Created by andy on 10/18/2015.
 */
public class AdapterActivity extends BaseActivity {

    @Bind(R.id.listview)
    ListView listView;

    private MyAdapter myAdapter ;
    @Override
    protected void init(Bundle savedInstanceState) {
        myAdapter = new MyAdapter(listView, TestBean.createDataList(20),R.layout.adapter_item_layout);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adapter_activity_layout;
    }
}
