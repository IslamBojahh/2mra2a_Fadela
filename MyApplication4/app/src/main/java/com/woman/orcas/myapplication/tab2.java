package com.woman.orcas.myapplication;

/**
 * Created by Aya_Orcas on 1/14/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class tab2 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab22, container, false);
        rootView.setTag("المبدأ الثاني");

        return rootView;
    }
}