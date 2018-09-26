package com.example.achuth.universalcalculator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Currency extends AppCompatActivity implements OnItemSelectedListener{
    ProgressBar progressBar;
    TextView responseView;
    List<String> curr = new ArrayList<String>();
    List <String> list=new ArrayList<>();
    String line=" ";
    String name;
    static final String API_URL =" https://frankfurter.app/latest";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        responseView = findViewById(R.id.responseView);
        progressBar = findViewById(R.id.progressBar);

        Spinner spin = findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);
        rettask r=new rettask();
        r.execute();
        ArrayAdapter<String> currAdapter =new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        currAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(currAdapter);

    }

    public void execute (View view)
    {
        rettask r=new rettask();
        r.execute();

        }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class rettask extends AsyncTask<Void,Void ,String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(API_URL );
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    bufferedReader.close();
                    line=stringBuilder.toString();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }
        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
           //responseView.setText(response);
            try {

                JSONObject object = (JSONObject) new JSONTokener(line).nextValue();
                String base = object.getString("rates");
                String[] temp = base.split(",");

                Spinner spin=findViewById(R.id.spinner1);
                spin.setVisibility(View.VISIBLE);
                curr = Arrays.asList(temp);
                for (int i = 0; i < curr.size(); i++) {
                    String s=curr.get(i);
                    if(i==0)
                        s=s.substring(2,5);
                    else
                        s=s.substring(1,4);
                    curr.set(i,s);
                    System.out.println(curr.get(i));
                    list.add(curr.get(i));

                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}