package com.pluralsight.menu;


public class PizzaPrice {
   public static double calculatePizzaPrice (Pizza pizza) {
       double basePrice = switch(pizza.getSize()){
           case 8 -> 8.50;
           case 12 -> 12;
           case 16 -> 16.50;
           default -> throw new IllegalArgumentException("Invalid pizza size");
       };

       double meatPrice = pizza.getMeats().size() * switch(pizza.getSize()){
           case 8 -> 1;
           case 12 -> 2;
           case 16 -> 3;
           default -> 0;
       };

       double cheesePrice = pizza.getCheese().size() * switch (pizza.getSize()){
           case 8 -> 0.75;
           case 12 -> 1.50;
           case 16 -> 2.25;
           default -> 0;
       };

       double extraMeatPrice = pizza.getExtraMeatCounts() * switch(pizza.getSize()){
           case 8 -> 0.50;
           case 12 -> 1;
           case 16 -> 1.50;
           default -> 0;
       };

       double extraCheesePrice = pizza.getExtraCheeseCounts() * switch (pizza.getSize()){
           case 8 -> 0.30;
           case 12 -> 0.60;
           case 16 -> 0.90;
           default -> 0;
       };
       return basePrice + meatPrice + cheesePrice + extraMeatPrice + extraCheesePrice;
   }

}
