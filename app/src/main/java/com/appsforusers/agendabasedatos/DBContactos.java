package com.appsforusers.agendabasedatos;

// todo Clase del modelo que encapsula  el acceso a la base de datos
// todo y que será utilizada * por las actividades


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBContactos {

    // todo Atributos o variable tipo sqlite (permite ejecutar instrucciones sql)

    private SQLiteDatabase db=null;

    // todo Atributos o variable tipo databasehelper

    private DatabaseHelper dbhelper=null;

    // todo Contexto

     Context context;
     public DBContactos(Context contexto)
     {
         this.context=contexto;

     //todo crea una instancia del helper

     dbhelper = new DatabaseHelper(context);

     //todo crea un objeto SQLiteDatabase para operar
     //todo contra la base de datos

        db = dbhelper.getWritableDatabase();
     }
     public void close()
     {
         dbhelper.close();
     }

     //todo insertar registro en base de datos

     public long guardarContacto(Contacto c )
     {
         ContentValues initialValues=new ContentValues();
         initialValues.put("nombre", c.getNombre());
         initialValues.put("email", c.getEmail());
         initialValues.put("edad", c.getEdad());
         return db.insert("contactos", null, initialValues);
     }
     public Cursor recuperarContactos()
     {
     return db.query("contactos", new String[]{"_id","nombre","email","edad"},null, null, null,null,null);
     }
     public Contacto buscarPorEmail(String email)
     {
     Contacto con=null;
     Cursor c=db.query("contactos", new String[]
             {"_id", "nombre","email","edad"},
             "email=?", new String[]{email}, null,null,null);
     if(c.moveToNext())
         {
             con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
         }
         return con;
      }
    public Contacto buscarPorNombre(String nombre)
    {
        Contacto con=null;
        Cursor c=db.query("contactos", new String[]
                        {"_id", "nombre","email","edad"},
                "nombre=?", new String[]{nombre}, null,null,null);
        if(c.moveToNext())
        {
            con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
        }
        return con;
    }
    public Contacto buscarPoredad(String nombre)
    {
        Contacto con=null;
        Cursor c=db.query("contactos", new String[]
                        {"_id", "nombre","email","edad"},
                "edad=?", new String[]{nombre}, null,null,null);
        if(c.moveToNext())
        {
            con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
        }
        return con;
    }
     }



