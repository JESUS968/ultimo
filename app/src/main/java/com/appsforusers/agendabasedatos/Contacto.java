package com.appsforusers.agendabasedatos;

class Contacto
{

// todo atributos de la clase contacto
    private String nombre;
    private String email;
    private int edad;

    // todo contrucctor generado con code generate

    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }
    // todo getter and setter generados con code generate

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
