package com.pluralsight.menu;

public class Sides extends FixedItem {
    public Sides(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return """
                %s         $%.2f
                """.formatted(name,getPrice());
    }
}
