package com.example.achuth.universalcalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
        setfragement(simple);
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

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        //frag newCustomFragment = frag.newInstance();
        transaction.replace(R.id.mainframe, frag );
        transaction.addToBackStack(null);
        transaction.commit();*/
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(item.getItemId()==R.id.settings)
        {
            Intent i =new Intent(this,Settings.class);
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
            startActivity(i);
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



}
