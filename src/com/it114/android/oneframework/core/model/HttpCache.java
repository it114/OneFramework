package com.it114.android.oneframework.core.model;

import org.json.JSONObject;

public class HttpCache extends BaseModel{
	public Integer id;
	public String key;//请求地址和请求参数的md5
	public String url;//请求地址
	public String params;//请求参数
	public String content;//服务器返回数据
	public Long updateTime;//更新时间


	@Override
	public boolean parseSuccess() {
		return false;
	}

	@Override
	void parseModel(JSONObject object) throws Exception {

	}
}
