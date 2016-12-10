package com.example.matiasmsi.cdc_construccion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MatiasMSI on 18/11/2016.
 */

public class DBNet extends SQLiteOpenHelper {


    public String sqlcreate = "CREATE TABLE Tarea (Id INTEGER PRIMARY KEY AUTOINCREMENT, ID_REG INTEGER, INSPECTOR TEXT, OBR TEXT, SECTOR TEXT, SUBSECTOR TEXT,T_FORMULARIO TEXT , ESTADO INTEGER)";


    public DBNet(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("hola", "estoy en bdnet");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlcreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exist Tarea");

    }
}


