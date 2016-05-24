package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment_perfil_comunidad extends Fragment {

    ArrayList<HashMap<String, String>> arraylist;

    public Fragment_perfil_comunidad() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Perfil comunidad");

        View view = inflater.inflate(R.layout.fragment_perfil_comunidad,
                container, false);

        Button salir = (Button) view.findViewById(R.id.salirr);
        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_salir_comunidad, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button cancelarr = (Button) dialogView.findViewById(R.id.registrarse);
                cancelarr.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v){
                        alertDialog.dismiss();
                    }

                });

                Button salirr = (Button) dialogView.findViewById(R.id.salirr);
                salirr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }

                });

            }
        });





        Button ver = (Button) view.findViewById(R.id.ver);
        ver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

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
                    transaction.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction.replace(R.id.content_frame, fragment1);
                    //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth >= 700 &&  screenWidth<= 800){
                    transaction.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction.replace(R.id.content_frame, fragment1);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction.replace(R.id.content_frame, fragment1);
                }
                transaction.commit();
            }

        });

        Button administrar = (Button) view.findViewById(R.id.admin);
        administrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_administrar_comunidad, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button administrar = (Button) dialogView.findViewById(R.id.registrarse);
                administrar.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v){

                        Intent intent = new Intent(getActivity(), Fragment7_registrat.class);
                        startActivity(intent);
                        alertDialog.dismiss();

                    }

                });

                Button editar = (Button) dialogView.findViewById(R.id.editar);
                editar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fragmentManager = getFragmentManager();

                        Fragment fragment1 = null;
                        fragment1 = new Fragment_editar_perfil_comunidad();

                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Display display = ((Activity) getActivity()).getWindowManager ().getDefaultDisplay ();
                        Point size = new Point ();
                        display.getSize (size);
                        int screenWidth = size.x;
                        int screenHeight = size.y;

                        if(screenWidth>= 1000 && screenWidth <= 1200){
                            transaction.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                            transaction.replace(R.id.content_frame, fragment1);
                            //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                        }else if(screenWidth >= 700 &&  screenWidth<= 800){
                            transaction.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                            transaction.replace(R.id.content_frame, fragment1);
                            //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                        }else{
                            transaction.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                            transaction.replace(R.id.content_frame, fragment1);
                        }
                        transaction.commit();
                        alertDialog.dismiss();
                    }

                });

            }
        });




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
