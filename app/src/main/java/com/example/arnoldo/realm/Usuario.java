package com.example.arnoldo.realm;

import io.realm.Realm;

import io.realm.RealmConfiguration;
import io.realm.RealmObject;

/**
 * Created by arnoldo on 18/05/18.
 */

public class Usuario extends RealmObject {//la clase que quieras que utilize realm necesitas extenderla
    String nombre;
    String edad;
    public  Usuario(){}

    public Usuario(String nombre,String edad){
        this.nombre=nombre;
        this.edad=edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
