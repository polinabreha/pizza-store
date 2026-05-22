package com.pluralsight.menu;


public class PizzaPrice {
   public static double calculatePizzaPrice (Pizza pizza) {

       int meatCount = pizza.getMeats().size();
       int cheeseCount = pizza.getCheese().size();

       int extraMeat = Math.max(0, meatCount - 1);
       int extraCheese = Math.max(0,cheeseCount);


       double basePrice = switch(pizza.getSize()){
           case 8 -> 8.50;
           case 12 -> 12;
           case 16 -> 16.50;
           default -> throw new IllegalArgumentException("Invalid pizza size");
       };

       double meatPrice = 0;

       if (meatCount > 0) {
          meatPrice += switch(pizza.getSize()) {
              case 8 -> 1.00;
              case 12 -> 2.00;
              case 16 -> 3.00;
              default -> 0;
          };
       }
       double cheesePrice = 0;

        if (cheeseCount > 0) {
          cheesePrice += switch (pizza.getSize()){
           case 8 -> 0.75;
           case 12 -> 1.50;
           case 16 -> 2.25;
           default -> 0;
          };

       }

       meatPrice += extraMeat * switch(pizza.getSize()){
           case 8 -> 0.50;
           case 12 -> 1;
           case 16 -> 1.50;
           default -> 0;
       };

       cheesePrice += extraCheese * switch (pizza.getSize()){
           case 8 -> 0.30;
           case 12 -> 0.60;
           case 16 -> 0.90;
           default -> 0;
       };
       return basePrice + meatPrice + cheesePrice ;
   }

}
