package com.example.achuth.universalcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {
    public boolean  themedark=false,themelight=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(themedark && !themelight)
            setTheme(R.style.ThemeOverlay_AppCompat_Dark);
       else if(themelight&& !themedark)
            setTheme(R.style.Theme_AppCompat);

        setContentView(R.layout.activity_settings);
    }

public void changer(View view)
{
    themelight=true;
    themedark=false;
    Log.i("theme dark   here"," "+ themedark);
    Log.i("theme light here", " "+ themelight);
    Settings.this.recreate();

}

    public void gotblack(View view) {
        themedark=true;
        themelight=false;
        Log.i("theme dark   here"," "+ themedark);
        Log.i("theme light here", " "+ themelight);
        Settings.this.recreate();
    }
}
