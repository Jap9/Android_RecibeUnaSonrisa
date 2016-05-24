package feelingprojects.recibeunasonrisa;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment0 extends Fragment {
    private ImageView des;
    private Button crear;
    private Boolean ciutat_existeix = false;
    private Button obrir;
    private Boolean obert = false;

    ArrayList<HashMap<String, String>> arraylist;
    ArrayList<HashMap<String, String>> arraylist2;
    public Fragment0() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("TimeLine");

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setCustomView(R.layout.search_layout);

        AutoCompleteTextView search = (AutoCompleteTextView) actionBar.getCustomView().findViewById(R.id.autoCompleteTextView);

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        search.getBackground().setColorFilter(getResources().getColor(R.color.med),
                PorterDuff.Mode.SRC_ATOP);

        final View view = inflater.inflate(R.layout.fragment0,container, false);



        Button button = (Button) view.findViewById(R.id.crear);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){


                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_timeline, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button button2 = (Button)  dialogView.findViewById(R.id.registrarse);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getFragmentManager();

                        Fragment fragment1 = null;
                        fragment1 = new Donar_fragment();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();

                        int screenWidth = getActivity().getResources().getDisplayMetrics().widthPixels;

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

                Button button = (Button)  dialogView.findViewById(R.id.recibir);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getFragmentManager();

                        Fragment fragment1 = null;
                        fragment1 = new Recibir_fragment();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();

                        int screenWidth = getActivity().getResources().getDisplayMetrics().widthPixels;

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


        Button button2 = (Button) view.findViewById(R.id.a);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fragmentManager = getFragmentManager();

                Fragment fragment1 = null;
                fragment1 = new Ver_donar_fragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int screenWidth = getActivity().getResources().getDisplayMetrics().widthPixels;

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

        Button button3 = (Button) view.findViewById(R.id.b);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fragmentManager = getFragmentManager();

                Fragment fragment1 = null;
                fragment1 = new Ver_pedir_fragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int screenWidth = getActivity().getResources().getDisplayMetrics().widthPixels;

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

        Button ver = (Button) view.findViewById(R.id.ver);
        ver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment1 = null;
                fragment1 = new Fragment_perfil_comunidad();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int screenWidth = getActivity().getResources().getDisplayMetrics().widthPixels;

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



        arraylist = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<3; i++){
            HashMap<String, String> map = new HashMap<String, String>();

            arraylist.add(map);

        }

        ListView listView =(ListView)view.findViewById(R.id.publicaciones);
        Publicaciones_detail adapters = new Publicaciones_detail(getActivity(), arraylist);
        listView.setAdapter(adapters);



        return view;
    }


}
