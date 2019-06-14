package de.mobileanwendungen.kochenrezept;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class rezept_obstsalat extends Fragment {

    ImageView headerimg;
    Button zumSpiel;


    public ImageView getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(ImageView headerimg) {
        this.headerimg = headerimg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_rezept_obstsalat, container, false);

       // headerimg = (ImageView) rootView.findViewById(R.id.img_recipe);

        zumSpiel = rootView.findViewById(R.id.zumSpiel);

        //--------Button zumSpiel-------------------------
        zumSpiel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpielen();
            }
        });
        //-----------------------------------------------

        return rootView;
    }
    //------oeffnet das Spiel-------------------
    public void openSpielen(){
        Intent intent = new Intent(getActivity(), spielen.class);
        startActivity(intent);
    }

}
