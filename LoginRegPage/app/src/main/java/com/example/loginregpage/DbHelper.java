package com.example.loginregpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
   /* public static final String DB_NAME="QISCET";
    public static final String DB_TABLE="STUDENTS";
    public static final String  COL_0="1";
    public static final String COL_1="name";
    public static final String COL_2="password";
    public static final String COL_3="email";
    public static final int DB_VERSION=1;*/
   public static final String dbname="muni";
    public static final String db_table="students";
    public static final int db_version=1;
    public static final String col_0="id";
    public static final String col_1="name";
    public static final String col_2="age";
    public static final String query="create table "+db_table+"("+col_0+" integer primary key autoincrement,"+col_1+" text unique,"+col_2+" integer);";


    public DbHelper(@Nullable Context context) {
        super(context, dbname, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+db_table);
        onCreate(db);
    }
    /*Content Values for Save the data to Database
    * For retriving we have Cursor Class*/
    public long savaData(ContentValues cn){
        SQLiteDatabase db=getWritableDatabase();
        long row=db.insert(db_table,null,cn);
        return row;
    }
    public Cursor retriveData(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+db_table,
                null);
        return c;
    }

}
