package de.mobileanwendungen.kochenrezept;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragment_oils extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_oils, container, false);

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_nuts_empfehlung);
        txtEmpfehlung.setText(R.string.nuts_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());

        txtEmpfehlung.setTextSize(23);

        TextView txtNuts = (TextView) rootView.findViewById(R.id.text_nuts);
        txtNuts.setText(R.string.nuts_info);
        txtNuts.setMovementMethod(new ScrollingMovementMethod());

        txtNuts.setTextSize(23);

        TextView txtOils = (TextView) rootView.findViewById(R.id.text_oils);
        txtOils.setText(R.string.oils_info);
        txtOils.setMovementMethod(new ScrollingMovementMethod());

        txtOils.setTextSize(23);


        return rootView;
    }
}
