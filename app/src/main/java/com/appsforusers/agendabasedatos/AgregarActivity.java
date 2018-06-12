package com.appsforusers.agendabasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgregarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }
    public void guardar(View v)
    {
        // todo recogemos los datos introducidos

        String nombre=((EditText)this.findViewById(R.id.edtNombre)).getText().toString();
        String email=((EditText)this.findViewById(R.id.edtEmail)).getText().toString();
        int edad=Integer.parseInt(((EditText) this.findViewById(R.id.edtEdad)).getText().toString());

        // todo creamos objetocontacto

        Contacto c=new Contacto(nombre, email, edad);

        // todo creamos un DBContactos y añadimos
        // todo el nuevo contacto

        DBContactos gestion=new DBContactos(this);
        gestion.guardarContacto(c);

        //todo cerramos la base de datos

        gestion.close();

        // todo finalizamos la actividad

        this.finish();

    }

        public void salir(View view)
        {
            this.finish();
        }











}
