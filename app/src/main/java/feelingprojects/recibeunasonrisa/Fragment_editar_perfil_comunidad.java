package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_editar_perfil_comunidad extends Fragment {
    private Button a;
    private TextView titol;


    private ImageView foto;
    private ImageView fotografia2;
    private TextView text;
    private Uri picUri;
    final int CAMERA_CAPTURE = 1;
    final int PIC_CROP = 2;
    final int GALLERY = 3;
    private int fotos = 0;
    private String imagepath = null;

    public Fragment_editar_perfil_comunidad() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getActionBar().setTitle("Mi perfil");
        View view = inflater.inflate(R.layout.fragment_editar_perfil_comunidad,
                container, false);


        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        actionBar.setCustomView(R.layout.default_layout);
        actionBar.setDisplayShowCustomEnabled(true);

        TextView titol= (TextView) getActivity().findViewById(R.id.mias);
        titol.setText("Editar perfil comunidad");


        EditText nombre = (EditText) view.findViewById(R.id.text);

        nombre.getBackground().setColorFilter(getResources().getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP);


        EditText descri = (EditText) view.findViewById(R.id.descripcion);

        descri.getBackground().setColorFilter(getResources().getColor(R.color.med),
                PorterDuff.Mode.SRC_ATOP);

        foto = (ImageView) view.findViewById(R.id.image);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fotos = 0;
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dialog_registro2, null);
                dialogBuilder.setView(dialogView);

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button button2 = (Button)  dialogView.findViewById(R.id.registrarse);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        galeria();
                    }
                });

                //set up button
                Button button = (Button)  dialogView.findViewById(R.id.image);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        camara();
                        camara();
                    }
                });

            }
        });





        Button button = (Button) view.findViewById(R.id.registrarse);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fragmentManager = getFragmentManager();

                Fragment fragment1 = null;
                fragment1 = new Fragment_perfil_comunidad();

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

            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK) {

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

                    picView.setImageBitmap(thePic);
                }


            } else if (requestCode == GALLERY) {
                picUri = data.getData();
                performCrop();
            }
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
            //text.setVisibility(View.VISIBLE);

        } catch (ActivityNotFoundException anfe) {
            // display an error message
        }
    }




}
