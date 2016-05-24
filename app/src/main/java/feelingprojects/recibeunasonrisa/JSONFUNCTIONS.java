package feelingprojects.recibeunasonrisa;


import android.util.Base64;
import android.util.Log;
import android.widget.Toast;


import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;

import org.apache.http.StatusLine;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.HttpClient;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.client.utils.URLEncodedUtils;

import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.impl.conn.DefaultClientConnection;

import org.apache.http.message.BasicNameValuePair;

import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;



import java.io.BufferedReader;

import java.io.File;
import java.io.InputStream;

import java.io.InputStreamReader;

import java.lang.reflect.Array;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import java.util.List;



/**

 * Created by Xavier on 13/08/2014.

 */

public class JSONFUNCTIONS {

    public static JSONObject setAlta(String url,String usuario, String pswd, String nombre/*, String apellidos*/, String email, String contrasenya,
                                     String telefono, String vision){

        InputStream is = null;
        JSONObject jsonObject = null;
        String json = "";

        try{

            List<NameValuePair> params = new ArrayList<NameValuePair>(2);

            /*params.add(new BasicNameValuePair("Usuario",usuario));

            params.add(new BasicNameValuePair("pswd",pswd));
            */

            params.add(new BasicNameValuePair("nombre",nombre));

            params.add(new BasicNameValuePair("mail",email));

            params.add(new BasicNameValuePair("password",contrasenya));

            params.add(new BasicNameValuePair("telefono",telefono));

            params.add(new BasicNameValuePair("vision",vision));


            DefaultHttpClient httpClient = new DefaultHttpClient();
            String parametre = URLEncodedUtils.format(params, "utf-8");
            url += "?" + parametre;

            HttpPost httpPost = new HttpPost(url);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        }catch (Exception e){
            e.printStackTrace();
        }

        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }

            is.close();
            json = sb.toString();

        }catch (Exception e){
            Log.e("Error", e.toString());
        }


        try{
            jsonObject = new JSONObject(json);
        }catch (JSONException e){
            Log.e("Error", e.toString());
        }
        return jsonObject;

    }

}

