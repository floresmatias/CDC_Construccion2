package com.example.matiasmsi.cdc_construccion;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matiasmsi on 10/12/2016.
 */

public class Usuario {

    int id;
    String nombre;
    String apellido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
