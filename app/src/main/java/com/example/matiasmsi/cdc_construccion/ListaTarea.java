package com.example.matiasmsi.cdc_construccion;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by matiasmsi on 11/12/2016.
 */

public class ListaTarea extends AppCompatActivity{
    private Cursor cursor;
    private ConectionBDManager manager;
    private ListView lista;
    SimpleCursorAdapter adapter;


    protected void onCreate(Bundle savedInstanceState) {

        Log.d("text","Text1 ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llistabd);

        manager = new ConectionBDManager(this);
        lista = (ListView) findViewById(R.id.listbd);
        final String[] from = new String[]{manager.CN_IDTAREA,manager.CN_OBRA};
        int[]to = new int []{android.R.id.text1,android.R.id.text2};
        cursor = manager.cargarDatosTareas();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) cursor);

        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
       //SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_expandable_list_item_1,);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int lis = Integer.parseInt((String) lista.getItemAtPosition(position));
               String valorid =  adapterView.getTransitionName();
                Intent intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);
                intent.putExtra("idTarea",valorid);
                Toast.makeText(getApplicationContext(),lis,Toast.LENGTH_SHORT).show();
                //TextView textView= (TextView) view.findViewById(R.layout.llistabd);


            }
        });


    }





}
