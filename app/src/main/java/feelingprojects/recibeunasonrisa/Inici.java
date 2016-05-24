package feelingprojects.recibeunasonrisa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;

import java.io.File;


public class Inici extends Activity {
    private Boolean loguejat = false;
    private Boolean session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

       /* SharedPreferences settings = getSharedPreferences("perfil", Activity.MODE_PRIVATE);
        File f = new File("/data/data/com.feeling.medsage/shared_prefs/perfil.xml");

        if (f.exists()) {
            loguejat = settings.getBoolean("login", false);
        }*/

        new CountDownTimer(1000, 1000) { //2500

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
               // if(loguejat){
                    //Intent intent = new Intent(getApplicationContext(), Desplegable_registrat.class);
                    Intent intent = new Intent(getApplicationContext(), Bienvenida.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

                    finish();
                //}else{

                  /*  Intent intent = new Intent(getApplicationContext(),registro.class); //Si NO ho esta!
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

                    finish();*/
               // }

            }
        }.start();




    }
}
