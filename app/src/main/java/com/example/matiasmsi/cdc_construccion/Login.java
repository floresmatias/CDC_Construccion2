package com.example.matiasmsi.cdc_construccion;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by NoBuNaGa on 03/12/2016.
 */
//asdasd

public class Login extends AppCompatActivity  {
    Button btnlogin;
    EditText usr,psd;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_main);



        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final String username = usr.getText().toString();
                final String pasword = psd.getText().toString();


                if(username.length()== 0 || pasword.length()== 0){
                    Toast.makeText(Login.this,"Favor llenar campos usuario y contraseña",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

                }



            }


        });


    }




}
