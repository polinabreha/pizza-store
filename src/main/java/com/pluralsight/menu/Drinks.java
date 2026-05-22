package com.pluralsight.menu;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private List<String> drinkName;
    private double price;
    private int size;
    public Drinks(List<String> drinkName, double price, int size) {
        this.drinkName = drinkName;
        this.price = price;
        this.size = size;
    }
    public List<String> getDrinkName() {
        ArrayList<String> drinkName = new ArrayList<>();
        drinkName.add("Water");
        drinkName.add("Orange juice");
        drinkName.add("Coca-Cola");
        drinkName.add("Diet Coca-Cola");
        drinkName.add("Root Beer");
        drinkName.add("Cream soda");
        drinkName.add("Poppi probiotic drinks");
        drinkName.add("Kombucha");
        drinkName.add("Apple juice");
        return drinkName;
    }


}
