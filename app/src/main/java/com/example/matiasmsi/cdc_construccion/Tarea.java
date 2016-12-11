package com.example.matiasmsi.cdc_construccion;

import android.util.Log;

/**
 * Created by matiasmsi on 10/12/2016.
 */

public class Tarea {

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
        Log.d("hola","estoy en tarea"+id);
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSubsector() {
        return subsector;
    }

    public void setSubsector(String subsector) {
        this.subsector = subsector;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    private int id;
    private String obra;
    private String sector;
    private String subsector;
    private String formulario;

    //id formulario=1;id=2;obra;sectir....)
    // id  form=2;id=4


}
