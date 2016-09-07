package com.subcodevs.maxus.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.subcodevs.maxus.R;

/**
 * Created by nupadhay on 5/16/2016.
 */
public class Information extends DialogFragment {
    public static Information newInstance() {
        return new Information();
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(getActivity() instanceof BenifitCalcutor){
            view = inflater.inflate(R.layout.calulator_info, container);
        }else{
            view = inflater.inflate(R.layout.information, container);
        }

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        view.findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

}
