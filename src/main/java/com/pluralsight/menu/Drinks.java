package com.pluralsight.menu;
import java.util.ArrayList;
import java.util.List;

public class Drinks implements MenuItem {
    private String name;
    private String size;

    public Drinks(String name,  String size) {
        this.name = name;
        this.size = size;
    }
//    public List<String> getDrinkName() {
//        ArrayList<String> drinkName = new ArrayList<>();
//        drinkName.add("Water");
//        drinkName.add("Orange juice");
//        drinkName.add("Coca-Cola");
//        drinkName.add("Diet Coca-Cola");
//        drinkName.add("Root Beer");
//        drinkName.add("Cream soda");
//        drinkName.add("Poppi probiotic drinks");
//        drinkName.add("Kombucha");
//        drinkName.add("Apple juice");
//        return drinkName;
//    }

    @Override
    public String getName() {
        return this.name  + " " + this.size;
    }

    @Override
    public double getPrice() {
        return switch (size.toLowerCase()){
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> throw new IllegalArgumentException ("Invalid size");
        };
    }
}
