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

    public void removeMeat (String meat){
        if(!meats.contains(meat)){
            System.out.println(meat + " not found");
        }else{
            meats.remove(meat);
        }
    }

    public void addCheese(String cheese) {
        if(getAvailableCheese().contains(cheese)) {
            this.cheese.add(cheese);
        }
    }

    public void removeCheese(String cheese) {
        if(!getAvailableCheese().contains(cheese)) {
            System.out.println( cheese + " not found");
        }else{
            this.cheese.remove(cheese);
        }
    }

    public void addToppings(String topping) {
        if(getAvailableToppings().contains(topping)) {
            this.toppings.add(topping);
        }
    }

    public void removeToppings(String topping) {
        if(!getAvailableToppings().contains(topping)) {
            System.out.println( topping + " not found");
        }else{
            this.toppings.remove(topping);
        }
    }

    public void addSauces(String sauces) {
        if(getAvailableSauces().contains(sauces)) {
            this.sauces.add(sauces);
        }
    }

    public void removeSauces(String sauces) {
        if(!getAvailableSauces().contains(sauces)) {
            System.out.println(sauces + " not found");
        }else{
            this.sauces.remove(sauces);
        }
    }
    public void addSides(String sides) {
        if(getAvailableSides().contains(sides)) {
            this.sides.add(sides);
        }
    }
    public void removeSides(String sides) {
        if(!getAvailableSides().contains(sides)) {
            System.out.println(sides + " not found");
        }else {
            this.sides.remove(sides);
        }
    }

    @Override
    public String getName() {
        return "Custom Pizza";
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }
}
