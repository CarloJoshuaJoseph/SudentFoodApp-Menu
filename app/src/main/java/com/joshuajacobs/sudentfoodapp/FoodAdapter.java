package com.joshuajacobs.sudentfoodapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.Locale;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<FoodItemActivity> foodItemActivityList;
    private FoodRecycler activity;

    public FoodAdapter(List<FoodItemActivity> foodItemActivityList, FoodRecycler activity) {
        this.foodItemActivityList = foodItemActivityList;
        this.activity = activity;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfoodlayout, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItemActivity foodItemActivity = foodItemActivityList.get(position);
        holder.imageView.setImageResource(foodItemActivity.getImageResourceId());
        holder.textViewName.setText(foodItemActivity.getName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", foodItemActivity.getPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {

            activity.saveFoodToDatabase(foodItemActivity);
        });
    }

    @Override
    public int getItemCount() {
        return foodItemActivityList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public FoodViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
