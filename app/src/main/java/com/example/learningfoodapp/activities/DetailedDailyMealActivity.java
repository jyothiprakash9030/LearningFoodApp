package com.example.learningfoodapp.activities;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.adapters.DetailedDailyAdpater;
import com.example.learningfoodapp.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {
RecyclerView recyclerView;
List <DetailedDailyModel> detailedDailyModelsList;
DetailedDailyAdpater dailyAdpater;
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_daily_meal);
        String type=getIntent().getStringExtra("type");

        imageView=findViewById(R.id.detailed_daily_img);
        recyclerView=findViewById(R.id.detailed_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelsList=new ArrayList<>();
        dailyAdpater=new DetailedDailyAdpater(detailedDailyModelsList);

        recyclerView.setAdapter(dailyAdpater);


      if(type!=null && type.equalsIgnoreCase("breakfast"))
      {
          detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.fav1,"Breakfast","description","4.4","4.0","10am to 9pm"));
          detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.fav2,"Breakfast","description","4.4","4.0","10am to 9pm"));
          detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.fav3,"Breakfast","description","4.4","4.0","10am to 9pm"));
          dailyAdpater.notifyDataSetChanged();


      }

        if(type!=null && type.equalsIgnoreCase("sweets"))
        {
            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.s1,"Breakfast","description","4.4","4.0","10am to 9pm"));
            detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.s2,"Breakfast","description","4.4","4.0","10am to 9pm"));
            detailedDailyModelsList.add(new DetailedDailyModel(R.drawable.s3,"Breakfast","description","4.4","4.0","10am to 9pm"));
            dailyAdpater.notifyDataSetChanged();


        }





















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}