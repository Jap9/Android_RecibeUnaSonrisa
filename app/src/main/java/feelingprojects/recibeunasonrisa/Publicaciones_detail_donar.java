package feelingprojects.recibeunasonrisa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

public class Publicaciones_detail_donar extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    //ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public Publicaciones_detail_donar(Context context,ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        //imageLoader = new ImageLoader(context);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView picture;
        TextView nombre;
        TextView cognom;
        TextView descripcio;

        LinearLayout state;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View itemview = inflater.inflate(R.layout.adapter_donacion, parent, false);

        resultp = data.get(position);
        /*final ImageButton imageButton = (ImageButton) view.findViewById(R.id.fav);
        imageButton.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    imageButton.setImageResource(R.drawable.star);

                }
                if(event.getAction() == MotionEvent.ACTION_UP ) {
                    imageButton.setImageResource(R.drawable.startocada);

                }

                return false;
            }
        });*/


        //picture = (ImageView)itemview.findViewById(R.id.foto_perfil);
        nombre = (TextView)itemview.findViewById(R.id.contact);
        cognom = (TextView)itemview.findViewById(R.id.nom);
        descripcio = (TextView)itemview.findViewById(R.id.descripcio);


        nombre.setText("Nombre y Apellidos");
        descripcio.setText("DESCRIPCIO");

        return itemview;

    }
}