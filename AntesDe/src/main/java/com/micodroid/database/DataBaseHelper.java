package com.micodroid.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Created by var on 22/08/13.
 */
public class DataBaseHelper  extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "antes_de_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_ACTIVIDAD = "ACTVIDAD";
    public static final String TABLE_MEDIO = "MEDIO";

    public static final String CREATE_TABLE_ACTIVIDAD = "CREATE TABLE "+ TABLE_ACTIVIDAD+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITULO TEXT NOT NULL, DESCRIPCION TEXT NOT NULL, REALIZADA INTEGER DEFAULT NOT NULL, FECHA_ULTIMA_MODIFICACION INTEGER NOT NULL, FECHA_REALIZADA INTEGER NOT NULL, MEDIO INTEGER, ORDER  INTEGER);";
    public static final String CREATE_TABLE_MEDIO =  "CREATE TABLE "+ TABLE_MEDIO+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, URI TEXT NOT NULL);";

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_ACTIVIDAD);
        sqLiteDatabase.execSQL(CREATE_TABLE_MEDIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(DataBaseHelper.class.getName(), "Actualizando base de datos de la versio" + oldVersion + " a "
                + newVersion + ", se perderán todos los datos"
        );

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ACTIVIDAD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_MEDIO);

        onCreate(sqLiteDatabase);

    }
}

