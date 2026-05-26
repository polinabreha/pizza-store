package com.pluralsight.menu;


public class CustomPizza extends Pizza{
    public CustomPizza(int size) {
        super(size);
    }

    public void addCrust(String crust) {
        if (crustList.contains(crust)) {
            this.crust  = crust;
        }else{
            System.out.println(crust + " is not a valid crust");
        }
    }

    public void addMeat(String meat) {
        if(meatList.contains(meat)) {
            this.meats.add(meat);
        }else {
            System.out.println(meat + " is not a valid meat");
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
        if(cheeseList.contains(cheese)) {
            this.cheese.add(cheese);
        }else{
            System.out.println(cheese + " is not a valid cheese");
        }
    }

    public void removeCheese(String cheese) {
        if(!this.cheese.contains(cheese)) {
            System.out.println( cheese + " not found");
        }else{
            this.cheese.remove(cheese);
        }
    }

    public void addToppings(String topping) {
        if(toppingsList.contains(topping)) {
            this.toppings.add(topping);
        }else{
            System.out.println(topping + " is not a valid topping");
        }
    }

    public void removeToppings(String topping) {
        if(!toppings.contains(topping)) {
            System.out.println( topping + " not found");
        }else{
            this.toppings.remove(topping);
        }
    }

    public void addSauces(String sauces) {
        if(saucesList.contains(sauces)) {
            this.sauces.add(sauces);
        }else{
            System.out.println(sauces + " is not a valid sauces");
        }
    }

    public void removeSauces(String sauces) {
        if(!this.sauces.contains(sauces)) {
            System.out.println(sauces + " not found");
        }else{
            this.sauces.remove(sauces);
        }
    }
    public void addSides(String sides) {
        if(sidesList.contains(sides)) {
            this.sides.add(sides);
        }else{
            System.out.println(sides + " is not a valid sides");
        }
    }
    public void removeSides(String sides) {
        if(!this.sides.contains(sides)) {
            System.out.println(sides + " not found");
        }else {
            this.sides.remove(sides);
        }
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
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
