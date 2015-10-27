package com.it114.android.oneframework.core.http;


public abstract class HttpRequestHandler<E>  {
    public void onSuccess(E data){
    }
    public void onSuccess(E data, int totalPages, int currentPage){}
    public void onFailure(int statusCode,String error){}
    public void onFinish(){}
}
