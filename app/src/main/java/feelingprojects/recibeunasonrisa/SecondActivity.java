package feelingprojects.recibeunasonrisa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends Activity {

    ArrayList<HashMap<String, String>> arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.administrar_donaciones );

        arraylist = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<4; i++){
            HashMap<String, String> map = new HashMap<String, String>();

            arraylist.add(map);

        }

        ListView listView =(ListView) findViewById(R.id.listView);
        Publicaciones_detail_administrar adapters = new  Publicaciones_detail_administrar(getApplicationContext(), arraylist);
        listView.setAdapter(adapters);
    }

}