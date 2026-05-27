package com.pluralsight.menu;

public class VeggiePizza extends CustomPizza{
    public VeggiePizza(int size) {
        super(size);
        addCrust("cauliflower");
        addCheese("mozzarella");
        addToppings("spinach");
        addToppings("olives");
        addToppings("mushrooms");
        addToppings("onions");
        addToppings("tomatoes");
        addSauces("marinara");
        addSides("red pepper");
    }

    @Override
    public String getName() {
        return "Veggie Pizza";
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }

}
