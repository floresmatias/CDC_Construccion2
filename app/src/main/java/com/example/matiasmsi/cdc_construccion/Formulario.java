package com.example.matiasmsi.cdc_construccion;


import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonPrimitive;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Random;

//asdasdadsad


public class Formulario extends AppCompatActivity implements View.OnClickListener {


    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9;
    String[] respuestas = new String[9];
    String pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9;
    Button btn,btn2,btn3,btn4;
    Pruebared cd;
    TextView resultado;
    EditText Tex;
    //Transmisor transmisor = new Transmisor();
    //chupalo
    Context editText;
    private CollationElementIterator textview;

    protected void onCreate(final Bundle savedInstanceState) {
        Log.d("hola","estoy en Formulario");
        Bundle parametro = getIntent().getExtras();
        if(parametro!=null){
           Toast.makeText(getApplicationContext(),parametro.getString("idTarea"),Toast.LENGTH_SHORT).show();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        cd = new Pruebared(this);
        radioGroup1 = (RadioGroup) findViewById(R.id.group1);
        radioGroup2 = (RadioGroup) findViewById(R.id.group2);
        radioGroup3 = (RadioGroup) findViewById(R.id.group3);
        radioGroup4 = (RadioGroup) findViewById(R.id.group4);
        radioGroup5 = (RadioGroup) findViewById(R.id.group5);
        radioGroup6 = (RadioGroup) findViewById(R.id.group6);
        radioGroup7 = (RadioGroup) findViewById(R.id.group7);
        radioGroup8 = (RadioGroup) findViewById(R.id.group8);
        radioGroup9 = (RadioGroup) findViewById(R.id.group9);


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio1) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta1 = "SI";
                    respuestas[0] = pregunta1;

                    return;
                } else if (i == R.id.radio2) {
                    Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio3) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta2 = "SI";
                    respuestas[1] = pregunta2;
                    return;
                } else if (i == R.id.radio4) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio5) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta3 = "SI";
                    respuestas[2] = pregunta3;
                    return;
                } else if (i == R.id.radio6) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio7) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta4 = "SI";
                    respuestas[3] = pregunta4;
                    return;
                } else if (i == R.id.radio8) {
                }

            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio9) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta5 = "SI";
                    respuestas[4] = pregunta5;
                    return;
                } else if (i == R.id.radio10) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });

        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio11) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta6 = "SI";
                    respuestas[5] = pregunta6;
                    return;
                } else if (i == R.id.radio12) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });


        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio13) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta7 = "SI";
                    respuestas[6] = pregunta7;
                    return;
                } else if (i == R.id.radio14) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });

        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio15) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta8 = "SI";
                    respuestas[7] = pregunta8;
                    return;
                } else if (i == R.id.radio16) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio17) {
                    Toast.makeText(getApplicationContext(), "si", Toast.LENGTH_SHORT).show();
                    pregunta9 = "SI";
                    respuestas[8] = pregunta9;
                    return;
                } else if (i == R.id.radio18) {
                    Toast.makeText(getApplicationContext(), pregunta1, Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn = (Button) findViewById(R.id.btnArreglo);
        btn.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btnConexion);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btnVista2);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btnJason);
        btn4.setOnClickListener(this);
        //new CompruebaRed.AsyncConnectTask().execute();

        resultado=(TextView) findViewById(R.id.txtResultado);



    }


    public void dialogoPregunta1(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta1 = Et_Respuesta.getText().toString().trim();
                if (pregunta1.length() != 0) {
                    Toast.makeText(Formulario.this, "GRACIAS", Toast.LENGTH_SHORT).show();
                    respuestas[0] = pregunta1;
                } else {
                    Toast.makeText(Formulario.this, "DEBE COMPLETAR EL TEXTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta2(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta2 =Et_Respuesta.getText().toString().trim();
                if (pregunta2.length() != 0) {
                    Toast.makeText(Formulario.this, "GRACIAS", Toast.LENGTH_SHORT).show();
                    respuestas[1] = pregunta2;
                } else {
                    Toast.makeText(Formulario.this, "DEBE COMPLETAR EL TEXTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta3(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta3 =Et_Respuesta.getText().toString().trim();
                if (pregunta3.length() != 0) {
                    Toast.makeText(Formulario.this, "GRACIAS", Toast.LENGTH_SHORT).show();
                    respuestas[2] = pregunta3;
                } else {
                    Toast.makeText(Formulario.this, "DEBE COMPLETAR EL TEXTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta4 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta4= Et_Respuesta.getText().toString().trim();
                if(pregunta4.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[3]=pregunta4;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta5 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta5= Et_Respuesta.getText().toString().trim();
                if(pregunta5.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[4]=pregunta5;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta6 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta6= Et_Respuesta.getText().toString().trim();
                if(pregunta6.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[5]=pregunta6;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta7 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta7= Et_Respuesta.getText().toString().trim();
                if(pregunta7.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[6]=pregunta7;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta8 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta8= Et_Respuesta.getText().toString().trim();
                if(pregunta8.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[7]=pregunta8;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ventana.show();
    }

    public void dialogoPregunta9 (View view){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage("INGRESE SU RESPUESTA");
        ventana.setTitle("Justificacion NO");
        final EditText Et_Respuesta = new EditText(this);
        ventana.setView(Et_Respuesta);
        ventana.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pregunta9= Et_Respuesta.getText().toString().trim();
                if(pregunta9.length()!=0){
                    Toast.makeText(Formulario.this,"GRACIAS",Toast.LENGTH_SHORT).show();
                    respuestas[8]=pregunta9;
                }else{
                    Toast.makeText(Formulario.this,"DEBE COMPLETAR EL TEXTO",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ventana.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });

        ventana.show();

    }
    private static final String CN_RESPUESTA = "Respuesta";
    public void insertar (String respuesta){
        DBPreguntas respuestas1 = new DBPreguntas(this, "DBPreguntas", null, 1);
        SQLiteDatabase db = respuestas1.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(CN_RESPUESTA,respuesta);
        db.insert("Fresp",null,valores);



    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case  R.id.btnArreglo:
                String newString = Arrays.toString(respuestas);
                Log.d("hola","estoy en lista formulario"+respuestas);
                Log.d("hola","Soy newString"+newString);
                newString = newString.substring(1,newString.length()-1);
                Toast.makeText(getApplicationContext(), newString, Toast.LENGTH_SHORT).show();
                DBPreguntas respuestas1 = new DBPreguntas(this, "DBPreguntas", null, 1);
                SQLiteDatabase db = respuestas1.getWritableDatabase();
                insertar(newString);
//asd
                //  String [] arreglocursor = new String[]{};
                //Cursor c = db.rawQuery("SELECT * FROM Fresp WHERE Respuesta=?",arreglocursor);
                //if (c.moveToFirst()) {
                //   Integer Id = c.getInt(0);
                //  String Respuesta = c.getString(1);
                // String nuevostring = Arrays.toString(arreglocursor);
                // nuevostring = nuevostring.substring(1,newString.length()-1);
                //Toast.makeText(getApplicationContext(), nuevostring, Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnVista2:
                //Intent intent = new Intent(getApplicationContext(), Receptor.class);
                //startActivity(intent);

                break;
            case R.id.btnConexion:
                if (cd.isConnected()) {
                    Toast.makeText(Formulario.this,"conectado",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Formulario.this,"no conectado",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnJason:

                String newString1 = Arrays.toString(respuestas);
                Log.d("hola","estoy en lista formulario"+respuestas);
                Log.d("hola","Soy newString"+newString1);
                newString1 = newString1.substring(1,newString1.length()-1);
                Toast.makeText(getApplicationContext(), newString1, Toast.LENGTH_SHORT).show();
                //Random random=new Random();
                Random rn = new Random();

                for(int i =0; i < 6; i++)
                {
                    int answer = rn.nextInt(1) + 1;
                    System.out.println(answer);
                }
                EnviarFormulario("http://192.168.0.2:8084/WebServiceCDC/webresources/generic/formularioCompleto?idTareaAsignada="+rn+"&respuesta="+newString1);



        }

    }

    private void EnviarFormulario(String URL) {

        Log.i("url",""+URL);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =  new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }
}





