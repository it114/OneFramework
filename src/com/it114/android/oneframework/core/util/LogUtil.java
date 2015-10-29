package com.it114.android.oneframework.core.util;

import com.it114.android.oneframework.core.data.Config;

public class LogUtil {
	private final static String TAG = "oneapi";
	private static String checkTag(String tag){
		return (tag == null)?TAG:tag;
	}

	public static void v(String tag, String msg) {
		if (Config.debug)
			android.util.Log.v(checkTag(tag), msg);
	}

	public static void v(String tag, String msg, Throwable t) {
		if (Config.debug)
			android.util.Log.v(checkTag(tag), msg, t);
	}

	public static void d(String tag, String msg) {
		if (Config.debug)
			android.util.Log.d(checkTag(tag), msg);
	}

	public static void d(String tag, String msg, Throwable t) {
		if (Config.debug)
			android.util.Log.d(checkTag(tag), msg, t);
	}

	public static void i(String tag, String msg) {
		if (Config.debug)
			android.util.Log.i(checkTag(tag), msg);
	}

	public static void i(String tag, String msg, Throwable t) {
		if (Config.debug)
			android.util.Log.i(checkTag(tag), msg, t);
	}

	public static void w(String tag, String msg) {
		if (Config.debug)
			android.util.Log.w(checkTag(tag), msg);
	}

	public static void w(String tag, String msg, Throwable t) {
		if (Config.debug)
			android.util.Log.w(checkTag(tag), msg, t);
	}

	public static void e(String tag, String msg) {
		if (Config.debug)
			android.util.Log.e(checkTag(tag), msg);
	}

	public static void e(String tag, String msg, Throwable t) {
		if (Config.debug)
			android.util.Log.e(checkTag(tag), msg, t);
	}
}
