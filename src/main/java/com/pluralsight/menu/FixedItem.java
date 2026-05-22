package com.pluralsight.menu;

public class FixedItem implements MenuItem {
    protected String name;
    protected double price;

    public FixedItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
    @Override
    public  String getName() {
        return this.name;
    }
}
