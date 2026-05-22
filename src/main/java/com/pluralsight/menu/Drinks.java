package com.pluralsight.menu;
import java.util.List;

public class Drinks extends FixedItem {
    private String size;
    public Drinks(String name,  String size) {
        super(name, 0);
        this.size = size;
    }

    private static final List<String> listOfDrinks = List.of(
            "Water",
            "Orange juice",
            "Coca-Cola",
            "Diet Coca-Cola",
            "Root Beer",
            "Cream soda",
            "Poppi probiotic drinks",
            "Kombucha",
            "Apple juice"
    );

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
