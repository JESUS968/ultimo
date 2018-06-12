package com.appsforusers.agendabasedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Contactos";
    private static final int DATABASE_VERSION=1;

    // todo sql de creación de tabla

    private static final String DATABASE_CREATE_CONTACTOS=
            "create table contactos (_id integer primary key " +
                    "autoincrement, " +
                    "nombre text not null, email text not null, edad integer " +
                    "not null)";

    // todo sql eliminación de tabla

    private static final String DATABASE_DELETE_CONTACTOS=
            "drop table if exists contactos";

    public DatabaseHelper(Context context)
    {
        // todo la siguiente linea super hace referencia a la superclase o padre

        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    // todo Se llama al crear la base de datos

    @Override public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    // todo este método es llamado si a la hora de crear el DataBaseHelper
    // todo se pasa una versión superior a la ya existente

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

     // todo reconstruimos la tabla

        deleteTables(db);
        createTables(db);
    }
    private void createTables(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE_CONTACTOS);
    }
    private void deleteTables(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_DELETE_CONTACTOS);


    }




}
