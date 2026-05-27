package com.pluralsight.menu;

public class MargheritaPizza extends CustomPizza{
    public MargheritaPizza(int size) {
        super(size);
        addCrust("regular");
        addCheese("mozzarella");
        addToppings("tomatoes");
        addToppings("basil");
        addSauces("marinara");
        addSauces("olive oil");
    }

    @Override
    public String getName() {
        return "Margherita Pizza" ;
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }
}
