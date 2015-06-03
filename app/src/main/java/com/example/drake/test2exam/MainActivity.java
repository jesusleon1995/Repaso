package com.example.drake.test2exam;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class MainActivity extends ActionBarActivity {

    EditText number;
    Button putNumber;
    EditText string;
    Button putString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "lPajp3BkoBQV1DUAtmaeF9041OwFnYVd5i0qLYaa", "8qNWeo93SBdFgEV9qysJ4TgGk4iGft7KW7ZR4Sw2");
        //Parse.initialize(this, "Vi1GhZqd0En3IJ32lutbhMVMZsARgsKoQlSkhp0I", "ud0qXYGDA7HDFiG20xjmL9WIohoDvDmr7PxR7TfE");
        number = (EditText) findViewById(R.id.editText);
        putNumber = (Button) findViewById(R.id.button);
        string = (EditText) findViewById(R.id.editText2);
        putString = (Button) findViewById(R.id.button2);
    }

    @Override
    public void onStart(){
        super.onStart();

        putNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int i;
                i = Integer.parseInt(number.getText().toString());
                ParseController.updateNumber(i, "number");
            }
        });

        putString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new AsyncTaskRunner().execute();
                final String i;
                i = string.getText().toString();
                ParseController.upUser(i, "username");
            }
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            try {
                //Calls to ParseController
                final String i;
                i = string.getText().toString();
                ParseController.upUser(i, "username");

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally{
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),"user added",Toast.LENGTH_LONG).show();
        }
    }
}
