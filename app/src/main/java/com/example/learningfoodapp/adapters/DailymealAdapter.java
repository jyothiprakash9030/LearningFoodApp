package com.example.learningfoodapp.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.activities.DetailedDailyMealActivity;
import com.example.learningfoodapp.R;
import com.example.learningfoodapp.models.Dailymealmodel;

import java.util.List;

public  class DailymealAdapter extends RecyclerView.Adapter<DailymealAdapter.ViewHolder>
{
    Context context;
    List<Dailymealmodel>list;

    public DailymealAdapter(Context context, List<Dailymealmodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meals_iteams,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
         holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.discount.setText(list.get(position).getDiscount());
        holder.description.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailedDailyMealActivity.class);
                intent.putExtra("type",list.get(position).getType());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,discount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview_dail_meals);
            name=itemView.findViewById(R.id.textview9);
            description=itemView.findViewById(R.id.textview10);
            discount=itemView.findViewById(R.id.discount);


        }
    }

}
