package com.joshuajacobs.sudentfoodapp;

public class FoodItemActivity {
    private String name;
    private int imageResourceId;
    private double price;

    public FoodItemActivity(String name, int imageResourceId, double price) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
