package com.example.admin.apptest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

public class ShowAction extends AsyncTask<Void, Void, Void> {
    ProgressDialog pDialog;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(new MainActivity());
        pDialog.setMessage("please wait");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        Fragment fragment = null;
        if (params == null) {
             fragment = new Progress();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }
}
