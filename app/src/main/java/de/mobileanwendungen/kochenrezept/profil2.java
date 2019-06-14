package de.mobileanwendungen.kochenrezept;

import android.content.Context;
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
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;


//Hier könnte man Strings in der String Datei anlegen, um Namensänderungen zu vereinfachen

public class profil2 extends Fragment {

    private ImageSwitcher sw;
    private Button prev, next;

    //Image ID Array zum Switchen

    int imageIds [] = {R.drawable.koch, R.drawable.opa, R.drawable.oma, R.drawable.fuchs, R.drawable.panda, R.drawable.mickey, R.drawable.wizard};
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
        prev = (Button) rootView.findViewById(R.id.btn_prev) ;
        next = (Button) rootView.findViewById(R.id.btn_next) ;
        name = (TextView) rootView.findViewById(R.id.txt_profilname);
        sw.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView = new ImageView(getActivity());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        sw.setImageResource(imageIds[0]);
        name.setText("Luigi");

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

                //Namen anpassen

                switch (imageIds[currentIndex]){
                    case R.drawable.koch:
                        name.setText("Luigi");
                        break;

                    case R.drawable.fuchs:
                        name.setText("Falco");
                        break;
                    case R.drawable.panda:
                        name.setText("Eukalypto");
                        break;
                    case R.drawable.opa:
                        name.setText("Opa");
                    break;
                    case R.drawable.oma:
                        name.setText("Omi");
                        break;
                    case R.drawable.mickey:
                        name.setText("Mickey");
                        break;
                    case R.drawable.wizard:
                        name.setText("Dummydore");
                        break;
                }

            }
        });

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

                //Namen anpassen

                switch (imageIds[currentIndex]){
                    case R.drawable.koch:
                        name.setText("Luigi");
                        break;

                    case R.drawable.fuchs:
                        name.setText("Falco");
                        break;
                    case R.drawable.panda:
                        name.setText("Eukalypto");
                        break;
                    case R.drawable.opa:
                        name.setText("Opa");
                        break;
                    case R.drawable.oma:
                        name.setText("Omi");
                        break;
                    case R.drawable.mickey:
                        name.setText("Mickey");
                        break;
                    case R.drawable.wizard:
                        name.setText("Dummydore");
                        break;
                }
            }

        });
    return rootView;
    }



}
