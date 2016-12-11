package com.example.matiasmsi.cdc_construccion;

import android.content.ContentValues;
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
public class Receptor extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView text;
    JSONArray ja;
    Gson gson = new Gson();
    //ArrayList<String>list = new ArrayList<String>();
    String[] list = new String[6];
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


       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, obras);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);            }
        });**/
        btn.setOnClickListener(new View.OnClickListener() {




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
            @Override



            public void onClick(View view) {
                consultaTarea("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/obtenerTarea?idUsuario="+editText.getText().toString());



                        String newString2 = Arrays.toString(list);
                        newString2 = newString2.substring(1,newString2.length()-1);
                        Toast.makeText(getApplicationContext(), newString2, Toast.LENGTH_SHORT).show();
                        DBNet tareas1 = new DBNet(this, "DBNet", null, 1);
                        SQLiteDatabase db = tareas1.getWritableDatabase();
                        insertar2(newString2,"0");

                }
        });
    }


    public void consultaTarea(String URL) {
        Log.i("url", "" + URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    ja = new JSONArray(response);
                    String contra = ja.getString(0);
                    if (contra.equals(editText.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "algo malo a pasado", Toast.LENGTH_SHORT).show();
                        text.setText(contra);
                        if(ja!=null){
                            int len=ja.length();
                            for(int i =0;i<len;i++){
                                //list.add(ja.get(i).toString());
                                list[i] = ja.get(i).toString();
                            }
                        }
                        Log.d("hola",""+list);

                    }
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



    }

