package com.it114.android.oneframework.core.util;

import android.content.Context;

/**
 * Created by andy on 10/18/2015.
 */
public class SharedPreferenceUtil {

    private static final String sharedPreferenceFileName = "_default_shared_file_name";
    private static SharedPreferenceUtil instance = null;

    public static SharedPreferenceUtil getInstance(){
        if(instance == null){
            instance = new SharedPreferenceUtil();
        }
        return instance;
    }

    /**
     *
     * @param cookieName   cookie file name ,or  null  ,use  defaulte name .
     * @param key  cookie key .
     * @param value
     */
    public boolean putString(Context context,String cookieName,String key,String value){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).edit().putString(key, value).commit();
    }
    /**
     *
     * @param cookieName  cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param value
     * @return
     */
    public boolean putBoolean(Context context,String cookieName,String key,boolean value){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).edit().putBoolean(key, value).commit();
    }
    /**
     *
     * @param cookieName  cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param value
     * @return
     */
    public boolean putFloat(Context context,String cookieName,String key,float value){
        return context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).edit().putFloat(key, value).commit();
    }
    /**
     *
     * @param cookieName   cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param value
     * @return
     */
    public boolean putLong(Context context,String cookieName,String key,long value){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).edit().putLong(key, value).commit();
    }

    /**
     *
     * @param cookieName   cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param value
     * @return
     */
    public boolean putInt(Context context,String cookieName,String key,int  value){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).edit().putInt(key, value).commit();
    }

    /**
     *
     * @param cookieName   cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param defValue
     * @return
     */
    public String getString(Context context,String cookieName,String key,String defValue){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).getString(key, defValue);
    }

    /**
     *
     * @param cookieName     cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(Context context,String cookieName,String key,boolean defValue){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).getBoolean(key, defValue);
    }
    /**
     *
     * @param cookieName  cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param defValue
     * @return
     */
    public float getFloat(Context context,String cookieName,String key,float defValue){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).getFloat(key, defValue);
    }
    /**
     *
     * @param cookieName  cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param defValue
     * @return
     */
    public int  getInt(Context context,String cookieName,String key,int defValue){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).getInt(key, defValue);
    }
    /**
     *
     * @param cookieName   cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @param defValue
     * @return
     */
    public long  getLong(Context context,String cookieName,String key,long  defValue){
        return  context.getSharedPreferences(((cookieName==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).getLong(key, defValue);
    }

    /**
     * @param cookieName    cookie file name ,or  null  ,use  defaulte name .
     * @param key
     * @return
     */
    public boolean isExists(Context context,String cookieName,String key){
        return   context.getSharedPreferences(((sharedPreferenceFileName ==null)? sharedPreferenceFileName :cookieName),Context.MODE_PRIVATE).contains(key);
    }

    /**
     * 清除cookie文件nei
     */
    public void clear(Context context,String fileName){
        context.getSharedPreferences(((sharedPreferenceFileName ==null)? sharedPreferenceFileName :fileName),Context.MODE_PRIVATE).edit().clear().commit();
    }

    /**从指定的cookie文件名中删除 key 的值
     * @param xmlname
     * @param key
     */
    public void remove(Context context,String xmlname,String key){
        context.getSharedPreferences(xmlname,Context.MODE_PRIVATE).edit().remove(key).commit();
    }

}
