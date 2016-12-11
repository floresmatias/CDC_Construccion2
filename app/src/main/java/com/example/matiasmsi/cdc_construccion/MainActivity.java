package com.example.matiasmsi.cdc_construccion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etContra;
    Button btnIngresar;
    JSONArray ja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("hola","estoy en main");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContra = (EditText)findViewById(R.id.etContra);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConsultaPass("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/Autenticacion?rut="+etUsuario.getText().toString()+"&&clave="+etContra.getText().toString());

            }
        });

        //usuario: 18356676-8&clave=12345

    }
    private void ConsultaPass(String URL) {

        Log.i("url",""+URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    ja = new JSONArray(response);
                    String contra = ja.getString(0);
                    Log.d("Respuesta",ja.getString(0));
                    Intent intent = new Intent(MainActivity.this, Formulario.class);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);



    }
}
