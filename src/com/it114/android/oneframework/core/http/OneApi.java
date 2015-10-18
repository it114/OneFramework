package com.it114.android.oneframework.core.http;

import com.it114.android.oneframework.core.OneApplication;
import com.it114.android.oneframework.core.data.Config;
import com.it114.android.oneframework.core.data.cache.HttpCacheManager;
import com.it114.android.oneframework.core.model.BaseModel;
import com.it114.android.oneframework.core.model.DataModel;
import com.it114.android.oneframework.core.model.HttpCache;
import com.it114.android.oneframework.core.util.LogUtil;
import com.it114.android.oneframework.core.util.NetUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import org.apache.http.Header;

/**
 * Created by andy on 10/12/2015.
 */
public class OneApi {
    private final static String TAG = "OneApi";
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static AsyncHttpClient getHttpClient(){
        client.setTimeout(15000);
        return client;
    }

    private static void get(RequestParams params,String url, AsyncHttpResponseHandler responseHandler) {
        if(!NetUtil.isOpenNetwork()) {
            //返回数据库缓存
            //String content = HttpCacheManager.get(url,params);
            return;
        }
        LogUtil.d(TAG, params.toString());
        getHttpClient().get(OneApplication.getInstance().getInstance(), url, params, responseHandler);
    }

    private static void post(RequestParams params,String url,AsyncHttpResponseHandler responseHandler) {
        if(!NetUtil.isOpenNetwork()){
            //返回数据库缓存
            return ;
        }
        LogUtil.d(TAG, params.toString());
        getHttpClient().post(OneApplication.getInstance(), url, params, responseHandler);
    }


    public static RequestParams getRequestParams() {
        RequestParams params = new RequestParams();
        return params;
    }

    public static String makeUrl(String uri){
        String host = Config.API_HOST_RELEASE;
        if(Config.debug) {
            host = Config.API_HOST_DEBUG;
        }
        return host+uri;
    }


    /**
     * get请求
     * @param useCache 是否使用缓存
     * @param cacheTime 缓存时间：单位秒
     * @param url 访问地址
     * @param params 访问参数
     * @param handler
     */
    public static void get(boolean useCache,long cacheTime,String url,RequestParams params, final HttpRequestHandler  handler, final DataModel dataModel){
        HttpCache cache = null;
        if(useCache) {
            cache = HttpCacheManager.get(url, params);
            if(cache!=null){
                if(cache.updateTime+cacheTime*1000 < System.currentTimeMillis()){ //走缓存逻辑
                    SafeHandler.onSuccess(handler,cache.content);
                    handler.onFinish();
                    return;
                } else {}
            } else {}
        } else {}
        get(params, url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                handler.onFailure(statusCode,responseString);
                handler.onFinish();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                handler.onFinish();
                try {
                    dataModel.parse(responseString);
                    handler.onSuccess(dataModel);
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.onFailure(-1,"parse error");
                }
            }
        });
    }




}
