package de.mobileanwendungen.kochenrezept;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;

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

        foodList.get(position);
        int chosenpic;

        rezept_detail fragment_detail = new rezept_detail();
        ImageButton headerpic;

        FragmentTransaction fr = getFragmentManager().beginTransaction();

        fr.replace(R.id.fragment_container, fragment_detail);



        for(int i = 0; i < foodList.size();   i++){
            chosenpic = foodList.get(i).getImage();

          //  fragment_detail.setHeaderimg(chosenpic);

        }

        fr.commit();
    }
}
