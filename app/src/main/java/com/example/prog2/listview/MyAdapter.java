package com.example.prog2.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//este sera el adaptador que coja el lyout creado personalizado y lo enchiche (layout list item)
// hayq ue extenderlo de BaseAdapter para coger sus metods.

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;

    public MyAdapter(Context context, int layout, List<String> nombres){
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }


    @Override
    //cuantas veces vamos a iterar sobre una coleccion que le vamos a dar
    //asi que le damos para que devuelva el total de elementos con el size del array
    public int getCount() {return this.nombres.size();}

    @Override
    //obtener un item de esa coleccion segun la posicion que le pasemos(con el parametro position)
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override
    //obtener el id de un item de esa coleccion
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //coge cada elemento y se dibuja
    public View getView(int position, View convertView, ViewGroup parent) {

        //IMPORTANTE aqui es donde el adaptador infla el layout que hemos hecho antes (list_item) que nos servirá
        // de plantilla para rellenar de datos.

        //aqui copiamos la vista
        View v =  convertView;

        //inflamos la vista personalizada que nos ha llegado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v=layoutInflater.inflate(R.layout.list_item, null);

        //ya esta inflado y ahora lo rellenamos connuestros datos dependiendo de la posicion
        String currentName = nombres.get(position);


        //hacemos el findView de la view que hemos inflado(v)
        TextView textView = v.findViewById(R.id.textView);
        //ahora cargamos a ese textView el texto
        textView.setText(currentName);

        //devolvemos la vista inflada y modificada con nuetsros datos
        return v;

    }
}
