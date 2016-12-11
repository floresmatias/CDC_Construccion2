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
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * Created by MatiasMSI on 09/11/2016.
 */
//77
public class Receptor extends AppCompatActivity implements View.OnClickListener{
    LinkedList<Tarea> listaTarea=new LinkedList<Tarea>();

    EditText editText;
    Button btn, btn1;
    TextView text;
    JSONArray ja;
    Gson gson = new Gson();
    //ArrayList<String>list = new ArrayList<String>();
    String[] list = new String[6];
    LinkedList<Tarea> list1=new LinkedList<Tarea>() ;
    Tarea tarea = new Tarea();

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
                    int e=0;
                    for (int i=0;i<ja.length();i++){
                        JSONObject row = ja.getJSONObject(i);
                       // Tarea ta = new Tarea();
                        tarea.setId(row.getInt("id"));
                        tarea.setObra(row.getString("obra"));
                        tarea.setSector(row.getString("sector"));
                        tarea.setSubsector(row.getString("subSector"));
                        tarea.setFormulario(row.getString("formulario"));
                        list1.add(tarea);
                        retornaList1(list1,i);


                        e=e+1;
                        //Log.d("hola","soy row"+tarea.getId()+"e= "+e);
                        Log.d("pruebalist","id= "+list1.get(i).getId());
                    }

                        if(ja!=null){
                            int len=ja.length();
                            for(int i =0;i<len;i++) {
                                //list.add(ja.get(i).toString());
                                list[i] = ja.get(i).toString();
                            }


                        }
                        Log.d("hola","listatarea"+listaTarea);
                        Log.d("hola","lista try pos 2"+list[1]);
                        Log.d("hola","lista try pos 2"+list[2]);
                        Log.d("hola","lista try pos 2"+list[3]);
                        Log.d("hola","Jarray"+ja);
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

                break;
            case R.id.btnFormulario:









                Intent intent = new Intent(getApplicationContext(), ListaTarea.class);
                startActivity(intent);
                break;
        }

    }

    public void insertarEnBD(){

    }

        public void retornaList1(LinkedList<Tarea> list1,int i){
            ConectionBDManager manager = new ConectionBDManager(this);

                int id = list1.get(i).getId();
                String obra = list1.get(i).getObra();
                String sector = list1.get(i).getSector();
                String subsector = list1.get(i).getSubsector();
                String formulario = list1.get(i).getFormulario();

                manager.insertar(id, obra, sector, subsector, formulario, null);

                //Log.d("hola","tarea insertar"+id);
                Log.d("listinsert", "id= " + list1.get(i).getId());


            }


    }

