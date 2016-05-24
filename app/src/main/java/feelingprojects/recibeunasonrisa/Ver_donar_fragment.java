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
import android.widget.ImageView;
import android.widget.TextView;

public class Ver_donar_fragment extends Fragment {
    private Button a;
    private Button pedir;
    private ImageView foto;
    boolean isImageFitToScreen;

    public Ver_donar_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("Dono");
        View view = inflater.inflate(R.layout.ver_donar_fragment,
                container, false);



        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Donacion");

        foto = (ImageView) view.findViewById(R.id.fotografia);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Imatge_ampliada.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });



        Button button = (Button) view.findViewById(R.id.pedir);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_aceptar_donacion, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button aceptar = (Button) dialogView.findViewById(R.id.registrarse);
                aceptar.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v){
                        alertDialog.dismiss();
                    }

                });

                Button cancelar = (Button) dialogView.findViewById(R.id.registrarse);
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
