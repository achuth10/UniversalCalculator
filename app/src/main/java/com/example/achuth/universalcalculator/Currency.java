package com.example.achuth.universalcalculator;

import android.graphics.Color;
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
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Currency extends AppCompatActivity implements OnItemSelectedListener {
    String result,name,dateholder,amt;
    EditText edit1;
    ProgressBar progressBar;
    TextView responseView,date;
    String conv="";
    String conv1="";
    List<String> currval = new ArrayList<String>();
    static final String API_URL = " https://frankfurter.app/latest";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        responseView = findViewById(R.id.result);
        date= findViewById(R.id.date);
        progressBar = findViewById(R.id.progressBar);
        edit1= findViewById(R.id.edit);
        Spinner spin = findViewById(R.id.spinner1);
        Spinner spin1 = findViewById(R.id.spinner2);
        spin.setOnItemSelectedListener(this);
        spin1.setOnItemSelectedListener(this);
        currval.add("AUD");
        currval.add("BGN");
        currval.add("CAD");
        currval.add("CHF");
        currval.add("CNY");
        currval.add("CZK");
        currval.add("DKK");
        currval.add("GBP");
        currval.add("HKD");
        currval.add("HRK");
        currval.add("HUF");
        currval.add("IDR");
        currval.add("ILS");
        currval.add("INR");
        currval.add("ISK");
        currval.add("JPY");
        currval.add("KRW");
        currval.add("MXN");
        currval.add("MYR");
        currval.add("NOK");
        currval.add("NZD");
        currval.add("PHP");
        currval.add("PLN");
        currval.add("RON");
        currval.add("RUB");
        currval.add("SEK");
        currval.add("SGD");
        currval.add("THB");
        currval.add("TRY");
        currval.add("USD");
        currval.add("ZAR");

        ArrayAdapter<String> currAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currval);
        currAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(currAdapter);

        spin1.setAdapter(currAdapter);

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        switch (parent.getId())
        {
            case R.id.spinner1:conv=item;break;
            case R.id.spinner2:conv1=item;break;
        }
        Log.i("info", item);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "wassssaaa", Toast.LENGTH_LONG).show();
    }


    public void execute(View view) {
        convert c =new convert();
        amt=edit1.getText().toString();
        if (conv.equals(conv1)) {
            responseView.setText("Error , Same currency chosen");
        }
        else {
            c.execute();
        }
    }

    public void switchcurr(View view) {
        Spinner spin = findViewById(R.id.spinner1);
        Spinner spin1 = findViewById(R.id.spinner2);
        spin.setSelection(((ArrayAdapter)spin.getAdapter()).getPosition(conv1));
        spin1.setSelection(((ArrayAdapter)spin1.getAdapter()).getPosition(conv));


    }

    class convert extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            responseView.setText("");
            progressBar.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(Void... voids) {

                try {
                    URL url = new URL(API_URL + "?amount=" + amt + "&from=" + conv + "&to=" + conv1);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                        bufferedReader.close();
                        line = stringBuilder.toString();
                        return stringBuilder.toString();
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
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
            try {
                JSONObject object=(JSONObject) new JSONTokener(response).nextValue();
                result= object.getString("rates");
                dateholder=object.getString("date");
                Log.i("HERE",dateholder);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            date.setText("Rates are current as of " + dateholder);
            StringBuilder s=new StringBuilder();
            for(int i=7;i<result.length();i++)
            {
                if(result.charAt(i)!='}')
                    s.append(result.charAt(i));
                if(result.charAt(i)=='}')
                    break;
            }
            responseView.setText(conv1+" : " +s.toString());
        }
    }
}