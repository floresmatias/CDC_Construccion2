package com.example.matiasmsi.cdc_construccion;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by matiasmsi on 10/12/2016.
 */

public class EnviarLogin {
    private String usr;
    private String psd;

    public EnviarLogin(String psd, String usr){
        Log.d("hola","estoy en enviarLogin");
        this.usr = usr;
        this.psd = psd;


    }
    public StringRequest getRequest(Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        Log.d("hola","estoy en Hasmap");
      //  final HashMap<String,String> credenciales = new HashMap<>();
        //final HashMap<String,String>credenciales2 = new HashMap<>();
       // credenciales.put("rut",usr  );
        //credenciales.put("clave",psd);


        String url = "http://192.168.0.2:8084/WebServiceCDC/webresources/generic/Autenticacion";
        StringRequest request = new StringRequest(Request.Method.POST ,url,responseListener,errorListener){

            @Override
            public String getBodyContentType(){
                return "application/json charset"+getParamsEncoding();
            }

            @Override
            public byte[] getBody(){
                /*try {
                    return new JSONObject(credenciales).toString().getBytes(getParamsEncoding());
                }catch (UnsupportedEncodingException e){

                }*/
                return null;
            }
        };
        Log.d("hola","sali de has");
        request.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return request;
    }



}
