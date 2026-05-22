package com.pluralsight.menu;

public interface MenuItem {
    String getName();
    double getPrice();

    default String getDescription(){
        return getName() + " - $" + String.format("%.2f", getPrice());
    }
}
