package com.joshuajacobs.sudentfoodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {

    private List<DrinkItemActivity> drinkItemActivityList;
    private DrinkRecycler activity;

    public DrinkAdapter(List<DrinkItemActivity> drinkItemActivityList, DrinkRecycler activity) {
        this.drinkItemActivityList = drinkItemActivityList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdrinklayout, parent, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        DrinkItemActivity drinkItemActivity = drinkItemActivityList.get(position);
        holder.imageView.setImageResource(drinkItemActivity.getDrinkImageResourceId());
        holder.textViewName.setText(drinkItemActivity.getDrinkName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", drinkItemActivity.getDrinkPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            activity.saveDrinkToDatabase(drinkItemActivity);
        });
    }

    @Override
    public int getItemCount() {
        return drinkItemActivityList.size();
    }

    public static class DrinkViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public DrinkViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
