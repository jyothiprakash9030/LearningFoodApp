package com.example.learningfoodapp.ui.favourite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.adapters.HomeHorAdapter;
import com.example.learningfoodapp.adapters.HomeVerAdapter;
import com.example.learningfoodapp.adapters.UpdateVerticalRec;
import com.example.learningfoodapp.models.HomeHorModel;
import com.example.learningfoodapp.models.HomeVerModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment  implements UpdateVerticalRec {

   RecyclerView homeHoriZontalRec,homeVerticalRec;
   ArrayList<HomeHorModel>homeHorModelsList;
   HomeHorAdapter homeHorAdapter;
   /////////Vertical
    ArrayList<HomeVerModel>homeVerModelList;
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

       homeHorAdapter=new HomeHorAdapter(this,getActivity(),homeHorModelsList);

        homeHoriZontalRec.setAdapter(homeHorAdapter);
        homeHoriZontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHoriZontalRec.setHasFixedSize(true);
        homeHoriZontalRec.setNestedScrollingEnabled(false);
        ////verticalrecycleview


        homeVerAdapter=new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list)
    {
        homeVerAdapter=new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}