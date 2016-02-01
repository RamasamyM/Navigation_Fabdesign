package com.example.admin.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 1/29/2016.
 */
public class Progress extends Fragment
{

    private  static  final String tag= "progress fragment ";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View  view= inflater.inflate(R.layout.mylayout,null, false);
            new ShowAction().execute();
            return view;

        }


}



