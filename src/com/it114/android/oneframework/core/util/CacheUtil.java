package com.it114.android.oneframework.core.util;

import com.loopj.android.http.RequestParams;

import java.util.Map;

/**
 * Created by andy on 10/12/2015.
 */
public class CacheUtil {

    public static   String makeKey(String url,RequestParams params) {
        if (params != null) {
            url+=params.toString();
        }
        try {
            return	MD5.encryptMD5(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

}
