package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import android.view.MotionEvent;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Donar_fragment extends Fragment {
    private Button publicar;

    private ImageView foto;
    private ImageView fotografia2;
    private TextView text;
    private Uri picUri;
    final int CAMERA_CAPTURE = 1;
    final int PIC_CROP = 2;
    final int GALLERY = 3;
    private int fotos = 0;
    private String imagepath = null;

    public  Donar_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("Donar");
        final View view = inflater.inflate(R.layout. donar_fragment,
                container, false);



        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Quiero donar...");

        text = (TextView) view.findViewById(R.id.text);

        EditText descripcio = (EditText) view.findViewById(R.id.descripcio);

        foto = (ImageView) view.findViewById(R.id.fotografia);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_fotos, null);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setCancelable(true);
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


        Button button = (Button) view.findViewById(R.id.pedir);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_recibir, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button cancelar = (Button)  dialogView.findViewById(R.id.cancelar);
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                //set up button
                Button button = (Button)  dialogView.findViewById(R.id.registrarse);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
                    Toast.makeText(getActivity(), "Se esta subiendo tus datos...", Toast.LENGTH_LONG).show();
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



    void camara() {
        Toast.makeText(getActivity(), "Accediendo a camara", Toast.LENGTH_SHORT).show();
        try {
            //  overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(captureIntent, CAMERA_CAPTURE);
        } catch (ActivityNotFoundException anfe) {
            //
        }

    }

    void galeria() {
        Toast.makeText(getActivity(), "Accediendo a galeria", Toast.LENGTH_SHORT).show();
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, GALLERY);//one can be replaced with any action code
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {

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


                ImageView picView = (ImageView) getView().findViewById(R.id.fotografia);
                //display the returned cropped image

               /* imagepath = getPath(picUri);
                String a = decodeFile(imagepath, 600, 600);*/

                picView.setImageBitmap(thePic);



            } else if (requestCode == GALLERY) {
                picUri = data.getData();
                performCrop();
            }
        }
    }

    /*public String getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }*/

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



}
