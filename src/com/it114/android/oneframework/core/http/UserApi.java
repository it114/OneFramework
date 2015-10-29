package com.it114.android.oneframework.core.http;

import com.it114.android.oneframework.core.bean.UserBean;
import com.it114.android.oneframework.core.http.asynchttp.AsyncHttp;
import com.loopj.android.http.RequestParams;

import java.net.URI;

/**
 * Created by andy on 10/12/2015.
 */
public class UserApi  {

    private static final String URI_USER_LOGIN = "/login.json";
    private static final String URI_USER_RPOFIE = "/profile.json";

    /**
     * no cache example
     * @param userName
     * @param password
     * @param handler
     */
    public static void login(String userName,String password,HttpRequestHandler handler) {
        RequestParams params = RequestManager.getRequestParams();
        params.put("password", password);
        params.put("username", userName);
        RequestManager.getInstance().getHttpImpl(RequestManager.HTTP_IMPL.ASYNC_IMPL).post(RequestManager.makeUrl(URI_USER_LOGIN), params, handler);
    }

    /**
     * use cache example
     * @param handler
     */
    public static void getUserList(HttpRequestHandler handler){
        RequestParams params = RequestManager.getRequestParams();
        RequestManager.getInstance().getHttpImpl().get(true,60,RequestManager.makeUrl(URI_USER_RPOFIE), params, handler);
    }
}
