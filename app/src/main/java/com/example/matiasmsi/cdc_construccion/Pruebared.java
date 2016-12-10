package com.example.matiasmsi.cdc_construccion;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by MatiasMSI on 18/11/2016.
 */

public class Pruebared {

    Context context;
    boolean valor;


    public Pruebared(Context context) {
        this.context = context;
    }

    public boolean isConnected() {
        Log.d("hola","estoy en coneccion");
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if(info!=null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    Log.d("estado","conectado");
                    return true;


                }
            }
        }
        Log.d("estado","no conectado");

        return false;

    }
}
