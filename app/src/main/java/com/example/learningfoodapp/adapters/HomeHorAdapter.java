package com.example.learningfoodapp.adapters;

import static androidx.core.content.ContextCompat.getColor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.models.HomeHorModel;

import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>
{
Context context;
    List<HomeHorModel>List;


    public HomeHorAdapter(Context context, java.util.List<HomeHorModel> list)
    {
        this.context = context;
        List = list;
    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
    holder.imageView.setImageResource(List.get(position).getImage());
    holder.name.setText(List.get(position).getName());
        holder.name.setTextColor(context.getResources().getColor(R.color.purple_700));
    }

    @Override
    public int getItemCount()
    {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);

        }
    }
}
