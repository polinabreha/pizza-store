package com.pluralsight.menu;

import java.util.List;

public class Drinks extends FixedItem {
    private String size;
    public Drinks(String name,  String size) {
        super(name, 0);
        this.size = size;
    }

    public static final List<String> drinkList = List.of("Water" , "Orange juice", "Coca-cola",
            "Diet coca-cola" , "Sparkling water" , "Lemonade");

    public static final List<String> sizeList = List.of("small", "medium", "large");
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
