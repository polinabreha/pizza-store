package com.pluralsight.menu;

public class HawaiianPizza extends CustomPizza{
    public HawaiianPizza(int size) {
        super(size);

        addMeat("ham");
        addCheese("mozzarella");
        addCrust("thin");
        addToppings("pineapple");
        addSauces("marinara");
        addSides("parmesan");
    }

    @Override
    public String getName() {
        return "Hawaiian Pizza";
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }

}
