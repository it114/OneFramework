package com.it114.android.oneframework.core.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 */
public class UiUtil {

    /** 获取屏幕的宽度 */
    public final static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static View getRootView(Activity context)
    {
        return ((ViewGroup)context.findViewById(android.R.id.content)).getChildAt(0);
    }

    public static void jumpActivity(Activity activity, Class<?> cls) {
        showActivity(activity, cls);
        activity.finish();
    }

    public static void jumpActivity(Activity activity, Intent it) {
        showActivity(activity, it);
        activity.finish();
    }

    public static void jumpActivity(Activity activity, Class<?> cls, Bundle extras) {
        showActivity(activity, cls, extras);
        activity.finish();
    }

    public static void showActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
    }

    public static void showActivity(Activity activity, Intent it) {
        activity.startActivity(it);
    }

    public static void showActivity(Activity activity, Class<?> cls, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(activity, cls);
        activity.startActivity(intent);
    }

    public static void showActivityForResult(Activity activity, Class<?> cls, int requestCode) {
        showActivityForResult(activity, cls, null, requestCode);
    }

    public static void showActivityForResult(Activity activity, Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, requestCode);
    }
}
