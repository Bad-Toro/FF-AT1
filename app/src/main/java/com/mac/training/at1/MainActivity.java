package com.mac.training.at1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tV;
    TextView lbl2;

    int myI = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV = (TextView) findViewById(R.id.lbl);
        lbl2 = (TextView) findViewById(R.id.lbl2);
    }

    public void onDo(View view) {
        tV.setText(tV.getText().toString() + "\nWorking...");
        myI++;
        new MFAT().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,myI);
    }

    class MFAT extends AsyncTask<Integer, Integer, String>{


        @Override
        protected String doInBackground(Integer... integers) {
            for(int i = 1; i < integers[0]*10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return "\nDone " + integers[0];
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            lbl2.setText(
                    lbl2.getText().toString() + "\n" +
                    values[0].toString());
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tV.setText(tV.getText().toString()+s);
        }
    }

}
