package com.example.matiasmsi.cdc_construccion;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by NoBuNaGa on 03/12/2016.
 */
//asdasd

public class Login extends AppCompatActivity implements Response.ErrorListener,Response.Listener<String> {

    Button btnlogin,btntarea;
    EditText usr,psd;
    String usuario , password;
    TextView txtusr;




    protected void onCreate(Bundle savedInstanceState){
        Log.d("hola","estoy en login");
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        txtusr = (TextView) findViewById(R.id.txtusuario);
        btntarea = (Button) findViewById(R.id.btnTarea) ;

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("hola","estoy en onclick");
                enviaUsuario();
            }


        });
        btntarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hola","estoy en btnEnviar");
                Intent intent = new Intent(getApplicationContext(), Receptor.class);
                startActivity(intent);
            }
        });

    }

    private void enviaUsuario (){
        Log.d("hola","estoy en enviarUsuario");
        EnviarLogin enviarLogin = new EnviarLogin(usr.getText().toString(),psd.getText().toString());
        Request<?> request = enviarLogin.getRequest(this,this);
        AppController.getInstance().addToRequestQueue(request);


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("hola","errorResponse");
        Log.d("hola",error.getMessage());
    }

    @Override
    public void onResponse(String response) {
        Log.d("hola","estoy en responsae");
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new DefaultExclusionStrategy());
        Gson gson = builder.create();
        Usuario usuario = gson.fromJson(response,Usuario.class);

        txtusr.setText("usuario"+usuario.getNombre());

    }
}
