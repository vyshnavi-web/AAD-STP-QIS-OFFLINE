package in.ac.khitguntur.phase1_praticals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Muneiah on 08-03-18.
 */

public class DbHelper extends SQLiteOpenHelper
{
    public static final String dbname="muni";
    public static final String db_table="students";
    public static final int db_version=1;
    public static final String col_0="id";
    public static final String col_1="name";
    public static final String col_2="age";
    public static final String query="create table "+db_table+"("+col_0+" integer primary key autoincrement,"+col_1+" text unique,"+col_2+" integer);";


    public DbHelper(Context context) {
        super(context, dbname, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("drop table if  exists "+db_table);
        onCreate(sqLiteDatabase);
    }
    public long saveDataValues(ContentValues cv){
        SQLiteDatabase db;
        db=getWritableDatabase();
        long rowaffected=db.insert(db_table,null,cv);
        return rowaffected;

    }
    public Cursor retriveData(){
        SQLiteDatabase db;
        db=getReadableDatabase();
       Cursor c=db.rawQuery("select * from "+db_table,null);
       return c;
    }
    /*public Cursor updateData(){
        SQLiteDatabase db;
        db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(, word);
        Cursor c=db.update(db_table,);
        return c;
    }*/


}
