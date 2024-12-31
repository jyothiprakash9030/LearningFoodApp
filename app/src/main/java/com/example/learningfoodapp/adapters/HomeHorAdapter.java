package com.example.learningfoodapp.adapters;

import static androidx.core.content.ContextCompat.getColor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.models.HomeHorModel;
import com.example.learningfoodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>
{

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> List;
    boolean check =true;
    boolean select=true;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity,ArrayList<HomeHorModel> list) {
        List = list;
        this.activity = activity;
        this.updateVerticalRec = updateVerticalRec;
    }

    int row_index=-1;



    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
    holder.imageView.setImageResource(List.get(position).getImage());
    holder.name.setText(List.get(position).getName());


    if(check) {
        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
        homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "pizza", "10:00-23:00", "4.9", "Min-$34"));
        homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "pizza2", "10:00-23:00", "4.9", "Min-$34"));
        homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "pizza3", "10:00-23:00", "4.9", "Min-$34"));

        updateVerticalRec.callBack(position, homeVerModels);
        check = false;
    }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();

                if(position==0){
                    ArrayList<HomeVerModel>homeVerModels=new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza1,"pizza","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza2,"pizza2","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza3,"pizza3","10:00-23:00","4.9","Min-$34"));
                    updateVerticalRec.callBack(position,homeVerModels);

                }
                else if(position==1){
                    ArrayList<HomeVerModel>homeVerModels=new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1,"pizza","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1,"pizza2","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1,"pizza3","10:00-23:00","4.9","Min-$34"));
                    updateVerticalRec.callBack(position,homeVerModels);
                }
                else if(position==2){
                    ArrayList<HomeVerModel>homeVerModels=new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.fries1,"pizza","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries2,"pizza2","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries3,"pizza3","10:00-23:00","4.9","Min-$34"));
                    updateVerticalRec.callBack(position,homeVerModels);
                }
                else if(position==3){
                    ArrayList<HomeVerModel>homeVerModels=new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1,"pizza","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2,"pizza2","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2,"pizza3","10:00-23:00","4.9","Min-$34"));
                    updateVerticalRec.callBack(position,homeVerModels);

                }
                else if(position==4){
                    ArrayList<HomeVerModel>homeVerModels=new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich1,"pizza","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich2,"pizza2","10:00-23:00","4.9","Min-$34"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich3,"pizza3","10:00-23:00","4.9","Min-$34"));
                    updateVerticalRec.callBack(position,homeVerModels);
                }
            }
        });
if(select)
{
    if(position==0)
    {
        holder.cardView.setBackgroundResource(R.drawable.change_pbg);
        select=false;
    }
}
else {
    if(row_index==position)
    {
        holder.cardView.setBackgroundResource(R.drawable.change_pbg);
    }
    else
    {
        holder.cardView.setBackgroundResource(R.drawable.default_bg);
    }
}




    }

    @Override
    public int getItemCount()
    {
        return List.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name;
       CardView cardView;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }
}
