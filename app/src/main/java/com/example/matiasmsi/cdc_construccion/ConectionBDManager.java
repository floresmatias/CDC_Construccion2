package com.example.matiasmsi.cdc_construccion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by matiasmsi on 11/12/2016.
 */

public class ConectionBDManager {
    public static final  String TABLE_NAME ="listatarea";

    public static final String CN_IDFORMU = "_id";
    public static final String CN_IDTAREA = "id";
    public static final String CN_OBRA = "obra";
    public static final String CN_SECTOR = "sector";
    public static final String CN_SUBSECTOR = "subsector";
    public static final String CN_FORMULARIO = "formulario";
    public static final String CN_ESTADO = "estado";


    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_IDFORMU + " integer primary key autoincrement,"
            + CN_IDTAREA + " integer not null,"
            + CN_OBRA + " text not null,"
            + CN_SECTOR + " text not null,"
            + CN_SUBSECTOR + " text not null,"
            + CN_FORMULARIO + " text not null,"
            + CN_ESTADO + " text);";


    private ConectionBD conectionBD;
    private SQLiteDatabase dblite;
    public ConectionBDManager(Context context){

        conectionBD = new ConectionBD(context);
        dblite = conectionBD.getWritableDatabase();

    }
    public ContentValues generarContent (int id,String obra,String sector, String subsector, String formulario ,String estado ){
        ContentValues valor = new ContentValues();
        Log.d("hola","estoy en generar");
        Tarea tarea = new Tarea();
        valor.put(CN_IDTAREA,id);
        Log.d("hola","soy cn"+CN_IDTAREA);
        valor.put(CN_OBRA,obra);
        valor.put(CN_SECTOR,sector);
        valor.put(CN_SUBSECTOR,subsector);
        valor.put(CN_FORMULARIO,formulario);
        valor.put(CN_ESTADO,estado);
        return valor;


    }

    public void insertar(int id,String obra,String sector, String subsector, String formulario ,String estado ){
        Log.d("hola","estoy en insertar"+id);
        dblite.insert(TABLE_NAME,null,generarContent(id,obra,sector,subsector,formulario,estado));

    }

    public Cursor cargarDatosTareas(){
        Log.d("hola","estoy en Cargadatos");
        String[] columnas = new String[]{CN_IDFORMU,CN_IDTAREA,CN_OBRA,CN_SECTOR,CN_SUBSECTOR,CN_FORMULARIO,CN_ESTADO};
        return dblite.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

}
