package com.example.achuth.universalcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gottosimple(View view) {
        Intent i=new Intent(this,Simple.class);
       /// overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        startActivity(i);
        //finish();

    }
    public void gottoscientific(View view) {
        Intent i=new Intent(this,Scientific.class);
        /// overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        startActivity(i);
        //finish();

    }
}
