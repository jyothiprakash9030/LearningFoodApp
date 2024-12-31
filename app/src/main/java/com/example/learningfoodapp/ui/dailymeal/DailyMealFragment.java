package com.example.learningfoodapp.ui.dailymeal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.adapters.DailymealAdapter;
import com.example.learningfoodapp.models.Dailymealmodel;

import java.util.ArrayList;
import java.util.List;


public class DailyMealFragment extends Fragment {

RecyclerView recyclerView;
List<Dailymealmodel> dailymealmodels;
DailymealAdapter dailymealAdapter;

    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_daily_meal,container,false);
        recyclerView=root.findViewById(R.id.dail_meal_rec);
        dailymealmodels=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailymealmodels.add(new Dailymealmodel(R.drawable.breakfast,"Breakfast","30% off","Description  Description","breakfast"));
        dailymealmodels.add(new Dailymealmodel(R.drawable.lunch,"Lunch","30% off","Description  Description","lunch"));
        dailymealmodels.add(new Dailymealmodel(R.drawable.dinner,"Dinner","30% off","Description  Description","dinner"));
        dailymealmodels.add(new Dailymealmodel(R.drawable.sweets,"Sweet","30% off","Description  Description","sweets"));
        dailymealmodels.add(new Dailymealmodel(R.drawable.coffe,"coffee","30% off","Description  Description","coffe"));
dailymealAdapter=new DailymealAdapter(getContext(),dailymealmodels);
recyclerView.setAdapter(dailymealAdapter);
dailymealAdapter.notifyDataSetChanged();
        return root;
    }


}