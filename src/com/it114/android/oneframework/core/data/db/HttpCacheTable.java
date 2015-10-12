package com.it114.android.oneframework.core.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.it114.android.oneframework.core.model.BaseModel;
import com.it114.android.oneframework.core.model.HttpCache;
import com.it114.android.oneframework.core.util.CacheUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpCacheTable extends Datatable {
	public static final String TABLE_NAME = "httpCache";
	public static final String COLOMN_KEY = "key";
	public static final String COLOMN_URL = "url";
	public static final String COLOMN_PARAMS = "params";
	public static final String COLOMN_CONTENT = "content";
	public static final String COLOMN_UPDATETIME = "updateTime";
	private static final Map<String, String> mColumnMap = new HashMap<String, String>();
	static {
		mColumnMap.put(_ID, "integer primary key autoincrement");
		mColumnMap.put(COLOMN_KEY, "varchar(350) UNIQUE");
		mColumnMap.put(COLOMN_URL, "text");
		mColumnMap.put(COLOMN_PARAMS, "text");
		mColumnMap.put(COLOMN_CONTENT, "text");
		mColumnMap.put(COLOMN_UPDATETIME, "integer");
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected Map<String, String> getTableMap() {
		return mColumnMap;
	}

	public static ContentValues toContentValues(BaseModel model) {
		HttpCache httpCache = (HttpCache) model;
		ContentValues values = new ContentValues();
		values.put(COLOMN_KEY,httpCache.key);
		values.put(COLOMN_CONTENT,httpCache.content);
		values.put(COLOMN_URL,httpCache.url);
		values.put(COLOMN_PARAMS,httpCache.params);
		values.put(COLOMN_UPDATETIME,httpCache.updateTime);
		return values;
	}

	public static void insert(HttpCache cache){
		ContentValues values = toContentValues(cache);
		dbHelper.insert(TABLE_NAME, values);
	}

	public static void update(HttpCache cache){
		ContentValues values = toContentValues(cache);
		dbHelper.update(TABLE_NAME, values, "key=?", new String[] {""});
	}

	public static HttpCache get(String key){
		Cursor cursor = dbHelper.rawQuery("select * from " + HttpCacheTable.TABLE_NAME + " where " + HttpCacheTable.COLOMN_KEY + "=?", new String[]{key});
		if(cursor.moveToFirst()) {
			long updatetime =cursor.getLong(cursor.getColumnIndex(COLOMN_UPDATETIME));
			String url =cursor.getString(cursor.getColumnIndex(COLOMN_URL));
			String params =cursor.getString(cursor.getColumnIndex(COLOMN_PARAMS));
			String content = cursor.getString(cursor.getColumnIndex(COLOMN_CONTENT));
			HttpCache cache = new HttpCache();
			cache.url = url;
			cache.updateTime = updatetime;
			cache.content = content;
			cache.key = key;
			cache.params = params;
			return cache;
		}
		return null;
	}

	public static int delete(String key) {
		return dbHelper.delete(TABLE_NAME,COLOMN_KEY,key);
	}

	public static void  deleteByDate(int days){
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		Date time=calendar.getTime();
		dbHelper.execSQL("delete from "+TABLE_NAME +" where "+COLOMN_UPDATETIME +" > "+time.getTime());
	}




}
