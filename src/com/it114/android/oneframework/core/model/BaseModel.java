package com.it114.android.oneframework.core.model;

import android.widget.Toast;
import com.it114.android.oneframework.core.OneApplication;
import com.it114.android.oneframework.core.R;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by andy on 10/12/2015.
 *
 * ���������ע���������ݸ�ʽ���������������ʽ�Ĳſ���ֱ�������model
 * {"code":1,"msg":"success","data":"{----}"}
 * �������ϸ�ʽ�������и������ĸ�ʽ��д����Ľ���
 *
 */
public  abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 2015082101L;
    public String msg="";
    public int code;
    protected boolean showErrorJsonMsg = true;
    abstract public boolean parseSuc();

    public void parse(String jsonObject) throws Exception {
        JSONObject object = new JSONObject(jsonObject);
        if(object!=null){
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
     * ���ݷ����Ƿ�ɹ�
     * @return
     */
    public boolean dataSuc(){
        return this.code == 1;
    }

    /**
     * ���������ص�json�е�msg����
     * @return
     */
    public String modelMessage(){
        return msg;
    }




}
