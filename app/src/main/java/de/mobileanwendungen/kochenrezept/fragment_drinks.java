package de.mobileanwendungen.kochenrezept;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class fragment_drinks extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_drinks, container, false);

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_drinks_empfehlung);
        txtEmpfehlung.setText(R.string.drinks_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());

        txtEmpfehlung.setTextSize(23);

        TextView txtDetails = (TextView) rootView.findViewById(R.id.text_drinks);
        txtDetails.setText(R.string.drinks_info);
        txtDetails.setMovementMethod(new ScrollingMovementMethod());

        txtDetails.setTextSize(23);
        return rootView;
    }


}
