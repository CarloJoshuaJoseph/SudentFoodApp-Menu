package com.joshuajacobs.sudentfoodapp;

public class DrinkItemActivity {
    private String drinkName;
    private int drinkImageResourceId;
    private double drinkPrice;

    public DrinkItemActivity(String name, int imageResourceId, double price) {
        this.drinkName = name;
        this.drinkImageResourceId = imageResourceId;
        this.drinkPrice = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getDrinkImageResourceId() {
        return drinkImageResourceId;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setDrinkImageResourceId(int drinkImageResourceId) {
        this.drinkImageResourceId = drinkImageResourceId;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}
