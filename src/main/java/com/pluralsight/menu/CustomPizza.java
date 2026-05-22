package com.pluralsight.menu;

import java.util.List;

public class CustomPizza extends Pizza{
    public CustomPizza(String crust, List<String> meats, List<String> cheese, List<String> toppings,
                       List<String> sauces, List<String> sides, int size, int extraMeat, int extraCheese) {
        super(crust, meats, cheese, toppings, sauces, sides, size, extraMeat, extraCheese);
    }

    public void addCrust(String crust) {
        if (getAvailableCrust().contains(crust)) {
            this.crust  = crust;
        }
    }

    public void addMeat(String meat) {
        if(getAvailableMeats().contains(meat)) {
            this.meats.add(meat);
        }
    }

    public void addCheese(String cheese) {
        if(getAvailableCheese().contains(cheese)) {
            this.cheese.add(cheese);
        }
    }

    public void addToppings(String topping) {
        if(getAvailableToppings().contains(topping)) {
            this.toppings.add(topping);
        }
    }

    public void addSauces(String sauces) {
        if(getAvailableSauces().contains(sauces)) {
            this.sauces.add(sauces);
        }
    }
    public void addSides(String sides) {
        if(getAvailableSides().contains(sides)) {
            this.sides.add(sides);
        }
    }

    @Override
    public String getName() {
        return "Custom Pizza";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
