package com.example.achuth.universalcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        FrameLayout mainframe;
        BottomNavigationView bm;
    private SimpleFragment simple;
    private ScientificFragment scientific;
    private CurrencyFragment currency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainframe = findViewById(R.id.mainframe);
        bm= findViewById(R.id.bottom_nav);
        simple =new SimpleFragment();
        scientific =new ScientificFragment();
        currency =new CurrencyFragment();

        bm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.simple:
                    bm.setItemBackgroundResource(R.color.colorPrimary);
                    setfragement(simple);
                    return true;
                    case R.id.Scientific:
                        bm.setItemBackgroundResource(R.color.colorAccent);
                        setfragement(scientific);
                        return true;
                    case R.id.currency:
                    bm.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setfragement(currency);
                    return true;
                    default:return false;
                }

            }
        });

    }

    private void setfragement(Fragment frag) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,frag);
        fragmentTransaction.commit();

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.settings)
        {
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.help)
        {
            String url = "https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/index.en.html";
            Intent i =new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
//    public void gottosimple(View view) {
//        Intent i = new Intent(this, Simple.class);
//        /// overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
//        startActivity(i);
//        //finish();
//
//    }
//    public void gottosimple() {
//        Intent i = new Intent(this, Simple.class);
//        startActivity(i);
//
//    }

   /* public void gottoscientific(View view) {
        Intent i = new Intent(this, Scientific.class);
        startActivity(i);

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

    public void unitconv(View view) {
        Intent i = new Intent(this, Unitconv.class);
        startActivity(i);
    }*/




}
