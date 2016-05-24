package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Desplegable_registrat extends Activity {
    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;
    static final int DRAWER_DELAY = 1500;
    private boolean primer_cop = true;
    private ImageButton obrir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegable_registrat);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF3391C5")));


        int screenWidth = getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        int height = getApplicationContext().getResources().getDisplayMetrics().heightPixels;

        selectItem(0);
        menu = new String[]{"Inicio","Mi perfil","Publicaciones","Mis comunidades","Comunidades cercanas","Ajustes"};

        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);
        adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,menu);
        dList.setAdapter(adapter);

        dList.setSelector(R.color.blau);
        if(primer_cop == true){
            primer_cop = false;
            new Handler().postDelayed(openDrawerRunnable(), DRAWER_DELAY);
        }
        dList.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                dLayout.closeDrawers();
                Bundle args = new Bundle();
                args.putString("Menu", menu[position]);
                Fragment detail = new DetailFragment();
                detail.setArguments(args);

                selectItem(position);

            }
        });

    }

    public Runnable openDrawerRunnable() {
        return new Runnable() {

            @Override
            public void run() {
                dLayout.openDrawer(Gravity.LEFT);
            }
        };
    }

    @Override
    public void onBackPressed() {

       final AlertDialog alertDialog = new AlertDialog.Builder(Desplegable_registrat.this).create();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Desplegable_registrat.this);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = Desplegable_registrat.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_dialog_salir, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialog2 = dialogBuilder.create();
        alertDialog2.show();

        Button cancelarr = (Button) dialogView.findViewById(R.id.registrarse);
        cancelarr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                alertDialog2.dismiss();
            }

        });

        Button salirr = (Button) dialogView.findViewById(R.id.salir);
        salirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.dismiss();
                finish();
            }

        });

    }






private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0://INICIO
                FragmentManager fragmentManager0 = getFragmentManager();

                Fragment fragment0 = null;
                fragment0 = new Fragment0();

                FragmentTransaction transaction0 = fragmentManager0.beginTransaction();

                int screenWidth0 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

                if(screenWidth0>= 1000 && screenWidth0 <= 1200){
                    transaction0.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction0.replace(R.id.content_frame, fragment0);
                    //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth0 >= 700 &&  screenWidth0<= 800){
                    transaction0.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction0.replace(R.id.content_frame, fragment0);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction0.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction0.replace(R.id.content_frame, fragment0);
                }
                transaction0.commit();
                break;
            case 1://MI PERFIL
                FragmentManager fragmentManager = getFragmentManager();

                Fragment fragment1 = null;
                fragment1 = new Fragment2_registrat();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                int screenWidth = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

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

                break;
            case 2://PUBLICACIONES
                FragmentManager fragmentManager3 = getFragmentManager();

                Fragment fragment3 = null;
                fragment3 = new Fragment3_registrat();

                FragmentTransaction transaction3 = fragmentManager3.beginTransaction();
                int screenWidth3 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

                if(screenWidth3>= 1000 && screenWidth3 <= 1200){
                    transaction3.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction3.replace(R.id.content_frame, fragment3);
                    //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth3 >= 700 &&  screenWidth3<= 800){
                    transaction3.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction3.replace(R.id.content_frame, fragment3);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction3.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction3.replace(R.id.content_frame, fragment3);
                }
                transaction3.commit();
                break;
            case 3://Mis comunidades
                FragmentManager fragmentManager4 = getFragmentManager();

                Fragment fragment4 = null;
                fragment4 = new Fragment4_registrat();

                FragmentTransaction transaction4 = fragmentManager4.beginTransaction();

                int screenWidth4 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

                if(screenWidth4>= 1000 && screenWidth4 <= 1200){
                    transaction4.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction4.replace(R.id.content_frame, fragment4);
                    //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth4 >= 700 &&  screenWidth4<= 800){
                    transaction4.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction4.replace(R.id.content_frame, fragment4);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction4.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction4.replace(R.id.content_frame, fragment4);
                }
                transaction4.commit();
                break;
            case 4://Cercanas
                FragmentManager fragmentManager5 = getFragmentManager();

                Fragment fragment5 = null;
                fragment5 = new Fragment5_registrat();

                FragmentTransaction transaction5 = fragmentManager5.beginTransaction();

                int screenWidth5 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

                if(screenWidth5>= 1000 && screenWidth5 <= 1200){
                    transaction5.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction5.replace(R.id.content_frame, fragment5);
                    //Toast.makeText(getActivity(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth5 >= 700 &&  screenWidth5<= 800){
                    transaction5.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction5.replace(R.id.content_frame, fragment5);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction5.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction5.replace(R.id.content_frame, fragment5);
                }
                transaction5.commit();
                break;
            case 5:
                //fragment = new Fragment6_registrat();
                /*FragmentManager fragmentManager6 = getFragmentManager();

                Fragment fragment6 = null;
                fragment6 = new Fragment_perfil_comunidad();

                FragmentTransaction transaction6 = fragmentManager6.beginTransaction();

                int screenWidth6 = getApplicationContext().getResources().getDisplayMetrics().widthPixels;

                if(screenWidth6>= 1000 && screenWidth6 <= 1200){
                    transaction6.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction6.replace(R.id.content_frame, fragment6);
                    //Toast.makeText(getApplicationContext(), "FHD", Toast.LENGTH_LONG).show();
                }else if(screenWidth6 >= 700 &&  screenWidth6<= 800){
                    transaction6.setCustomAnimations(R.animator.push_left_in2, R.animator.push_left_out2);
                    transaction6.replace(R.id.content_frame, fragment6);
                    //Toast.makeText(getActivity(), "HD", Toast.LENGTH_LONG).show();
                }else{
                    transaction6.setCustomAnimations(R.animator.push_left_in, R.animator.push_left_out);
                    transaction6.replace(R.id.content_frame, fragment6);
                }
                transaction6.commit();*/
                Toast.makeText(getApplicationContext(), "No disponible..", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragment).commit();

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }


    }
}