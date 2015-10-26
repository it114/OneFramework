package com.it114.android.oneframework.core.data.db;

import android.provider.BaseColumns;
import com.it114.android.oneframework.core.OneApplication;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * Created by andy on 10/12/2015.
 */
public abstract class Datatable implements BaseColumns {
    public static DBHelper dbHelper   = DBHelper.getInstance(OneApplication.getInstance());
    public static ArrayList<String> SUBCLASSES = new ArrayList<>();
    private static Object subclassLock = new Object();

    public static void registerSubClass(String fullClassName){
        synchronized (subclassLock){
            SUBCLASSES.add(fullClassName);
        }
    }


    public static void unRegisterSubClass(String fullClassName){
        synchronized (subclassLock){
            SUBCLASSES.remove(fullClassName);
        }
    }

    public String getTableCreateor() {
        return getTableCreator(getTableName(), getTableMap());
    }
    @SuppressWarnings("unchecked")
    public static final Class<Datatable>[] getSubClasses() {
        ArrayList<Class<Datatable>> classes = new ArrayList<Class<Datatable>>();
        Class<Datatable> subClass = null;
        for (int i = 0; i < SUBCLASSES.size(); i++) {
            try {
                subClass = (Class<Datatable>) Class.forName(SUBCLASSES.get(i));
                classes.add(subClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                continue;
            }
        }
        return classes.toArray(new Class[0]);
    }

    private static final String getTableCreator(String tableName, Map<String, String> map) {
        String[] keys = map.keySet().toArray(new String[0]);
        String value = null;
        StringBuilder creator = new StringBuilder();
        creator.append("CREATE TABLE ").append(tableName).append("( ");
        int length = keys.length;
        for (int i = 0; i < length; i++) {
            value = map.get(keys[i]);
            creator.append(keys[i]).append(" ");
            creator.append(value);
            if (i < length - 1) {
                creator.append(",");
            }
        }
        creator.append(")");
        return creator.toString();
    }
    abstract public String getTableName();
    abstract protected Map<String, String> getTableMap();

    //abstract protected ContentValues toContentValues(BaseBean model);
}
