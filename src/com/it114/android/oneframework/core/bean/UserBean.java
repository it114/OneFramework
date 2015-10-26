package com.it114.android.oneframework.core.bean;

import org.json.JSONObject;

/**
 * Created by andy on 10/12/2015.
 */
public class UserBean extends DataBean {

    public String password;
    public String username;

    @Override
    public boolean parseSuc() {
        return false;
    }

    @Override
    void parseModel(JSONObject object) throws Exception {
        //TODO 
    }

}
