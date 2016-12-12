package com.example.matiasmsi.cdc_construccion;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matiasmsi on 11/12/2016.
 */

public class ListaTarea extends AppCompatActivity{
    private Cursor cursor;
    private ConectionBDManager manager;
    private ListView lista;
    SimpleCursorAdapter adapter;
    ArrayList<String>list;
    ArrayAdapter adapterarray;



    protected void onCreate(Bundle savedInstanceState) {

        Log.d("text","Text1 ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llistabd);

       manager = new ConectionBDManager(this);
        lista = (ListView) findViewById(R.id.listbd);
        final String[] from = new String[]{manager.CN_SECTOR,manager.CN_FORMULARIO};
        int[]to = new int []{android.R.id.text1,android.R.id.text2};
        cursor = manager.cargarDatosTareas();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
       //SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_expandable_list_item_1,);
         adapter.notifyDataSetChanged();

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

              // String valorid =  adapterView.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), Formulario.class);
                startActivity(intent);
               // intent.putExtra("idTarea",valorid);



            }
        });


    }





}
