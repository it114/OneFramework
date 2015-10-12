package com.it114.android.oneframework.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import com.it114.android.oneframework.core.OneApplication;

/**
 * Created by andy on 10/12/2015.
 */
public class NetUtil {

    public  static boolean isOpenNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) OneApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

}
