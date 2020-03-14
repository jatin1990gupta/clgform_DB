package com.example.recview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "details.db";
    public static final String TABLE_NAME = "details";
    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "GENDER";
    public static final String col4 = "DATEOFBIRTH";
    public static final String col5 = "FATHERSNAME";
    public static final String col6 = "FATHERSOCCUPATION";
    public static final String col7 = "tenthBOARD";
    public static final String col8 = "tenthROLLNO";
    public static final String col9 = "tenthPERCENTAGE";
    public static final String col10 = "thBOARD";
    public static final String col11 = "thROLLNO";
    public static final String col12 = "thPERCENTAGE";
    public static final String col13 = "MOBNUMBER";
    public static final String col14 = "EMAILID";
    public static final String col15 = "ADDRESS";
    public static final String col16 = "PROGRAMME";
    public static final String col17 = "TIME";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "( "+ col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col2+" TEXT, " +
                col3+" TEXT, " +
                col4+" TEXT, " +
                col5+" TEXT, " +
                col6+" TEXT, " +
                col7+" TEXT, " +
                col8+" TEXT, " +
                col9+" TEXT, " +
                col10+" TEXT, " +
                col11+" TEXT, " +
                col12+" TEXT, " +
                col13+" TEXT, " +
                col14+" TEXT, " +
                col15+" TEXT, " +
                col16+" TEXT, " +
                col17+" TEXT )";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean add_data(String name, String gender,  String dob, String fname, String focc, String board10, String roll10, String per10,
                            String board12, String roll12, String per12, String mob, String email, String address, String programme, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, name);
        cv.put(col3, gender);
        cv.put(col4, dob);
        cv.put(col5, fname);
        cv.put(col6, focc);
        cv.put(col7, board10);
        cv.put(col8, roll10);
        cv.put(col9, per10);
        cv.put(col10, board12);
        cv.put(col11, roll12);
        cv.put(col12, per12);
        cv.put(col13, mob);
        cv.put(col14, email);
        cv.put(col15, address);
        cv.put(col16, programme);
        cv.put(col17, time);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<data> getListContents(){
        ArrayList<data> datalist = new ArrayList<data>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);

        try {
            data.moveToLast();
            do {
                String name = data.getString(data.getColumnIndex(col2));
                String gender = data.getString(data.getColumnIndex(col3));
                String dob = data.getString(data.getColumnIndex(col4));
                String fname = data.getString(data.getColumnIndex(col5));
                String focc = data.getString(data.getColumnIndex(col6));
                String board10 = data.getString(data.getColumnIndex(col7));
                String roll10 = data.getString(data.getColumnIndex(col8));
                String per10 = data.getString(data.getColumnIndex(col9));
                String board12 = data.getString(data.getColumnIndex(col10));
                String roll12 = data.getString(data.getColumnIndex(col11));
                String per12 = data.getString(data.getColumnIndex(col12));
                String mob = data.getString(data.getColumnIndex(col13));
                String email = data.getString(data.getColumnIndex(col14));
                String address = data.getString(data.getColumnIndex(col15));
                String programme = data.getString(data.getColumnIndex(col16));
                String time = data.getString(data.getColumnIndex(col17));

                data dts = new data(name, gender, dob, fname, focc, board10, roll10,
                        per10, board12, roll12, per12, mob, email, address, programme, time);
                datalist.add(dts);
            } while (data.moveToPrevious());
        }catch(Exception ex){
            Log.e("NO RECORDS FOUND.",ex.toString());
        }

        return datalist;
    }

    public boolean delete_data(String name){

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM " + "details " + "WHERE " + col2 + "=\"" + name + "\";");

        } catch (Exception e){
            Log.e("Error","Unsuccessfull.");
            return  false;

        }return  true;
    }
}
