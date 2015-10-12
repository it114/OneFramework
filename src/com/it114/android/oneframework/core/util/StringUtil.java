package com.it114.android.oneframework.core.util;

import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/**
 * Created by andy on 10/12/2015.
 */
public class StringUtil {

    public static String mapToString(Map<String, Object> map) {
        if(map == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            String value = "";
            Object tempValue = map.get(key);
            if(tempValue instanceof RequestParams.FileWrapper )  {
                value = ((RequestParams.FileWrapper)tempValue).file.getAbsolutePath().toString();
            } else if(tempValue instanceof RequestParams.StreamWrapper){
                value = "streamWrapper";//TODO : get unique string
            } else {
                value = String.valueOf(tempValue);
            }
            try {
                stringBuilder.append((key != null ? URLEncoder.encode(key, "UTF-8") : ""));
                stringBuilder.append("=");
                stringBuilder.append(value != null ? URLEncoder.encode(value, "UTF-8") : "");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }
        }

        return stringBuilder.toString();
    }


}
