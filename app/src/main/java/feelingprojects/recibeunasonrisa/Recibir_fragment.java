package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class Recibir_fragment extends Fragment {
    private Button publicar;

    public  Recibir_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("Inicio");
        View view = inflater.inflate(R.layout. recibir_fragment,
                container, false);


        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Necesito...");

        Button button = (Button) view.findViewById(R.id.pedir);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_recibir, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button button2 = (Button)  dialogView.findViewById(R.id.registrarse);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                //set up button
                Button button = (Button)  dialogView.findViewById(R.id.registrarse);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
