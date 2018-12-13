package com.example.prog2.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//ESTE sera el adaptador CLAVE ya que coje el layout creado personalizado (layout list item)
//y lo MEZCLA con los datos (en este caso los datos vienen de un array pero puede ser por una BBDD x ej.)
// hay que extenderlo de BaseAdapter para coger sus metodos.

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
    //METODO CLAVE QUE MEZCLA TODO
    //coge cada elemento y se dibuja
    public View getView(int position, View convertView, ViewGroup parent) {

        //ViewHolder Pattern---> mejora la productividad--> de esta manera no tiene que cargar
        // constantemente el findviewBYid (solo la primera vez)

// hacemos una instancia de la clase (esta abajo del todo)
        ViewHolder holder;
// si es null (q nunca ha salido en la app lo carga y lo guarda en holder.nameTextView)
        if(convertView== null){

            //inflamos la vista personalizada que nos ha llegado

            //IMPORTANTE aqui es donde el adaptador infla el layout que hemos hecho antes (list_item) que nos servirá
            // de plantilla para rellenar de datos.
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            //hacemos el findView de la view que hemos inflado
            holder.nameTextView =convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //ya esta inflado y ahora lo rellenamos connuestros datos dependiendo de la posicion
        String currentName = nombres.get(position);

        //ahora cargamos a ese textView el texto
        holder.nameTextView.setText(currentName);

        //devolvemos la vista inflada y modificada con nuetsros datos
        return convertView;

    }

    static class ViewHolder{

//tendriamos tantos elementos como elementos de la UI quisieramos modificar.

        private TextView nameTextView;

    }
}
