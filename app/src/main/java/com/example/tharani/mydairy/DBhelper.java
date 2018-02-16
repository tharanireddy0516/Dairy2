package com.example.tharani.mydairy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tharani on 2/16/2018.
 */

public class DBhelper extends SQLiteOpenHelper {

    Context context;
    public DBhelper(Context context) {
        super(context, "MyNewDiary", null, 1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DIARY (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,CONTENT TEXT,DATE_CREATEAT TEXT);") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertData(Dairy dairy){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TITLE",dairy.getTitle());
        contentValues.put("CONTENT",dairy.getContent());
        contentValues.put("DATE_CREATEAT",dairy.getDbdate());

        long result = database.insert("DIARY",null,contentValues);
        if(result!=-1){
            Toast.makeText(context, "inserted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "not inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Dairy> getlist(){
        List<Dairy>dairies = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM DIARY", null);

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Dairy dairy = new Dairy();
                dairy.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")));
                dairy.setContent(cursor.getString(cursor.getColumnIndex("CONTENT")));
                dairy.setDbdate(cursor.getString(cursor.getColumnIndex("DATE_CREATEAT")));

                dairies.add(dairy);
                cursor.moveToNext();
            }
        }
        return dairies;
    }

}
