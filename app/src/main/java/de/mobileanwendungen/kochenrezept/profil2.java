package de.mobileanwendungen.kochenrezept;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;


//Hier könnte man Strings in der String Datei anlegen, um Namensänderungen zu vereinfachen

public class profil2 extends Fragment {

    private ImageSwitcher sw;
    private ImageView prev, next, speichern;
    private int tag;
    private String message="Auswahl gespeichert";


   // public static final String SHARED_PREFS = "sharedPrefs";


    //Image ID Array zum Switchen

    int imageIds [] = {R.drawable.logo_apfel, R.drawable.logo_banane, R.drawable.logo_birne, R.drawable.logo_orange};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = 0,indexPrevious = imageIds.length;

    //Textview mit Namen für die entsprechenden Avatare
    private TextView name;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_profil2, container, false);

        sw = (ImageSwitcher) rootView.findViewById(R.id.imgswtch);
        prev =  rootView.findViewById(R.id.btn_prev) ;
        next =  rootView.findViewById(R.id.btn_next) ;
        name = (TextView) rootView.findViewById(R.id.txt_profilname);
        speichern = rootView.findViewById(R.id.speichern);
        sw.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView = new ImageView(getActivity());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        loadData();
        //--------Pfeil zurueck------------------
        prev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sw.setInAnimation(getActivity().getApplicationContext(),R.anim.in_from_right);
                sw.setOutAnimation(getActivity().getApplicationContext(),R.anim.out_to_left);
                //   imageSwitcher.showPrevious();
                --currentIndex;
                //  Check If index reaches maximum then reset it
                if (currentIndex < 0)
                    currentIndex = imageIds.length-1;
                sw.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher

                //---Namen anpassen----------------------------

                switch (imageIds[currentIndex]){
                    case R.drawable.logo_apfel:
                        name.setText("Anton Apfel");
                        tag = 1;
                        break;

                    case R.drawable.logo_banane:
                        name.setText("Bernd Banane");
                        tag = 2;
                        break;
                    case R.drawable.logo_birne:
                        name.setText("Bella Birne");
                        tag = 3;
                        break;
                    case R.drawable.logo_orange:
                        name.setText("Olaf Orange");
                        tag = 4;
                    break;
                }
            }
        });
        //------------naechstes Bild------------------------
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sw.setInAnimation(getActivity().getApplicationContext(),R.anim.in_from_left);
                sw.setOutAnimation(getActivity().getApplicationContext(),R.anim.out_to_right);

                currentIndex++;
                //  imageSwitcher.showNext();
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                sw.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher

                //------Namen anpassen-----------

                switch (imageIds[currentIndex]){
                    case R.drawable.logo_apfel:
                        name.setText("Anton Apfel");
                        tag = 1;
                        break;
                    case R.drawable.logo_banane:
                        name.setText("Bernd Banane");
                        tag = 2;
                        break;
                    case R.drawable.logo_birne:
                        name.setText("Bella Birne");
                        tag = 3;
                        break;
                    case R.drawable.logo_orange:
                        name.setText("Olaf Orange");
                        tag = 4;
                        break;
                }
            }

        });
        speichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            saveData();
            Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
            }
        });
    return rootView;
    }

//------------Speichert die Wahl des Avatars-------------------------
    public void saveData() {
    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("SaveData", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("Value", tag);
    editor.apply();

    }
    //---------Avatar laden-----------------------------------------
    public void loadData() {
        SharedPreferences result = getActivity().getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        int value = result.getInt("Value", 0);
        switch (value){
            case 0:

                break;
            case 1:
                sw.setImageResource(R.drawable.logo_apfel);
                name.setText("Anton Apfel");
                break;
            case 2:
                sw.setImageResource(R.drawable.logo_banane);
                name.setText("Bernd Banane");
                break;
            case 3:
                sw.setImageResource(R.drawable.logo_birne);
                name.setText("Bella Birne");
                break;
            case 4:
                sw.setImageResource(R.drawable.logo_orange);
                name.setText("Olaf Orange");
                break;

        }

    }

}
