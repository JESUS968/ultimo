package com.appsforusers.agendabasedatos;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void agregar(View v)
    {
        Intent intent=new Intent(this,AgregarActivity.class);
        this.startActivityForResult(intent,1);
    }
    public void buscar(View v)
    {
        Intent intent=new Intent(this,BuscarActivity.class);
        this.startActivity(intent);
    }
    public void ver(View v)
    {
        Intent intent=new Intent(this,ListadoActivity.class);
        this.startActivity(intent);
    }

    // todo sallir de la aplicacion

    public void salir(View v)
    {
        System.exit(0);

    }





}
