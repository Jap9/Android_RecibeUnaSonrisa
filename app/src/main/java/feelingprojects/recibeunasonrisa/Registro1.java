package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;


public class Registro1 extends Activity {
    private Button continuar;

    //String per enviar
    private String string_nombre;
    private String string_apellidos;
    private String string_correo;
    private String string_contrasenya;
    private String string_contrasenya2;
    private String string_telefono;
    private String string_vision = "aaa";


    private String usuario ="sonrisas";
    private String pswd = "1234_y_sonrie";

    private String string_apellidos1;
    private String string_apellidos2;

    //Inicialitzar dades interficie ANDROID
    private EditText text_nombre;
    private EditText text_apellidos;
    private EditText text_correo;
    private EditText text_contrasenya;
    private EditText text_telefono;
    //private EditText text_vision;

    private String status;
    private String misatgeError;
    ArrayList<HashMap<String, String>> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setCustomView(R.layout.default_layout);
        bar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) findViewById(R.id.mias);
        titol.setText("Regístrate");


        text_nombre = (EditText) findViewById(R.id.text);
        text_apellidos = (EditText) findViewById(R.id.apellidos);
        text_correo = (EditText) findViewById(R.id.usuarios);
        text_contrasenya = (EditText) findViewById(R.id.contrasenya);
        text_telefono = (EditText) findViewById(R.id.telefono);

        text_nombre.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);

        text_apellidos.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);

        text_correo.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);

        text_contrasenya.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);

        text_telefono.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);

        Button continuar = (Button)findViewById(R.id.registrarse);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                string_nombre = text_nombre.getText().toString();
                string_apellidos = text_apellidos.getText().toString();
                string_correo = text_correo.getText().toString();
                string_contrasenya = text_contrasenya.getText().toString();
                string_telefono = text_telefono.getText().toString();

                try {
                    String cog[] = string_apellidos.split(" ");
                    string_apellidos1 = cog[0];
                    string_apellidos2 = cog[1];
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "No has introducido tu segundo apellido", Toast.LENGTH_SHORT);
                }

                if(string_nombre.matches("") || string_apellidos.matches("") || string_correo.matches("") || string_contrasenya.matches("") || string_telefono.matches("") ) {
                    Toast.makeText(getApplicationContext(), "Debes completar todos los campos", Toast.LENGTH_LONG).show();
                    if(string_nombre.matches("")){
                        text_nombre.setHintTextColor(getResources().getColor(R.color.vermell));
                    }

                    if(string_apellidos.matches("")){
                        text_apellidos.setHintTextColor(getResources().getColor(R.color.vermell));
                    }

                    if(string_correo.matches("")){
                        text_correo.setHintTextColor(getResources().getColor(R.color.vermell));
                    }

                    if(string_contrasenya.matches("")){
                        text_contrasenya.setHintTextColor(getResources().getColor(R.color.vermell));
                    }

                    if(string_telefono.matches("")){
                        text_telefono.setHintTextColor(getResources().getColor(R.color.vermell));
                    }

                }else{
                    Intent intent = new Intent(getApplicationContext(), Registro2.class);
                    //Intent intent = new Intent(getApplicationContext(), Desplegable_registrat.class);
                    startActivity(intent);
                   /* overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                    intent.putExtra("nombre", string_nombre);
                    intent.putExtra("apellidos", string_apellidos);
                    intent.putExtra("correo", string_correo);
                    intent.putExtra("contrasenya", string_contrasenya);
                    intent.putExtra("telefono", string_telefono);
                    intent.putExtra("vision", string_vision);
                    startActivity(intent);*/
                    finish();
                }

            }
        });

    }
}
