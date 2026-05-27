package com.pluralsight.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza implements MenuItem {
    protected int size;
    protected String crust;
    protected List<String>  meats, cheese , toppings , sauces , sides;
    protected boolean stuffedCrust;


    public static final List<String> crustList = List.of(
            "thin",
            "regular",
            "thick",
            "cauliflower"

    );
    public static final List<String> meatList = List.of (
            "pepperoni",
            "sausage",
            "ham",
            "bacon",
            "chicken",
            "meatball"
    );
    public static final List<String> cheeseList =  List.of (
            "mozzarella",
            "parmesan",
            "ricotta",
            "goat cheese",
            "buffalo"
    );
    public static final List<String> toppingsList = List.of(
            "onions",
            "mushrooms",
            "bell peppers",
            "olives",
            "tomatoes",
            "spinach",
            "basil",
            "pineapple",
            "anchovies"
    );
    public static final List<String> saucesList = List.of(
           "marinara",
            "alfredo",
            "pesto",
            "bbq",
            "buffalo",
             "olive oil"
    );
    public static final List<String> sidesList =  List.of(
           "red pepper",
           "parmesan"
    );


    public Pizza(int size) {
        this.size = size;
        meats = new ArrayList<>();
        cheese = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
        sides = new ArrayList<>();
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheese() {
        return cheese;
    }

    public String getCrust() {
        return crust;
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

    public int getSize() {
        return size;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    @Override
    public  abstract String getName();

    @Override
    public  abstract double getPrice();

    @Override
    public String toString() {
        return """
                Custom Pizza
                Crust : %s
                Meats : %s
                Cheese : %s
                Toppings : %s
                Sauces : %s
                Sides : %s
                Price : %.2f
                """.formatted(crust,meats,cheese,toppings,sauces,sides,getPrice());


    }
}
