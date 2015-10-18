package com.it114.android.oneframework.sample1.bean;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by andy on 10/18/2015.
 */
public class TestBean {

    public String username;
    public String password;
    public int age;
    public String signature;//签名
    public String icoImageUrl;//头像

    public static ArrayList<TestBean> createDataList(int size){
        ArrayList<TestBean> beans = new ArrayList<>();
        for(int i=0;i<size;i++){
            beans.add(create(i));
        }
        return beans;
    }

    public static TestBean create(int index){
        TestBean bean = new TestBean();
        bean.username = "Test00"+index;
        bean.password = "password-"+index;
        bean.age = getAge();
        bean.signature = "码农很拽的，你别不信...";
        bean.icoImageUrl = "http://tb1.bdstatic.com/tb/cms/ngmis/adsense/file_1445137409672.jpg";
        return bean;
    }

    private static int getAge(){
        Random random = new Random();
        return random.nextInt(150);
    }
}
