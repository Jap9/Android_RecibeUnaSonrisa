package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
public class Desplegable extends Activity {
    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;
    static final int DRAWER_DELAY = 1500;
    private boolean primer_cop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegable);


        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF3391C5")));

        menu = new String[]{"Inicio","Mi perfil","Mis comunidades","Comunidades cercanas","Ajustes"};

        selectItem(0);
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

    private Runnable openDrawerRunnable() {
        return new Runnable() {

            @Override
            public void run() {
                dLayout.openDrawer(Gravity.LEFT);
            }
        };
    }


    @Override
    public void onBackPressed() {
        final AlertDialog alertDialog = new AlertDialog.Builder(Desplegable.this).create();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Desplegable.this);
        LayoutInflater inflater = Desplegable.this.getLayoutInflater();
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





    void aviso(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Desplegable.this);

        LayoutInflater inflater = Desplegable.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.acitivity_dialog_accion_registrado, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialog2 = dialogBuilder.create();
        alertDialog2.show();

        Button cancelarr = (Button) dialogView.findViewById(R.id.registrarse);
        cancelarr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Registro1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
                alertDialog2.dismiss();

            }

        });

        Button salirr = (Button) dialogView.findViewById(R.id.cancelar);
        salirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.dismiss();

            }

        });

    }


    private void selectItem(int position) {

            Fragment fragment = null;

            switch (position) {
                case 0://INICIO
                    fragment = new Fragment0();
                    break;
                case 1://MI PERFIL
                    aviso ();
                    break;
                case 2://Mis comunidades
                    aviso ();
                    break;
                case 3://Cercanas
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
                case 4://Ajustes
                    //fragment = new DetailFragment();
                    aviso ();
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