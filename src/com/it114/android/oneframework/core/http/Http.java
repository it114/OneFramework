package com.it114.android.oneframework.core.http;

import com.it114.android.oneframework.core.bean.HttpCache;
import com.loopj.android.http.RequestParams;

import java.util.Map;

/**
 * Created by andy on 10/28/2015.
 POST /uri 创建
 DELETE /uri/xxx 删除
 PUT /uri/xxx 更新或创建
 GET /uri/xxx 查看
 */
public interface Http {

    public void get(String url,RequestParams map,HttpRequestHandler handler);

    public void post(String url,RequestParams map,HttpRequestHandler handler);

    public void put(String url,RequestParams map,String postContent,HttpRequestHandler handler);

    public void delete(String url,RequestParams map,String postContent,HttpRequestHandler handler);

    public void post(boolean useCache,long cacheTime,String url,RequestParams params, final HttpRequestHandler  handler);

    public void get(boolean useCache,long cacheTime,String url,RequestParams params, final HttpRequestHandler  handler);


}
