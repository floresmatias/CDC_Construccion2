package com.example.matiasmsi.cdc_construccion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by matiasmsi on 11/12/2016.
 */

public class ConectionBD extends SQLiteOpenHelper {

    private static final String DB_NAME = "listatarea.sqlite";
    private static final int DB_SCHEME_VERSION = 1;

    public ConectionBD(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase dblite) {
        dblite.execSQL(ConectionBDManager.CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase dblite, int oldVersion, int newVersion) {

    }
}
