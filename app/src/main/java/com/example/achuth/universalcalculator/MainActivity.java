package com.example.achuth.universalcalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
        FrameLayout mainframe;
        BottomNavigationView bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bm= findViewById(R.id.bottom_nav);
        bm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.simple:gottosimple();
                    bm.setItemBackgroundResource(R.color.colorPrimary);
                    return true;
                    case R.id.Scientific:gottoscientific();
                        bm.setItemBackgroundResource(R.color.colorAccent);
                        return true;
                    case R.id.currency:gotocurrency();
                    bm.setItemBackgroundResource(R.color.colorPrimaryDark);
                    return true;
                    default:return false;
                }

            }
        });

    }
    public void gottosimple(View view) {
        Intent i = new Intent(this, Simple.class);
        /// overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        startActivity(i);
        //finish();

    }
    public void gottosimple() {
        Intent i = new Intent(this, Simple.class);
        startActivity(i);

    }

    public void gottoscientific(View view) {
        Intent i = new Intent(this, Scientific.class);
        /// overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        startActivity(i);
        //finish();

    }
    public void gottoscientific() {
        Intent i = new Intent(this, Scientific.class);
        startActivity(i);

    }

    public void gotocurrency(View view) {
        Intent i = new Intent(this, Currency.class);
        startActivity(i);
    }

    public void gotocurrency() {
        Intent i = new Intent(this, Currency.class);
        startActivity(i);
    }







}
