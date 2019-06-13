package de.mobileanwendungen.kochenrezept;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragment_proteins extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_proteins, container, false);

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_proteins_empfehlung);
        txtEmpfehlung.setText(R.string.proteins_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());

        txtEmpfehlung.setTextSize(23);

        TextView txtDetails = (TextView) rootView.findViewById(R.id.text_proteins);
        txtDetails.setText(R.string.proteins_info);
        txtDetails.setMovementMethod(new ScrollingMovementMethod());

        txtDetails.setTextSize(23);

        return rootView;
    }

}


