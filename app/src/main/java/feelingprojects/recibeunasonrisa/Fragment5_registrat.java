package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationManager;
import android.os.Bundle;

import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public  class Fragment5_registrat extends Fragment {
    private Button a;
    ArrayList<HashMap<String, String>> arraylist;
    LocationManager locationManager ;
    String provider;

    public Fragment5_registrat() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       /* if(getGpsStatus( )== true){
            Toast.makeText(getActivity(), "ACTIVADO", Toast.LENGTH_LONG).show();
        }else{
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setTitle("Configuracion localización");
            alertDialog.setMessage(R.string.dialog10);

            alertDialog.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //
                }
            });
            alertDialog.setNegativeButton("Activar ubicacion", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            });

            alertDialog.show();
        }
*/

        final GeoLocation loc = new GeoLocation(getActivity());

        Toast.makeText(getActivity(),
                "Latitud: "+loc.getLatitude()+" "+"Longitud: "+loc.getLongitude(), Toast.LENGTH_SHORT).show();

        Toast.makeText(getActivity(),
                "Direccion: "+ loc.getAddress(loc.getLatitude(),loc.getLongitude()), Toast.LENGTH_SHORT).show();


            if(loc.getLatitude() != 0.0) {
                        //Toast.makeText(getActivity(), "Latitud: "+loc.getLatitude()+"Longitud: "+loc.getLongitude(), Toast.LENGTH_SHORT).show();
               loc.stopUsingGPS();
            }else{
                //
            }


        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Comunidades cercanas");


        View view = inflater.inflate(R.layout.fragment5_registrat,
                container, false);

        arraylist = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<4; i++){
            HashMap<String, String> map = new HashMap<String, String>();

            arraylist.add(map);

        }

        ListView listView =(ListView)view.findViewById(R.id.listView);
        Publicacion_detail_mis_comunidades adapter = new Publicacion_detail_mis_comunidades(getActivity(), arraylist);
        listView.setAdapter(adapter);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK) {

                    FragmentManager fragmentManager = getFragmentManager();

                    Fragment fragment1 = null;
                    fragment1 = new Fragment0();

                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    Display display = ((Activity) getActivity()).getWindowManager ().getDefaultDisplay ();
                    Point size = new Point ();
                    display.getSize (size);
                    int screenWidth = size.x;
                    int screenHeight = size.y;

                    if(screenWidth>= 1000 && screenWidth <= 1200){
                        transaction.setCustomAnimations(R.animator.tornar, R.animator.tornar2);
                        transaction.replace(R.id.content_frame, fragment1);
                        //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                    }else if(screenWidth >= 700 &&  screenWidth<= 800){
                        transaction.setCustomAnimations(R.animator.tornar_lent, R.animator.tornar2_lent);
                        transaction.replace(R.id.content_frame, fragment1);
                        //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                    }else{
                        transaction.setCustomAnimations(R.animator.tornar, R.animator.tornar2);
                        transaction.replace(R.id.content_frame, fragment1);
                    }
                    transaction.commit();

                    return true;
                } else {
                    return false;
                }
            }
        });

        return view;
    }

}
