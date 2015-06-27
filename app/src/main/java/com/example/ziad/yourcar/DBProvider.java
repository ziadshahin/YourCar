package com.example.ziad.yourcar;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Ziad on 22/06/2015.
 */
public class DBProvider extends ContentProvider {

    private DBHelper Carsdb;



    public static final String opel = "content://com.example.ziad.yourcar/1";
   public static final String mazda= "content://com.example.ziad.yourcar/2";
    public static final String audi = "content://com.example.ziad.yourcar/3";
    public static final String proton = "content://com.example.ziad.yourcar/4";
    public static final String mitsubishi = "content://com.example.ziad.yourcar/5";
   public static final String honda = "content://com.example.ziad.yourcar/6";

@Override
    public boolean onCreate()
{

    Carsdb=new DBHelper(getContext());


    return true;
}

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        Cursor retCursor;
        String selectQuery;

        switch (uri.toString()) {
            case opel: {
                selectQuery= "SELECT * FROM "+"Opel";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;
            }
            case mazda: {
                selectQuery= "SELECT * FROM "+"Mazda";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;
            }
            case audi:
            {
                selectQuery= "SELECT * FROM "+"Audi";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;
            }
            case proton: {
                selectQuery= "SELECT * FROM "+"Proton";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;
            }
            case mitsubishi: {
                selectQuery= "SELECT * FROM "+"Mitsubishi";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;
            }
            case honda: {
                selectQuery= "SELECT * FROM "+"Honda";
                retCursor=Carsdb.getReadableDatabase().rawQuery(selectQuery,null);
                break;

            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return Uri.parse("eh?");
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 1;
    }



    @Override
    public int update(
            Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 1;}

    @Override
    public String getType(Uri uri)
    {

        return "meen";
    }



}
