package com.example.learningfoodapp.ui.home;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.adapters.HomeHorAdapter;
import com.example.learningfoodapp.adapters.HomeVerAdapter;
import com.example.learningfoodapp.databinding.FragmentHomeBinding;
import com.example.learningfoodapp.models.HomeHorModel;
import com.example.learningfoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

   RecyclerView homeHoriZontalRec,homeVerticalRec;
   List<HomeHorModel>homeHorModelsList;
   HomeHorAdapter homeHorAdapter;
   /////////Vertical
    List<HomeVerModel>homeVerModelList;
    HomeVerAdapter homeVerAdapter;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root=inflater.inflate(R.layout.fragment_home,container,false);
        homeHoriZontalRec=root.findViewById(R.id.home_hor_rec);
        homeVerticalRec=root.findViewById(R.id.hom_ever);

        ////Horizontalrecycleview




        homeHorModelsList=new ArrayList<>();
        homeHorModelsList.add(new HomeHorModel(R.drawable.pizza,"pizza"));
        homeHorModelsList.add(new HomeHorModel(R.drawable.hamburger,"HamBurger"));
        homeHorModelsList.add(new HomeHorModel(R.drawable.fried_potatoes,"fries"));
        homeHorModelsList.add(new HomeHorModel(R.drawable.ice_cream,"Ice Cream"));
        homeHorModelsList.add(new HomeHorModel(R.drawable.sandwich,"Sandwich"));

        homeHorAdapter=new HomeHorAdapter(getActivity(),homeHorModelsList);

        homeHoriZontalRec.setAdapter(homeHorAdapter);
        homeHoriZontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHoriZontalRec.setHasFixedSize(true);
        homeHoriZontalRec.setNestedScrollingEnabled(false);
        ////verticalrecycleview

        homeVerModelList=new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1,"pizza1","10:00-23:00","4.9","Min-$34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2,"pizza2","10:00-23:00","4.9","Min-$34"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3,"pizza3","10:00-23:00","4.9","Min-$34"));


        homeVerAdapter=new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);
        return root;
    }


}