package com.example.menuapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menuapp.R;

public class MenuCardAdaptor extends RecyclerView.Adapter<MenuCardAdaptor.ViewHolder> {

    MenuData[] menuData;
    Context context;
    public MenuCardAdaptor(MenuData[] menuData, Context activity) {
        this.menuData = menuData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MenuData menuDataList = menuData[position];
        holder.textViewName.setText(menuDataList.getTextTitle());
        holder.textViewDescription.setText(menuDataList.getTextDescription());
        holder.textViewPrice.setText(menuDataList.getTextPrice());
        holder.textImage.setImageResource(menuDataList.getTextImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, menuDataList.getTextTitle() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView textImage;
        TextView textViewName;
        TextView textViewDescription;
        TextView textViewPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.textTitle);
            textViewDescription = itemView.findViewById(R.id.textDescription);
            textViewPrice = itemView.findViewById(R.id.textPrice);

        }
    }
}
