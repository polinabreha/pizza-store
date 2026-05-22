package com.pluralsight.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza implements MenuItem {
    protected int size;
    protected String crust;
    protected List<String>  meats, cheese , toppings , sauces , sides;
    protected int extraMeatCounts, extraCheeseCounts;

    public Pizza(String crust, List<String> meats, List<String> cheese, List<String> toppings,
                 List<String> sauces, List<String> sides,  int size, int extraMeatCounts, int extraCheeseCounts) {
        this.crust = crust;
        this.meats = meats;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauces = sauces;
        this.sides = sides;
        this.size = size;
        this.extraMeatCounts = extraMeatCounts;
        this.extraCheeseCounts = extraCheeseCounts;
    }

    public int getExtraMeatCounts() {
        return extraMeatCounts;
    }

    public int getExtraCheeseCounts() {
        return extraCheeseCounts;
    }

    public String getCrust() {
        return crust;
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public List<String> getSides() {
        return sides;
    }

    public String getAvailableCrust() {
        ArrayList<String> crust = new ArrayList<>();
        crust.add("thin");
        crust.add("regular");
        crust.add("thick");
        crust.add ("cauliflower");
        return String.valueOf(crust);
    }

    public List<String> getAvailableMeats() {
        ArrayList<String> meats = new ArrayList<>();
        meats.add("pepperoni");
        meats.add("sausage");
        meats.add("ham");
        meats.add("bacon");
        meats.add("chicken");
        meats.add("meatball");
        return meats;
    }

    public List<String> getAvailableCheese() {
        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("Mozzarella");
        cheese.add("Parmesan");
        cheese.add("Ricotta");
        cheese.add("Goat Cheese");
        cheese.add("Buffalo");
        return cheese;
    }

    public List<String> getAvailableToppings() {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("onions");
        toppings.add("mushrooms");
        toppings.add("bell peppers");
        toppings.add("olives");
        toppings.add("tomatoes");
        toppings.add("spinach");
        toppings.add("basil");
        toppings.add("pineapple");
        toppings.add("anchovies");
        return  toppings;
    }

    public List<String> getAvailableSauces() {
        ArrayList<String> sauces = new ArrayList<>();
        sauces.add("marinara");
        sauces.add("alfredo");
        sauces.add("pesto");
        sauces.add("bbq");
        sauces.add("buffalo");
        sauces.add("olive oil");
        return  sauces;
    }

    public List<String> getAvailableSides() {
        ArrayList<String> sides = new ArrayList<>();
        sides.add("red pepper");
        sides.add("parmesan");
        return sides;
    }

    public int getSize() {
        return size;
    }

    @Override
    public  abstract String getName();

    @Override
    public  abstract double getPrice();

}
