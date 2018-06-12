package com.appsforusers.agendabasedatos;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static android.widget.CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView lstContactos;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        //todo creamos DBContactos y recupera la agenda

        DBContactos gestion=new DBContactos(this);

        // todo creamos cursor para recuperar el resultado de recuperar contactos

        Cursor cur=gestion.recuperarContactos();

        //todo recupera ListView

         lstContactos=(ListView)this.findViewById(R.id.lstContactos);

          String [] columns=new String[]{"nombre","email","edad"};



        // todo crea adaptador y lo asigna a la lista

        SimpleCursorAdapter sc= new SimpleCursorAdapter( this, android.R.layout.simple_list_item_1,
                cur, columns, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

         lstContactos.setAdapter(sc);



        gestion.close();

    }
    public void salir(View v)
    {
        this.finish();



    }
}
