package de.mobileanwendungen.kochenrezept;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RezeptFragment extends Fragment implements RezeptAdapter.onItemClickListner {


    RecyclerView recyclerView;

    ArrayList<ModelFood> foodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView =  inflater.inflate(R.layout.fragment_rezept, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);

        foodList = new ArrayList<>();


        foodList.add(new ModelFood(R.drawable.obstsalat, "Fruit Salad"));
        foodList.add(new ModelFood(R.drawable.panke, "Pancakes"));
        foodList.add(new ModelFood(R.drawable.bolognese, "Bolognese"));
        foodList.add(new ModelFood(R.drawable.icetea, "Ice Tea"));
        foodList.add(new ModelFood(R.drawable.waffles, "Waffles"));



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);


        RezeptAdapter adapter = new RezeptAdapter(getActivity().getApplicationContext(), foodList, this);

        recyclerView.setAdapter(adapter);



     return rootView;
    }


    @Override
    public void onItemClick(int position) {


        FragmentTransaction fr = getFragmentManager().beginTransaction();

        switch (position){
            case 0:
                fr.replace(R.id.fragment_container, new rezept_obstsalat());
                fr.commit();
                break;
            case 1:
                fr.replace(R.id.fragment_container, new rezept_pancake());
                fr.commit();
                break;
            case 2:
                fr.replace(R.id.fragment_container, new rezept_bolognese());
                fr.commit();
                break;
            case 3:
                fr.replace(R.id.fragment_container, new rezept_icetea());
                fr.commit();
                break;
            case 4:
                fr.replace(R.id.fragment_container, new rezept_waffle());
                fr.commit();
                break;
        }





       // ImageView headerpic = (ImageView) getView().findViewById(R.id.img_recipe);
       // chosenpic = foodList.get(position).getImage();
       // Log.d(TAG, "onItemClick: click  " +chosenpic);
       // Log.d(TAG, "onItemClick: CLICK2"+foodList.get(position));
      // System.out.println("FOODLIST POSITION" +foodList.get(position));
       // Log.d(TAG, "onItemClick: click" + position);
       // int chosenpic;



       // headerpic.setImageResource(chosenpic);

        //fragment_detail.setHeaderimg(headerpic);




    }
}
