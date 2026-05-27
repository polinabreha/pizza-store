package com.pluralsight.menu;

public abstract class HawaiianPizza extends CustomPizza{
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
