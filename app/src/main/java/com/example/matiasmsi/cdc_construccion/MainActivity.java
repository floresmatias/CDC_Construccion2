package com.example.matiasmsi.cdc_construccion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario, etContra;
    Button btnIngresar;
    JSONArray ja;
    JsonObject jo;
    JsonPrimitive jp;
    Usuario usr = new Usuario();
    LinkedList<Usuario> list1=new LinkedList<Usuario>();
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("hola","estoy en main");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etContra = (EditText)findViewById(R.id.etContra);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        text = (TextView) findViewById(R.id.txtLogin);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("hola","estoy en onclick");
                ConsultaPass ("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/Autenticacion?rut="+etUsuario.getText().toString()+"&&"+"clave="+etContra.getText().toString());
                Log.d("hola","consulte url");



            }
        });

        //usuario: 18356676-8&clave=12345

    }
    private void ConsultaPass(String URL) {

        Log.i("url",""+URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("hola","estoy en Response LOgin");
                text.setText(response);

                try {
                    Log.d("hola","estoy en try logn");
                    if(text.length()>35){
                        Intent intent = new Intent(getApplicationContext(), Receptor.class);
                        startActivity(intent);
                        Log.d("hola","Estoy en if");

                    }else{
                        Toast.makeText(getApplicationContext(),"login malo",Toast.LENGTH_SHORT).show();
                    }
                    ja = new JSONArray(response);
                    Log.d("hola","Json array"+response.toString());
                    for (int i=0;i<ja.length();i++){
                        Log.d("hola","estoy en for login");
                        JSONObject row = ja.getJSONObject(i);
                        usr.setId(row.getInt("id"));
                        usr.setNombre(row.getString("nombre"));
                        usr.setApellido(row.getString("apellido"));
                        list1.add(usr);
                        retornaList1(list1,i);

                    }



                    if (ja!=null) {
                        Log.d("hola","estoy en if de login");




                    } else {
                        Log.d("hola","prueba login");

                    }


                } catch (JSONException e) {
                    Log.d("hola","Estoy en excepcion");
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

    public void retornaList1(LinkedList<Usuario> list1,int i){
        Log.d("hola","estoy en retorna");

        int id = list1.get(i).getId();
        String nombre = list1.get(i).getNombre();
        String aperllido = list1.get(i).getApellido();
        if(id>0){



        }
        else
        {
            Toast.makeText(getApplicationContext(),"login malo",Toast.LENGTH_SHORT).show();
        }


        //Log.d("hola","tarea insertar"+id);
        Log.d("listinsert", "id= " + list1.get(i).getId());


    }




}