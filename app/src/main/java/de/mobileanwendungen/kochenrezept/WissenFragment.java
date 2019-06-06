package de.mobileanwendungen.kochenrezept;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class WissenFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wissen, null);

        ImageButton btncarbs = (ImageButton) rootView.findViewById(R.id.carbs_button);
        btncarbs.setOnClickListener(this);

        ImageButton btnproteins = (ImageButton) rootView.findViewById(R.id.proteins_button);
        btnproteins.setOnClickListener(this);

        ImageButton btndrinks = (ImageButton) rootView.findViewById(R.id.drinks_button);
        btndrinks.setOnClickListener(this);

        ImageButton btnnuts = (ImageButton) rootView.findViewById(R.id.nutsoils_button);
        btnnuts.setOnClickListener(this);

        ImageButton btnvegs = (ImageButton) rootView.findViewById(R.id.veggies_button);
        btnvegs.setOnClickListener(this);

        ImageButton btnjunks = (ImageButton) rootView.findViewById(R.id.junks_button);
        btnjunks.setOnClickListener(this);

        // NAVIGATE TO NEXT FRAGMENT ON CLICK



        return rootView;


    }

    public void onClick(View v){

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.carbs_button:
                fr.replace(R.id.fragment_container, new CarbsFragment());
                fr.commit();
                break;

            case R.id.drinks_button:
                fr.replace(R.id.fragment_container, new fragment_drinks());
                fr.commit();
                break;
            case R.id.junks_button:
                fr.replace(R.id.fragment_container, new fragment_junks());
                fr.commit();
                break;
            case R.id.proteins_button:
                fr.replace(R.id.fragment_container, new fragment_proteins());
                fr.commit();
                break;
            case R.id.veggies_button:
                fr.replace(R.id.fragment_container, new fragment_vegs());
                fr.commit();
                break;
            case R.id.nutsoils_button:
                fr.replace(R.id.fragment_container, new fragment_oils());
                fr.commit();
                break;
        }

    }


    }

