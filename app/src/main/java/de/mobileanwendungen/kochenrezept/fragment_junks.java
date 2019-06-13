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


public class fragment_junks extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_junks, container, false);

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_junks_empfehlung);
        txtEmpfehlung.setText(R.string.junks_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());

        txtEmpfehlung.setTextSize(23);

        TextView txtDetail = (TextView) rootView.findViewById(R.id.text_junks);
        txtDetail.setText(R.string.junks_info);
        txtDetail.setMovementMethod(new ScrollingMovementMethod());

        txtDetail.setTextSize(23);



        return rootView;
    }
}
