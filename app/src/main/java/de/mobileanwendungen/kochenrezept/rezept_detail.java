package de.mobileanwendungen.kochenrezept;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class rezept_detail extends Fragment {

    ImageView headerimg;


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
        View rootView =  inflater.inflate(R.layout.fragment_rezept_detail, container, false);

        headerimg = (ImageView) rootView.findViewById(R.id.img_recipe);

        return rootView;
    }

}
