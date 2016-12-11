package com.example.matiasmsi.cdc_construccion;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import org.json.JSONArray;
import org.json.JSONException;

import java.net.URL;


/**
 * Created by MatiasMSI on 09/11/2016.
 */

public class Receptor extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView text;
    JSONArray ja;


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
            @Override
            public void onClick(View view) {
                consultaTarea("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/obtenerTarea?idUsuario="+editText.getText().toString());

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

