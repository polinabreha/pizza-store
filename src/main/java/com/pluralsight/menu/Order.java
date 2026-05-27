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

    public boolean removeItem(int itemNumber) {
        if (itemNumber >= 0 && itemNumber < this.items.size()) {
            items.remove(itemNumber);
            return true;
        }
        return false;
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public double calculateTotalPrice() {
        double totalPrice ;
        totalPrice = this.items.stream().mapToDouble(MenuItem::getPrice).sum();
        return totalPrice;
    }
}
