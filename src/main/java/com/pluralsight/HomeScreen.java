package com.pluralsight;
import com.pluralsight.menu.*;
import com.pluralsight.design.*;

import java.util.Scanner;

import static com.pluralsight.menu.Pizza.*;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ASCII.storeLogo();
        homeScreen(scanner);

    }

    public static void homeScreen(Scanner scanner) {
        boolean exit = false;
        System.out.println("Welcome to the Pizza Store");
        while (!exit) {

            System.out.println("1. New Order ");
            System.out.println("0. Exit ");
            System.out.print("Choose from the following options : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Order order = new Order();
                    orderScreen(scanner, order);
                    break;
                case 0:
                    exit = true;
                     break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    public static void orderScreen(Scanner scanner , Order order) {
        boolean exit = false;
        while (!exit) {
        System.out.println("1. Add Pizza\n" +
                "2. Signature Pizzas\n" +
                "3. Add Drink\n" +
                "4. Add Garlic Knots\n" +
                "5. Checkout\n" +
                "0. Cancel Order ");
        System.out.print("Choose from the following options : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addPizza(scanner , order);
                break;
            case 2:
                //signaturepizza();
                break;
            case 3 :
                addDrink(scanner , order);
                break;
            case 4 :
                addGarlicKnots(order);
                break;
            case 5:
                checkOut(scanner , order);
                exit = true;
                break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice");

        }
        }
    }

    public static void addPizza(Scanner scanner, Order order) {
        int size = 0;
        while (size != 8 && size != 12 && size != 16) {
            System.out.print("What pizza size would you like to add?(8, 12, 16) ");
            size = scanner.nextInt();
            scanner.nextLine();
            if (size != 8 && size != 12 && size != 16) {
                System.out.println("Invalid choice");
            }
        }
        CustomPizza customPizza = new CustomPizza(size);

        //crust
        String pizzaCrust = "";
        while(!crustList.contains(pizzaCrust)){
            System.out.println("Choose the crust : ");
            crustList.forEach(crust -> {
                System.out.println("----" + crust);
            } );
            System.out.print("Enter your choice: ");
            pizzaCrust = scanner.nextLine();
            if(!crustList.contains(pizzaCrust)){
                System.out.println("Invalid choice");
            }
        }
        customPizza.addCrust(pizzaCrust);

        //meats
        String pizzaMeat = "";
        while(!meatList.contains(pizzaMeat) && !pizzaMeat.equals("skip")){
            System.out.println("Choose the meat : ");
            meatList.forEach(meat -> {
                System.out.println("----" + meat);
            });
            System.out.print("Enter your choice or 'skip': ");
            pizzaMeat = scanner.nextLine();
            if(!meatList.contains(pizzaMeat) && !pizzaMeat.equals("skip")){
                System.out.println("Invalid choice");
            }
        }
        if(!pizzaMeat.equals("skip")){
            customPizza.addMeat(pizzaMeat);
        }

        //extra meat
        System.out.print("Would you like to add extra meat?(yes/no)");
        String extraMeat = scanner.nextLine();

        while (extraMeat.equalsIgnoreCase("yes")) {
            meatList.forEach(meat -> {
                System.out.println("----" + meat);
            });
            System.out.print("Enter your choice: ");
            String meatExtra = scanner.nextLine();
            System.out.print("Would you like to add another meat?(yes/no)");
            extraMeat = scanner.nextLine();
            customPizza.addMeat(meatExtra);
        }

       // cheese
        String pizzaCheese = "";
        while(!cheeseList.contains(pizzaCheese)&& !pizzaCheese.equals("skip")){
            System.out.println("Choose cheese");
            cheeseList.forEach(cheese -> {
                System.out.println("----" + cheese);
            });
            System.out.print("Enter your choice or 'skip': ");
            pizzaCheese = scanner.nextLine();
            if(!cheeseList.contains(pizzaCheese) && !pizzaCheese.equals("skip")){
                System.out.println("Invalid choice");
            }
        }
        if(!pizzaCheese.equals("skip")){
            customPizza.addCheese(pizzaCheese);
        }


        //extra cheese
        System.out.print("Would you like to add extra cheese?(yes/no) ");
        String extraCheese = scanner.nextLine();
        while (extraCheese.equalsIgnoreCase("yes")) {
            cheeseList.forEach(cheese -> {
                System.out.println("----" + cheese);
            });
            System.out.print("Enter your choice: ");
            String cheeseExtra = scanner.nextLine();
            System.out.print("Would you like to add another extra cheese?(yes/no)");
            extraCheese = scanner.nextLine();
            customPizza.addCheese(cheeseExtra);
        }

        //regular toppings
        String pizzaTopping = "";
        while(!toppingsList.contains(pizzaTopping) && !pizzaTopping.equals("skip")){
            System.out.println("Choose topping :");
            toppingsList.forEach(topping -> {
                System.out.println("----" + topping);
            });
            System.out.print("Enter your choice or 'skip': ");
            pizzaTopping = scanner.nextLine();
            if(!toppingsList.contains(pizzaTopping) && !pizzaTopping.equals("skip")){
                System.out.println("Invalid choice");
            }
        }
        if(!pizzaTopping.equals("skip")){
            customPizza.addToppings(pizzaTopping);
        }


        //extra regular toppings
        System.out.print("Would you like to add extra topping?(yes/no) ");
        String extraTopping = scanner.nextLine();
        while(extraTopping.equalsIgnoreCase("yes")) {
            toppingsList.forEach(topping -> {
                System.out.println("----" + topping);
            });
            System.out.print("Enter your choice: ");
            String toppingExtra = scanner.nextLine();
            System.out.print("Would you like to add extra topping?(yes/no)");
            extraTopping = scanner.nextLine();
            customPizza.addToppings(toppingExtra);
        }

        //sauces

        String pizzaSauce = "";
        while(!saucesList.contains(pizzaSauce) && !pizzaSauce.equals("skip")){
            System.out.println("Choose sauce :");
            saucesList.forEach(sauce -> {
                System.out.println("----" + sauce);
            });
            System.out.print("Enter your choice or 'skip': ");
            pizzaSauce = scanner.nextLine();
            if(!saucesList.contains(pizzaSauce) && !pizzaSauce.equals("skip")){
                System.out.println("Invalid choice");
            }
        }
        if(!pizzaSauce.equals("skip")){
            customPizza.addSauces(pizzaSauce);
        }


        //extra sauce

        System.out.print("Would you like to add extra sauce?(yes/no)");
        String extraSauce = scanner.nextLine();
        while(extraSauce.equalsIgnoreCase("yes")) {
            saucesList.forEach(sauce -> {
                System.out.println("----" + sauce);
            });
            System.out.print("Enter your choice: ");
            String sauceExtra = scanner.nextLine();
            System.out.print("Would you like to add extra sauce?(yes/no)");
            extraSauce = scanner.nextLine();
            customPizza.addSauces(sauceExtra);
        }

        //sides
        String pizzaSide = "";
        while(!sidesList.contains(pizzaSide) && !pizzaSide.equals("skip")){
            System.out.println("Choose side :");
            sidesList.forEach(side -> {
                System.out.println("----" + side);
            });
            System.out.print("Enter your choice or 'skip': ");
            pizzaSide = scanner.nextLine();
            if(!sidesList.contains(pizzaSide) && !pizzaSide.equals("skip")){
                System.out.println("Invalid choice");
            }
        }
        if(!pizzaSide.equals("skip")){
            customPizza.addSides(pizzaSide);
        }

        //extra sides
        System.out.print("Would you like to add extra side?(yes/no)");
        String extraSide = scanner.nextLine();
        while(extraSide.equalsIgnoreCase("yes")) {
            sidesList.forEach(side -> {
                System.out.println("----" + side);
            });
            System.out.print("Enter your choice: ");
            String sideExtra = scanner.nextLine();
            System.out.print("Would you like to add extra side?(yes/no)");
            extraSide = scanner.nextLine();
            customPizza.addSides(sideExtra);
        }

        System.out.print("Would you like to add stuffed crust?(yes/no)");
        String stuffedCrust = scanner.nextLine();
        if(stuffedCrust.equalsIgnoreCase("yes")) {
            customPizza.setStuffedCrust(true);
        }

        order.addItem(customPizza);
        System.out.println("Pizza has been added to your order!");

    }

    public static void signaturePizza(Scanner scanner, Order order) {
        System.out.println("\tSignature Pizza:");
        System.out.println("1. Hawaiian Pizza");
        System.out.println("2. Margherita Pizza");
        System.out.println("3. Veggie Pizza");
        System.out.println("4. Pepperoni Pizza");
        System.out.println("0. Go back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                //hawaiianPizza();
                break;
            case 2:
                //margheritaPizza();
                break;
            case 3:
                //veggiePizza();
                break;
            case  4:
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice");

        }




    }

        public static void customisePizza(Scanner scanner, CustomPizza pizza) {
            System.out.println("========PIZZA DETAILS===========");
            System.out.println("Pizza:" + pizza.getName());
            System.out.println(pizza);

            System.out.print("Would you like to customise " + pizza.getName() + " (yes/no)");
            String customise = scanner.nextLine();

            if(customise.equalsIgnoreCase("yes")) {
                System.out.print("Choose size (8, 12, 16)");
                int size = Integer.parseInt(scanner.nextLine());
                pizza = new CustomPizza(size);

            }

        }

        public static void customiseMeats (Scanner scanner, CustomPizza pizza) {
            if (!pizza.getMeats().isEmpty()) {
                System.out.print("Would you like to remove meats?(yes/no)");
                String meats = scanner.nextLine();
                if (meats.equalsIgnoreCase("yes")) {
                    System.out.println("Meats: " + pizza.getMeats());
                    System.out.print("Enter name of the meat to be removed: ");
                    String removedMeat = scanner.nextLine();
                    pizza.removeMeat(removedMeat);
                }
            }
            System.out.print("would you like to add meats?(yes/no)");
            String meats = scanner.nextLine();
            if (meats.equalsIgnoreCase("yes")) {
                System.out.println("List of meats: " + meatList);
                System.out.print("Enter name of the meat to be added: ");
                String addedMeat = scanner.nextLine();
                pizza.addMeat(addedMeat);
            }
        }

    public static void addDrink(Scanner scanner, Order order){
        String drinkName = "";

        while(!Drinks.drinkList.contains(drinkName)){
            System.out.println("Drinks:");
            Drinks.drinkList.forEach(drinks ->
                System.out.println("----" + drinks));

                System.out.print("Choose the drink from the following options:");
                drinkName = scanner.nextLine().toLowerCase();
                if(!Drinks.drinkList.contains(drinkName)){
                    System.out.println("Invalid choice");
                }
        }
        String drinkSize = "";
        while(!Drinks.sizeList.contains(drinkSize)){
            System.out.println("Sizes: ");
            Drinks.sizeList.forEach(drinks ->
                System.out.println("----" + drinks));
            System.out.print("Choose the drink size from the following options:");
            drinkSize = scanner.nextLine();
            if(!Drinks.sizeList.contains(drinkSize)){
                System.out.println("Invalid choice");
            }
        }
        Drinks drink = new Drinks(drinkName ,drinkSize );
        order.addItem(drink);
        System.out.println("Drink has been added to your order!");

    }

    public static void addGarlicKnots(Order order){
        Sides garlicKnots = new Sides("Garlic Knots", 1.50);
        order.addItem(garlicKnots);
        System.out.println("Garlic Knots has been added to your order!");
    }

    public static boolean isValidOrder(Order order){
        boolean hasPizza = false;
        boolean hasOtherThings = false;

        for(MenuItem item : order.getItems()){
            if (item instanceof Pizza){
                hasPizza = true;
            }

            if (item instanceof Drinks || item instanceof Sides){
                hasOtherThings = true;
            }
        }

        return hasPizza || hasOtherThings;
    }

    public static void checkOut(Scanner scanner, Order order){
        if(!isValidOrder(order)){
            System.out.println("Invalid order!");
            return;
        }

        System.out.println("======ORDER======");
        for(MenuItem item : order.getItems()){
            System.out.println("----" + item );
        }
        System.out.println("-------------------");
        System.out.println("Total: $" + String.format("%.2f",order.calculateTotalPrice()));
        System.out.print("Confirm or cancel?");
        String confirmOrCancel = scanner.nextLine();
        if(confirmOrCancel.equalsIgnoreCase("confirm")){
            Receipt.transaction(Receipt.buildReceipt(order));
            System.out.println("Your receipt has been successfully saved!");
        }else if(confirmOrCancel.equalsIgnoreCase("cancel")){
            System.out.println("Your order has been successfully deleted!");
        }
    }

}

