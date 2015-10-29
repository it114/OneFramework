package com.it114.android.oneframework.core.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "_OneFramework";
	private static final int DB_VERSION = 1;
	private SQLiteDatabase db;
	private static DBHelper mdbHelper;

	public static DBHelper getInstance(Context context)
	{
		if(mdbHelper==null) {
			mdbHelper=new DBHelper(context);
		}
		return mdbHelper;
	}

	private DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.db = db;
		operateTable(db, "");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion == newVersion) {
			return;
		}
		operateTable(db, "DROP TABLE IF EXISTS ");
		onCreate(db);
	}

	public void operateTable(SQLiteDatabase db, String actionString) {
		Datatable.registerSubClass(HttpCacheTable.class.getName());
		Class<Datatable>[] columnsClasses = Datatable.getSubClasses();
		Datatable columns = null;
		for (int i = 0; i < columnsClasses.length; i++) {
			try {
				columns = columnsClasses[i].newInstance();
				if ("".equals(actionString) || actionString == null) {
					db.execSQL(columns.getTableCreateor());
				} else {
					db.execSQL(actionString + columns.getTableName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public long insert(String tableName, ContentValues values) {
		if (db == null)
			db = getWritableDatabase();
		return db.insert(tableName, null, values);
	}
	
	public long insertWithOnConflict(String tableName, ContentValues values){
		if (db == null)
			db = getWritableDatabase();
		return db.insertWithOnConflict(tableName, null, values, SQLiteDatabase.CONFLICT_REPLACE);
	}

	public int delete(String tableName, int id) {
		return delete(tableName,BaseColumns._ID,String.valueOf(id));
	}

	public int delete(String tableName,String column,String value ) {
		if (db == null)
			db = getWritableDatabase();
		return db.delete(tableName, column + "=?", new String[] { String.valueOf(value) });
	}

	public int update(String tableName, ContentValues values,
			String WhereClause, String[] whereArgs) {
		if (db == null) {
			db = getWritableDatabase();
		}
		return db.update(tableName, values, WhereClause, whereArgs);
	}

	public Cursor query(String tableName, String[] columns, String whereStr, String[] whereArgs) {
		if (db == null) {
			db = getReadableDatabase();
		}
		return db.query(tableName, columns, whereStr, whereArgs, null, null, null);
	}

	public Cursor rawQuery(String sql, String[] args) {
		if (db == null) {
			db = getReadableDatabase();
		}
		return db.rawQuery(sql, args);
	}

	public void execSQL(String sql) {
		if (db == null) {
			db = getWritableDatabase();
		}
		db.execSQL(sql);
	}

	public void closeDb() {
		if (db != null) {
			db.close();
			db = null;
		}
	}

}
