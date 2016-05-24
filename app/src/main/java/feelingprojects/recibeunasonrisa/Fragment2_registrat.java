package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
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

public class Fragment2_registrat extends Fragment {
    private Button a;
    private TextView titol;
    public Fragment2_registrat() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("Mi perfil");
        final View view = inflater.inflate(R.layout.fragment2_registrat,
                container, false);



        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Mi perfil");

        Button button = (Button) view.findViewById(R.id.editar);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                FragmentManager fragmentManager = getFragmentManager();

                Fragment fragment1 = null;
                fragment1 = new Fragment2_registrat_editar_perfil();

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
