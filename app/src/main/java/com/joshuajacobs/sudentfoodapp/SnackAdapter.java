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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnackViewHolder> {

    private List<SnackItemActivity> snackItemActivityList;
    private Snack_Recycler activity;

    public SnackAdapter(List<SnackItemActivity> snackItemActivityList, Snack_Recycler activity) {
        this.snackItemActivityList = snackItemActivityList;
        this.activity = activity;
    }

    public SnackAdapter(List<SnackItemActivity> snackItemActivityList) {
    }

    @NonNull
    @Override
    public SnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsnacklayout, parent, false);
        return new SnackViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull SnackViewHolder holder, int position) {
        SnackItemActivity snackItemActivity = snackItemActivityList.get(position);
        holder.imageView.setImageResource(snackItemActivity.getImageResourceId());
        holder.textViewName.setText(snackItemActivity.getName());
        holder.textViewPrice.setText(String.format(Locale.getDefault(), "Price: R%.2f", snackItemActivity.getPrice()));
        holder.buttonAddToBasket.setOnClickListener(v -> {
            // Handle button click event
            // Save the snack choice to the database
            activity.saveSnackToDatabase(snackItemActivity);
        });
    }


    @Override
    public int getItemCount() {
        return snackItemActivityList.size();
    }

    public static class SnackViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
        Button buttonAddToBasket;

        public SnackViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            buttonAddToBasket = itemView.findViewById(R.id.buttonAddToBasket);
        }
    }
}
