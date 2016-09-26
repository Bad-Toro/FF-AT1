package com.mac.training.at1;

import android.os.AsyncTask;

/**
 * Created by Fernando on 9/26/2016.
 */

public class Task2 extends AsyncTask<Integer,Void,Void> {

    @Override
    protected Void doInBackground(Integer... integers) {

        try {
            Thread.sleep(integers[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

}
