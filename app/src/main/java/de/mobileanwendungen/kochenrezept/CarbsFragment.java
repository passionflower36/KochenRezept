package de.mobileanwendungen.kochenrezept;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CarbsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_carbs, null);

        //------------Text einsetzen---------------------------------

        TextView txtEmpfehlung = (TextView) rootView.findViewById(R.id.text_carbs_empfehlung);

        txtEmpfehlung.setText(R.string.carbs_empfehlung);
        txtEmpfehlung.setMovementMethod(new ScrollingMovementMethod());


        TextView txtDetails = (TextView) rootView.findViewById(R.id.text_carbs);
        txtDetails.setText(R.string.carbs_info2);
        txtDetails.setMovementMethod(new ScrollingMovementMethod());


        return rootView;

    }
}
