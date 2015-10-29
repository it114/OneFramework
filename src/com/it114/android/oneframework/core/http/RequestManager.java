package com.it114.android.oneframework.core.http;

import com.it114.android.oneframework.core.data.Config;
import com.it114.android.oneframework.core.http.asynchttp.AsyncHttp;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by andy on 10/29/2015.
 * 实现了http接口的网络管理类~目前只使用asynchttpclient来做
 * 后续可以用volly来实现
 */
public class RequestManager {
    public static  String API_HOST_DEBUG = "";
    public static  String API_HOST_RELEASE = "";
    private static RequestManager instance = new RequestManager();
    private static String currentImpl = "";
    public static enum  HTTP_IMPL  {
        ASYNC_IMPL,
    }
    private static boolean DEBUG = false;
    private static HashMap<String,String> commonParams = new HashMap<>();
    public static RequestManager getInstance(){
        return instance;
    }

    public static void initCommonParams(HashMap<String,String> params){
        if(params == null) return;
        commonParams = params;
    }

    public static RequestParams getRequestParams() {
        RequestParams requestParams = new RequestParams();
        if(commonParams !=null) {
            Iterator iter = commonParams.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                Object val = entry.getValue();
                if (!requestParams.has(key)) {
                    requestParams.put(key, val);
                }
            }
        }
        return  requestParams;
    }

    public  static void setHost(String releashHost,String debugHost){
        Config.API_HOST_DEBUG = debugHost;
        Config. API_HOST_RELEASE = releashHost;
    }


    public static String makeUrl(String uri){
        String host = Config.API_HOST_RELEASE;
        if(Config.debug) {
            host = Config.API_HOST_DEBUG;
        }
        return host+uri;
    }

    public Http getHttpImpl(HTTP_IMPL type) {
        if(HTTP_IMPL.ASYNC_IMPL == type){
            return new AsyncHttp();
        }
        throw new RuntimeException(type+" not implement ...");
    }

    public Http getHttpImpl(){
        return new AsyncHttp();
    }




}
