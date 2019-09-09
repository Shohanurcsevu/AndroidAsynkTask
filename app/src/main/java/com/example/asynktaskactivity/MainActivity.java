package com.example.asynktaskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;
    Button buttonExecute;
    ProgressBar progressBar;
    ProgressDialog mProgressDialog ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult=findViewById(R.id.textView2);
        buttonExecute=findViewById(R.id.btnExe);
        progressBar=(ProgressBar)findViewById(R.id.progress_circular) ;




        buttonExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                  user();

            }
        });




    }

    private void user() {
        new AsyncTask<String,Integer,String>()
        {



            @Override
            protected String doInBackground(String... voids) {
                for (int i=0;i<5;i++)
                {
                    try
                    {
                            Thread.sleep(1000);





                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }

                return "Executed";
            }

            @Override
            protected void onPreExecute() {
              super.onPreExecute();
              mProgressDialog=new ProgressDialog(MainActivity.this);
              mProgressDialog.setMessage("Executing");
              mProgressDialog.show();


            }

            @Override
            protected void onPostExecute(String result) {
                textViewResult.setText("Executed");
               // progressBar.setVisibility(View.INVISIBLE);
                mProgressDialog.hide();



            }

            @Override
            protected void onProgressUpdate(Integer... values)
            {
               // progressBar.setProgress(values[0]);
            }
        }.execute();



    }





}
