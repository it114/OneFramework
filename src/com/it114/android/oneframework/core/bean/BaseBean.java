package com.it114.android.oneframework.core.bean;

import android.widget.Toast;
import com.it114.android.oneframework.core.OneApplication;
import com.it114.android.oneframework.core.R;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by andy on 10/12/2015.
 *
 * 基类解析。注意您的数据格式必须是下面这个格式的才可以直接用这个model
 * {"code":1,"msg":"success","data":"{----}"}
 * 不是如上格式的请自行根据您的格式来写基类的解析
 *
 */
public  abstract class BaseBean implements Serializable {
    private static final long serialVersionUID = 2015082101L;
    public String msg="";
    public int code;
    protected boolean showErrorJsonMsg = true;
    abstract public boolean parseSuc();

    public void parse(String jsonObject) throws Exception {
        JSONObject object = new JSONObject(jsonObject);
        if(object!=null) {
            this.msg = object.optString("msg");
            this.code = object.optInt("code");
            parseModel(object);
        } else {
            if(showErrorJsonMsg) {
                Toast.makeText(OneApplication.getInstance(),OneApplication.getInstance().getString(R.string.error_data_valid),Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void setShowErrorJsonMsg(boolean show){
        this.showErrorJsonMsg = show;
    }

    abstract void parseModel(JSONObject object) throws Exception;

    /**
     * 数据返回是否成功
     * @return
     */
    public boolean dataSuc(){
        return this.code == 1;
    }

    /**
     * 服务器返回的json中的msg数据
     * @return
     */
    public String modelMessage(){
        return msg;
    }




}
