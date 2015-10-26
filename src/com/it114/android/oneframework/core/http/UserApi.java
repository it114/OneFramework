package com.it114.android.oneframework.core.http;

import com.it114.android.oneframework.core.bean.UserBean;
import com.loopj.android.http.RequestParams;

/**
 * Created by andy on 10/12/2015.
 */
public class UserApi extends OneApi {

    private static final String URI_USER_LOGIN = "/login";
    private static final String URI_USER_RPOFIE = "/profile";

    /**
     * no cache example
     * @param userName
     * @param password
     * @param handler
     */
    public static void login(String userName,String password,HttpRequestHandler handler){
        RequestParams params = getRequestParams();
        params.put("password",password);
        params.put("username", userName);
        UserBean userModel = new UserBean();
        get(false, 0, makeUrl(URI_USER_LOGIN), params, handler,userModel);
    }

    /**
     * use cache example
     * @param handler
     */
    public static void getUserList(HttpRequestHandler handler){
        UserBean userModel = new UserBean();
       get(true,5*60,makeUrl(URI_USER_RPOFIE),getRequestParams(),handler,userModel);
    }
}
