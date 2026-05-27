package com.pluralsight.menu;

public class PepperoniPizza extends CustomPizza{
    public PepperoniPizza(int size) {
        super(size);
        addMeat("pepperoni");
        addCheese("mozzarella");
        addToppings("tomatoes");
        addSauces("marinara");
        addSides("parmesan");
    }

    @Override
    public String getName() {
        return "Pepperoni Pizza";
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }

}
