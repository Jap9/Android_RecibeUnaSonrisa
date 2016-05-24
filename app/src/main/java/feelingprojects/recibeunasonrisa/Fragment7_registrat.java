package feelingprojects.recibeunasonrisa;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.text.Html;
import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment7_registrat extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setCustomView(R.layout.default_layout);
        bar.setDisplayShowCustomEnabled(true);


       TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("first").setIndicator("Usuarios").setContent(new Intent(this, FirstActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("second").setIndicator("Donaciones").setContent(new Intent(this , SecondActivity.class )));
        mTabHost.setCurrentTab(0);



    }



/*
    public static void setTabColor(TabHost mTabHost) {
        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) {
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#ffd2fff8")); //unselected
        }
        mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#ffb7dfd8")); // selected
    }*/


}
