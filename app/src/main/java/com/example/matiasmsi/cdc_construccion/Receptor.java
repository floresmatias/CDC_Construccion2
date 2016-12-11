package com.example.matiasmsi.cdc_construccion;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;


/**
 * Created by MatiasMSI on 09/11/2016.
 */
//77
public class Receptor extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button btn, btn1;
    TextView text;
    JSONArray ja;
    Gson gson = new Gson();
    //ArrayList<String>list = new ArrayList<String>();
    String[] list = new String[6];
    //String[] list1 = new String[6];
//45
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ListView listView;
        String[] obras = {"Obra1", "Obra2", "Obra3", "Obra4", "Obra5", "Obra6"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listatarea);
        editText = (EditText) findViewById(R.id.editTextId);
        btn = (Button) findViewById(R.id.btnEnviaId);
        text = (TextView) findViewById(R.id.textViewTarea);
        btn.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btnFormulario);
        btn1.setOnClickListener(this);

    }


        private static final String CN_TAREA = "TAREA";
        private static final String CN_ESTADO = "ESTADO";
        public void insertar2 (String TAREA, String Estado){
        DBNet tareas1 = new DBNet(this, "DBNet", null, 1);
        SQLiteDatabase db = tareas1.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(CN_TAREA, TAREA);
        valores.put(CN_ESTADO, Estado);
        db.insert("Tarea", null, valores);
    }






    public void consultaTarea(String URL) {
        Log.i("url", "" + URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    Log.d("hola","estoy en try de receptor");
                    ja = new JSONArray(response);
                    Log.d("hola","estoy en else de receptor");
                        //Toast.makeText(getApplicationContext(), "algo malo a pasado", Toast.LENGTH_SHORT).show();
                    text.setText(response);
                        if(ja!=null){
                            int len=ja.length();
                            for(int i =0;i<len;i++) {
                                //list.add(ja.get(i).toString());
                                list[i] = ja.get(i).toString();
                            }


                        }
                      //  Log.d("hola","lista"+list[2]);
                        Toast.makeText(getApplication(),list[0],Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "no hay tareas", Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnEnviaId:

                consultaTarea("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/obtenerTarea?idUsuario=" + editText.getText().toString());


                String newString2 = Arrays.toString(list);
                newString2 = newString2.substring(1,newString2.length()-1);
                Log.d("hola","lista onclick: "+list);
                Log.d("hola","lista newString  onclick: "+newString2);
                Toast.makeText(getApplicationContext(),"List modificada"+ newString2, Toast.LENGTH_SHORT).show();
                DBNet tareas1 = new DBNet(this, "DBNet", null, 1);
                SQLiteDatabase db = tareas1.getWritableDatabase();
                insertar2(newString2,"0");

                break;
            case R.id.btnFormulario:
                Intent intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);
                break;
        }

    }


    }

