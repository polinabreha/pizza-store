package com.pluralsight.menu;

import java.util.List;

public class CustomPizza extends Pizza implements MenuItem {
    public CustomPizza(List<String> crust, List<String> meats, List<String> cheese, List<String> toppings, List<String> sauces, List<String> sides, double price) {
        super(crust, meats, cheese, toppings, sauces, sides, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
