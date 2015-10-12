package com.it114.android.oneframework.core;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;
import com.it114.android.oneframework.core.BuildConfig;
import com.it114.android.oneframework.core.data.Config;
import com.it114.android.oneframework.core.data.Constants;
import com.it114.android.oneframework.core.util.FileUtil;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.io.File;
import java.io.IOException;

/**
 * Created by andy on 10/9/2015.
 */
public class OneApplication extends Application  {
    static OneApplication INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initImageLoader();
    }

    public static OneApplication getInstance(){
        return INSTANCE;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    private void initImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheOnDisc(true)
                .displayer(new FadeInBitmapDisplayer(200))
                .build();

        File cacheDir = new File(FileUtil.getCacheDir().getAbsolutePath() + "/" + Constants.IMAGE_CACHE_DIR);
        ImageLoaderConfiguration.Builder configBuilder = null;
        try {
            configBuilder = new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .memoryCache(new WeakMemoryCache())
                    .diskCache(new LruDiskCache(cacheDir,new Md5FileNameGenerator(),500))
                    .denyCacheImageMultipleSizesInMemory()
                    .threadPoolSize(3)//线程池内加载的数量
                    .threadPriority(Thread.NORM_PRIORITY - 2)
                    .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                    .memoryCacheSize(2 * 1024 * 1024)
                    .discCacheSize(50 * 1024 * 1024)
                    .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                    .tasksProcessingOrder(QueueProcessingType.LIFO)
                    .discCacheFileCount(100) //缓存的文件数量
                            //.discCache(new UnlimitedDiscCache(cacheDir))
                    .defaultDisplayImageOptions(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (BuildConfig.DEBUG) {
            configBuilder.writeDebugLogs();
        }
        ImageLoader.getInstance().init(configBuilder.build());
    }

    public void setDebugModel(boolean debugModel){
        if(debugModel) {
            Config.showLogcat = true;
        } else {
            Config.showLogcat = false;
        }
    }
}
