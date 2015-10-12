package com.it114.android.oneframework.core.util;

import android.os.Environment;
import com.it114.android.oneframework.core.OneApplication;

import java.io.File;

/**
 * Created by andy on 10/10/2015.
 */
public class FileUtil {

    /**
     * �õ�app�����ļ��У�����ʹ���ⲿ�洢�豸
     * @return
     */
    public static File getCacheDir(){
        File cacheDir = OneApplication.getInstance().getCacheDir();
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            cacheDir = OneApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        }
        return cacheDir;
    }
}
