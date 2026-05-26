package com.pluralsight.menu;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public void removeItem(MenuItem item) {
        this.items.remove(item);
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        totalPrice = this.items.stream().mapToDouble(MenuItem::getPrice).sum();
        return totalPrice;
    }
}
