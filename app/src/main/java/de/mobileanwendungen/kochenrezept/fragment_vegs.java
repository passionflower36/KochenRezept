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


public class fragment_vegs extends Fragment {
    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =inflater.inflate(R.layout.fragment_vegs, container, false);

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_vegs_empfehlung);
        txtEmpfehlung.setText(R.string.vegs_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());

        TextView txtObst = (TextView) rootView.findViewById(R.id.text_obst);
        txtObst.setText(R.string.obst);
        txtObst.setMovementMethod(new ScrollingMovementMethod());

        TextView txtVegs = (TextView) rootView.findViewById(R.id.text_veg);
        txtVegs.setText(R.string.veegs_info);
        txtVegs.setMovementMethod(new ScrollingMovementMethod());

        return rootView;

    }

}
