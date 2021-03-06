package com.example.prog2.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
///

    //cogemos el listView de la activity main
    private ListView listView;
    private List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//lo casteamos
        listView = findViewById(R.id.listView);

//datos a mostrar
        nombres = new ArrayList<String>();

        nombres.add("Juan");
        nombres.add("Manolo");
        nombres.add("Ana");
        nombres.add("Pepito");
        nombres.add("Juan");
        nombres.add("Manolo");
        nombres.add("Ana");
        nombres.add("Pepito");
        nombres.add("Juan");
        nombres.add("Manolo");
        nombres.add("Ana");
        nombres.add("Pepito");
        nombres.add("Juan");
        nombres.add("Manolo");
        nombres.add("Ana");
        nombres.add("Pepito");

        // ASI al hacer click en cada elemento hara algo: en este caso un TOAST
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked: "+nombres.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        //AQUI enlazamos con nuesro adaptador personalizado con nuestra clase MyAdapter
        //le damos AL ADAPTADOR el contexto(this), el layout que tenemos que ENLAZAR(list_item que hemos creado) y por ultimo
        // los datos en este caso arraylist nombres.

        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,nombres);
        listView.setAdapter(myAdapter);

    }
}


