package com.it114.android.oneframework.core.http.asynchttp;

import com.it114.android.oneframework.core.OneApplication;
import com.it114.android.oneframework.core.data.cache.HttpCacheManager;
import com.it114.android.oneframework.core.bean.HttpCache;
import com.it114.android.oneframework.core.http.Http;
import com.it114.android.oneframework.core.http.HttpRequestHandler;
import com.it114.android.oneframework.core.http.SafeHandler;
import com.it114.android.oneframework.core.util.LogUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import org.apache.http.Header;

/**
 * Created by andy on 10/12/2015.
 * 使用asyncHttpClient实现
 */
public class AsyncHttp implements Http {
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static AsyncHttpClient getHttpClient(){
        client.setTimeout(15000);
        return client;
    }

    private static void get(String url,RequestParams params, AsyncHttpResponseHandler responseHandler) {
        LogUtil.d(null, url+"?"+((params == null)?"":params.toString()));
        getHttpClient().get(OneApplication.getInstance().getInstance(), url, params, responseHandler);
    }

    private static void post(String url,RequestParams params,AsyncHttpResponseHandler responseHandler) {
        LogUtil.d(null, url+"?"+((params == null)?"":params.toString()));
        getHttpClient().post(OneApplication.getInstance(), url, params, responseHandler);
    }

    @Override
    public void get(final String url, RequestParams params,final HttpRequestHandler handler) {
        get(false,-1,url, params,handler);
    }

    @Override
    public void post(final String url, RequestParams params, final HttpRequestHandler handler) {
        post(false,-1,url, params,handler);
    }

    @Override
    public void put(String url, RequestParams map, String postContent, HttpRequestHandler handler) {
        //TODO
    }

    @Override
    public void delete(String url, RequestParams map, String postContent, HttpRequestHandler handler) {
        //TODO
    }

    @Override
    public void get(final boolean useCache,long cacheTime, final String url, final RequestParams params, final HttpRequestHandler handler){
        HttpCache cache = null;
        if(useCache) {
            cache = HttpCacheManager.get(url, params);
            if(cache!=null){
                if(cache.updateTime+cacheTime*1000 < System.currentTimeMillis()){ //走缓存逻辑
                    SafeHandler.onSuccess(handler, cache.content);
                    LogUtil.d(null, url + " use cache ,return local cache ");
                    handler.onFinish();
                    return;
                } else {}
            } else {}
        } else {}
        final String defValue = (cache==null)?"":cache.content;
        get(url,params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFinish(handler);
                if("".equals(defValue)) {
                    SafeHandler.onFailure(handler, responseString);
                } else {
                    LogUtil.d(null,url+" return onFailure defValue is not null ,read cache");
                    SafeHandler.onSuccess(handler, defValue);
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                SafeHandler.onFinish(handler);
                SafeHandler.onSuccess(handler, responseString);
                if(useCache){
                    HttpCacheManager.create(url,params,responseString);
                }
            }
        });
    }

    @Override
    public void post(final boolean useCache,long cacheTime, final String url, final RequestParams params, final HttpRequestHandler  handler) {
        HttpCache cache = null;
        if(useCache) {
            cache = HttpCacheManager.get(url, params);
            if(cache!=null){
                if(cache.updateTime+cacheTime*1000 < System.currentTimeMillis()){ //走缓存逻辑
                    SafeHandler.onSuccess(handler,cache.content);
                    LogUtil.d(null, url + " use cache ,return local cache ");
                    handler.onFinish();
                    return;
                } else {}
            } else {}
        } else {}
        final String defValue = (cache==null)?"":cache.content;
        post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                SafeHandler.onFinish(handler);
                if ("".equals(defValue)) {
                    SafeHandler.onFailure(handler, responseString);
                } else {
                    LogUtil.d(null, url + " return onFailure defValue is not null ,read cache");
                    SafeHandler.onSuccess(handler, defValue);
                }
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                SafeHandler.onFinish(handler);
                SafeHandler.onSuccess(handler, responseString);
                if (useCache) {
                    HttpCacheManager.create(url, params, responseString);
                }
            }
        });
    }

}
