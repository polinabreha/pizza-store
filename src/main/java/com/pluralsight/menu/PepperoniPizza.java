package com.pluralsight.menu;

public class PepperoniPizza extends CustomPizza{
    public PepperoniPizza(int size) {
        super(size);
        addMeat("pepperoni");
        addCheese("mozzarella");
        addToppings("tomatoes");
        addSauces("marinara");
    }

    @Override
    public String getName() {
        return "Pepperoni Pizza";
    }

    @Override
    public double getPrice() {
        return PizzaPrice.calculatePizzaPrice(this);
    }

    @Override
    public String toString() {
        return  """
                Crust: %s
                Meat : %s
                Cheese : %s
                Topping : %s
                Sauce : %s
                Sides : %s
                """.formatted(getCrust(),getMeats(),getSize(), getToppings(),getSauces(),getSides());
    }
}
