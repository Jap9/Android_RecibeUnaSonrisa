package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class Registro2 extends Activity {

    private ImageView foto;

    private Uri picUri;
    final int CAMERA_CAPTURE = 1;
    final int PIC_CROP = 2;
    final int GALLERY = 3;


    private Button finalizar;
    private  EditText text_vision;
    private String imagepath = null;
    private String status1;
    private String error;

    private String usuario = "sonrisas";
    private String pswd = "1234_y_sonrie";

    private String status;
    private String misatgeError;
    ArrayList<HashMap<String, String>> arraylist;


    private String string_nombre;
    private String string_apellidos;
    private String string_correo;
    private String string_contrasenya;
    private String string_telefono;
    private String string_vision;

    private Bundle bundle;

    private ProgressBar progressBar;
    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "RUS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        /*
        bundle = getIntent().getExtras();
        string_nombre = bundle.getString("nombre");
        string_apellidos = bundle.getString("apellidos");
        string_correo = bundle.getString("correo");
        string_contrasenya = bundle.getString("contrasenya");
        string_telefono = bundle.getString("telefono");
        string_vision = bundle.getString("vision");*/


        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setCustomView(R.layout.default_layout);
        bar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) findViewById(R.id.mias);
        titol.setText("Regístrate");

        text_vision = (EditText) findViewById(R.id.text_vision);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        finalizar = (Button) findViewById(R.id.finalizar);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        text_vision.getBackground().setColorFilter(getResources().getColor(R.color.white),
                        PorterDuff.Mode.SRC_ATOP);

                //new Insert().execute();

                Toast.makeText(getApplicationContext(), "Se esta subiendo tus datos...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Desplegable_registrat.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                finish();
            }

        });

        foto = (ImageView) findViewById(R.id.picture);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Registro2.this);
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = Registro2.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_registro2, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button button2 = (Button)  dialogView.findViewById(R.id.registrarse);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        galeria();
                        alertDialog.dismiss();
                    }
                });

                //set up button
                Button button = (Button)  dialogView.findViewById(R.id.image);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        camara();
                        alertDialog.dismiss();
                    }
                });

            }
        });

}

    void camara() {
        Toast.makeText(getApplicationContext(), "Accediendo a camara", Toast.LENGTH_SHORT).show();
        try {
            //  overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(captureIntent, CAMERA_CAPTURE);
        } catch (ActivityNotFoundException anfe) {
            //
        }

    }

    void galeria() {
        Toast.makeText(getApplicationContext(), "Accediendo a galeria", Toast.LENGTH_SHORT).show();
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, GALLERY);//one can be replaced with any action code
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            //user is returning from capturing an image using the camera

            if (requestCode == CAMERA_CAPTURE) {
                //get the Uri for the captured image
                picUri = data.getData();
                performCrop();

            } else if (requestCode == PIC_CROP) {
                //get the returned data
                Bundle extras = data.getExtras();
                //get the cropped bitmap
                Bitmap thePic = extras.getParcelable("data");
                //retrieve a reference to the ImageView

                ImageView picView = (ImageView) findViewById(R.id.picture);
                //display the returned cropped image
                imagepath = getPath(picUri);

                String a = decodeFile(imagepath, 600, 600);

                picView.setImageBitmap(thePic);

            } else if (requestCode == GALLERY) {
                picUri = data.getData();
                performCrop();
            }
        }//user is returning from cropping the image

    }

    public String getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private void performCrop() {
        try {
            // call the standard crop action intent (the user device may not support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);

        } catch (ActivityNotFoundException anfe) {
            // display an error message
        }
    }


    private String decodeFile(String path, int DESIREDWIDTH, int DESIREDHEIGHT) {
        String strMyImagePath = null;
        Bitmap scaledBitmap = null;

        try {
            // Part 1: Decode image
            Bitmap unscaledBitmap = ScalingUtilities.decodeFile(path, DESIREDWIDTH, DESIREDHEIGHT, ScalingUtilities.ScalingLogic.FIT);

            if (!(unscaledBitmap.getWidth() <= DESIREDWIDTH && unscaledBitmap.getHeight() <= DESIREDHEIGHT)) {
                // Part 2: Scale image
                scaledBitmap = ScalingUtilities.createScaledBitmap(unscaledBitmap, DESIREDWIDTH, DESIREDHEIGHT, ScalingUtilities.ScalingLogic.FIT);
            } else {
                unscaledBitmap.recycle();
                return path;
            }

            // Store to tmp file
            String extr = Environment.getExternalStorageDirectory().toString();
            File mFolder = new File(extr + "/TMMFOLDER");
            if (!mFolder.exists()) {
                mFolder.mkdir();
            }

            String s = "tmp.jpg";

            File f = new File(mFolder.getAbsolutePath(), s);

            strMyImagePath = f.getAbsolutePath();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(f);
                scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (Exception e) {

                e.printStackTrace();
            }

            scaledBitmap.recycle();
        } catch (Throwable e) {
        }

        if (strMyImagePath == null) {
            return path;
        }
        return strMyImagePath;

    }



/*
    private class InsertPic extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            //
            InputStream is = null;
            ProgressDialog dialog;

            String file = params[0];
            try {

                HttpClient httpClient = new DefaultHttpClient();
                httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
                HttpPost httpPost = new HttpPost("http://www.recibeunasonrisa.com/nit/index.php/apiSonrisas/new_user");

                MultipartEntity multipartEntity = new MultipartEntity();
                File fileToUpload = new File(file);
                ContentBody foto = new FileBody(fileToUpload, "image/jpg");
                foto.getMediaType();

                multipartEntity.addPart("userfile", foto);
                httpPost.setEntity(multipartEntity);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error --->" + e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (status1.equals("1")) {
                finalizar.setVisibility(View.VISIBLE);//Si la foto és pujada correctament
            } else {
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
            }

        }
    }

    private class Insert extends AsyncTask<String, String, String> {

    protected String doInBackground(String... param){
        arraylist = new ArrayList<HashMap<String,String>>();

        string_vision = text_vision.getText().toString();

        JSONObject jsonObject = JSONFUNCTIONS.setAlta("http://www.recibeunasonrisa.com/nit/index.php/apiSonrisas/new_user",
                usuario, pswd, string_nombre + " " + string_apellidos, string_correo, string_contrasenya, string_telefono,
                string_vision);

        try {
            status = jsonObject.getString("status");
            misatgeError = jsonObject.getString("mensaje");

        } catch (JSONException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            if (status.equals("1")) {
                Toast.makeText(getApplicationContext(), "tot Ok", Toast.LENGTH_SHORT).show();
                Registro2.this.finish();
                 Intent intent = new Intent(getApplicationContext(), Desplegable_registrat.class);
                 startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), misatgeError, Toast.LENGTH_SHORT).show();
            }

        }

    }

*/

}
