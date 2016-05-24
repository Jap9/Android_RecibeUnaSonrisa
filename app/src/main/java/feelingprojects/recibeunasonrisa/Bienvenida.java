package feelingprojects.recibeunasonrisa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class Bienvenida extends Activity {
    private Button confirmar;
    private Boolean ciutat_existeix = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        final AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(ciutat_existeix(s.toString()) == true ){
                    InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

        });

        if(getNetworkStatus()== true){
            //Toast.makeText(getApplicationContext(), "ACTIVADO", Toast.LENGTH_LONG).show();
        }else{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Bienvenida.this);
// ...Irrelevant code for customizing the buttons and title
            LayoutInflater inflater = Bienvenida.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.activity_dialog_wifi, null);
            dialogBuilder.setView(dialogView);

            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();

            Button activar = (Button)  dialogView.findViewById(R.id.registrarse);
            activar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    alertDialog.dismiss();
                }
            });

            //set up button
            Button cancelar = (Button)  dialogView.findViewById(R.id.cancelar);
            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

        }


        Button confirmar = (Button) findViewById(R.id.confirmar);
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(this, dialogo1.class);
                //  startActivity(intent);

                if (ciutat_existeix(textView.getText().toString()) == true) {


                    if (getNetworkStatus() == true) {


                        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Bienvenida.this);
// ...Irrelevant code for customizing the buttons and title
                        LayoutInflater inflater = Bienvenida.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.activity_dialog_bienvenido, null);
                        dialogBuilder.setView(dialogView);

                        final AlertDialog alertDialog = dialogBuilder.create();
                        alertDialog.show();

                        Button registrarse = (Button) dialogView.findViewById(R.id.registrarse);
                        registrarse.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bienvenida.this.finish();
                                Intent intent = new Intent(getApplicationContext(), Registro1.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                                alertDialog.dismiss();
                            }
                        });

                        //set up button
                        Button invitado = (Button) dialogView.findViewById(R.id.invitado);
                        invitado.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bienvenida.this.finish();
                                Intent intent = new Intent(getApplicationContext(), Desplegable.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                                alertDialog.dismiss();
                            }
                        });



                } else {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Bienvenida.this);
// ...Irrelevant code for customizing the buttons and title
                    LayoutInflater inflater = Bienvenida.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.activity_dialog_wifi, null);
                    dialogBuilder.setView(dialogView);

                    final AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();

                    Button activar = (Button) dialogView.findViewById(R.id.registrarse);
                    activar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                            alertDialog.dismiss();
                        }
                    });

                    //set up button
                    Button cancelar = (Button) dialogView.findViewById(R.id.cancelar);
                    cancelar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                            alertDialog.dismiss();
                        }
                    });

                }

            } else {
                Toast.makeText(getApplicationContext(), "La ciudad no es válida, comprueba que esté bien escrita.", Toast.LENGTH_LONG).show();
            }


            }
        });

}
    private Boolean getNetworkStatus() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }


    boolean ciutat_existeix(String ciutat){
        boolean aux = false;
        for(int i = 0; i< COUNTRIES.length ;i++){
            if(ciutat.matches(COUNTRIES[i])){
                aux = true;
            }
        }

        return aux;
    }
    private static final String[] COUNTRIES = new String[]{
            "Lleida", "Barcelona", "Tarragona", "Girona"
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bienvenida, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

