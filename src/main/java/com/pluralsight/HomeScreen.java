package com.pluralsight;
import com.pluralsight.menu.*;
import com.pluralsight.design.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.menu.Pizza.*;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ASCII.storeLogo();
        homeScreen(scanner);

    }

    public static void homeScreen(Scanner scanner) {
        try {
            boolean exit = false;
            System.out.println(Colors.YELLOW + "\t\t\t\tWELCOME to the PIZZA STORE" + Colors.ANSI_RESET);
            while (!exit) {
                System.out.println("1. New Order ");
                System.out.println("0. Exit ");
                System.out.print(Colors.BACKGROUND_YELLOW + "Choose from the following options : " + Colors.ANSI_RESET);
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
        }catch (InputMismatchException e) {
            System.out.println("Invalid input" + e.getMessage());
        }
    }

    public static void orderScreen(Scanner scanner , Order order) {
        try {
            boolean exit = false;
            while (!exit) {
                System.out.println(Colors.ANSI_RED + "1. Add Pizza\n" + Colors.ANSI_RESET +
                        Colors.YELLOW + "2. Signature Pizzas\n" + Colors.ANSI_RESET +
                        Colors.ANSI_RED + "3. Add Drink\n" + Colors.ANSI_RESET +
                        Colors.YELLOW + "4. Add Garlic Knots\n" + Colors.ANSI_RESET +
                        Colors.ANSI_RED + "5. Cart\n" + Colors.ANSI_RESET +
                        Colors.YELLOW + "6. Checkout\n" + Colors.ANSI_RESET +
                        Colors.ANSI_RED + "0. Cancel Order " + Colors.ANSI_RESET);
                System.out.print(Colors.BACKGROUND_YELLOW + "Choose from the following options : " + Colors.ANSI_RESET);
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addPizza(scanner, order);
                        break;
                    case 2:
                        signaturePizza(scanner, order);
                        break;
                    case 3:
                        addDrink(scanner, order);
                        break;
                    case 4:
                        addGarlicKnots(order);
                        break;
                    case 5:
                        cart(scanner, order);
                        break;
                    case 6:
                        checkOut(scanner, order);
                        exit = true;
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input" + e.getMessage());
        }
    }

    public static void addPizza(Scanner scanner, Order order) {
        try {
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
            while (!crustList.contains(pizzaCrust)) {
                System.out.println("Choose the crust : ");
                crustList.forEach(crust -> {
                    System.out.println("----" + crust);
                });
                System.out.print("Enter your choice: ");
                pizzaCrust = scanner.nextLine();
                if (!crustList.contains(pizzaCrust)) {
                    System.out.println("Invalid choice");
                }
            }
            customPizza.addCrust(pizzaCrust);

            //meats
            String pizzaMeat = "";
            while (!meatList.contains(pizzaMeat) && !pizzaMeat.equals("skip")) {
                System.out.println("Choose the meat : ");
                meatList.forEach(meat -> {
                    System.out.println("----" + meat);
                });
                System.out.print("Enter your choice or 'skip': ");
                pizzaMeat = scanner.nextLine();
                if (!meatList.contains(pizzaMeat) && !pizzaMeat.equals("skip")) {
                    System.out.println("Invalid choice");
                }
            }
            if (!pizzaMeat.equals("skip")) {
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
            while (!cheeseList.contains(pizzaCheese) && !pizzaCheese.equals("skip")) {
                System.out.println("Choose cheese");
                cheeseList.forEach(cheese -> {
                    System.out.println("----" + cheese);
                });
                System.out.print("Enter your choice or 'skip': ");
                pizzaCheese = scanner.nextLine();
                if (!cheeseList.contains(pizzaCheese) && !pizzaCheese.equals("skip")) {
                    System.out.println("Invalid choice");
                }
            }
            if (!pizzaCheese.equals("skip")) {
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
            while (!toppingsList.contains(pizzaTopping) && !pizzaTopping.equals("skip")) {
                System.out.println("Choose topping :");
                toppingsList.forEach(topping -> {
                    System.out.println("----" + topping);
                });
                System.out.print("Enter your choice or 'skip': ");
                pizzaTopping = scanner.nextLine();
                if (!toppingsList.contains(pizzaTopping) && !pizzaTopping.equals("skip")) {
                    System.out.println("Invalid choice");
                }
            }
            if (!pizzaTopping.equals("skip")) {
                customPizza.addToppings(pizzaTopping);
            }


            //extra regular toppings
            System.out.print("Would you like to add extra topping?(yes/no) ");
            String extraTopping = scanner.nextLine();
            while (extraTopping.equalsIgnoreCase("yes")) {
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
            while (!saucesList.contains(pizzaSauce) && !pizzaSauce.equals("skip")) {
                System.out.println("Choose sauce :");
                saucesList.forEach(sauce -> {
                    System.out.println("----" + sauce);
                });
                System.out.print("Enter your choice or 'skip': ");
                pizzaSauce = scanner.nextLine();
                if (!saucesList.contains(pizzaSauce) && !pizzaSauce.equals("skip")) {
                    System.out.println("Invalid choice");
                }
            }
            if (!pizzaSauce.equals("skip")) {
                customPizza.addSauces(pizzaSauce);
            }


            //extra sauce

            System.out.print("Would you like to add extra sauce?(yes/no)");
            String extraSauce = scanner.nextLine();
            while (extraSauce.equalsIgnoreCase("yes")) {
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
            while (!sidesList.contains(pizzaSide) && !pizzaSide.equals("skip")) {
                System.out.println("Choose side :");
                sidesList.forEach(side -> {
                    System.out.println("----" + side);
                });
                System.out.print("Enter your choice or 'skip': ");
                pizzaSide = scanner.nextLine();
                if (!sidesList.contains(pizzaSide) && !pizzaSide.equals("skip")) {
                    System.out.println("Invalid choice");
                }
            }
            if (!pizzaSide.equals("skip")) {
                customPizza.addSides(pizzaSide);
            }

            //extra sides
            System.out.print("Would you like to add extra side?(yes/no)");
            String extraSide = scanner.nextLine();
            while (extraSide.equalsIgnoreCase("yes")) {
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
            if (stuffedCrust.equalsIgnoreCase("yes")) {
                customPizza.setStuffedCrust(true);
            }

            order.addItem(customPizza);
            System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW + "Pizza has been added to your order!" + Colors.ANSI_RESET);
        }catch (Exception e) {
            System.out.println(" Please try again..." + e.getMessage());
        }

    }

    public static void signaturePizza(Scanner scanner, Order order) {
        try {
            System.out.println(Colors.HIGH_INTENSITY + Colors.ANSI_RED +"\tSignature Pizzas:" + Colors.ANSI_RESET);
            System.out.println(Colors.YELLOW + "1. Hawaiian Pizza"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED +"2. Margherita Pizza"+ Colors.ANSI_RESET);
            System.out.println(Colors.YELLOW + "3. Veggie Pizza"+ Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_RED +"4. Pepperoni Pizza"+ Colors.ANSI_RESET);
            System.out.println(Colors.YELLOW + "0. Go back"+ Colors.ANSI_RESET);
            System.out.print(Colors.HIGH_INTENSITY + Colors.ANSI_RED +"Enter your choice: "+ Colors.ANSI_RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();

            CustomPizza pizza = null;

            switch (choice) {
                case 1:
                    pizza = new HawaiianPizza(8);
                    break;
                case 2:
                    pizza = new MargheritaPizza(8);
                    break;
                case 3:
                    pizza = new VeggiePizza(8);
                    break;
                case 4:
                    pizza = new PepperoniPizza(8);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");

            }

            customisePizza(scanner, pizza);
            order.addItem(pizza);
        }catch (NumberFormatException e) {
            System.out.println("Invalid choice" + e.getMessage());
        }

    }

    public static void customisePizza(Scanner scanner, CustomPizza pizza) {
        try {
            System.out.println("========PIZZA DETAILS===========");
            System.out.println("Pizza:" + pizza.getName());
            System.out.println(pizza);

            System.out.print("Would you like to customise " + pizza.getName() + " (yes/no)");
            String customise = scanner.nextLine();

            if (customise.equalsIgnoreCase("yes")) {
                System.out.print("Choose size (8, 12, 16)");
                int size = Integer.parseInt(scanner.nextLine());
                pizza.setSize(size);
                customiseMeats(scanner, pizza);
                customiseCheese(scanner, pizza);
                customiseToppings(scanner, pizza);
                customiseSauces(scanner, pizza);
                customiseSides(scanner, pizza);
                System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW + "Pizza has been customised and added to your cart!" + Colors.ANSI_RESET);

            } else if (customise.equalsIgnoreCase("no")) {
                System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW + "Pizza has been added to your cart!" + Colors.ANSI_RESET);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
    }

   public static void customiseMeats (Scanner scanner, CustomPizza pizza) {
        try {
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
                boolean add = true;
                while (add) {
                    System.out.println("List of meats: " + meatList);
                    System.out.print("Enter name of the meat to be added (or enter done): ");
                    String addedMeat = scanner.nextLine();
                    if (addedMeat.equalsIgnoreCase("done")) {
                        add = false;
                    } else {
                        pizza.addMeat(addedMeat);
                    }
                }

            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
   }

   public static void customiseCheese(Scanner scanner, CustomPizza pizza) {
        try {
            System.out.print("Would you like to remove cheese?(yes/no)");
            String cheese = scanner.nextLine();
            if (cheese.equalsIgnoreCase("yes")) {
                System.out.println("Cheese: " + pizza.getCheese());
                System.out.print("Enter name of the cheese to be removed: ");
                String removedCheese = scanner.nextLine();
                pizza.removeCheese(removedCheese);
            }
            System.out.print("Would you like to add cheese?(yes/no)");
            String choice = scanner.nextLine();


            if (choice.equalsIgnoreCase("yes")) {
                boolean add = true;
                while (add) {
                    System.out.println("List of cheeses: " + cheeseList);
                    System.out.print("Enter name of the cheese to be added (or enter done): ");
                    String addedCheese = scanner.nextLine();
                    if (addedCheese.equalsIgnoreCase("done")) {
                        add = false;
                    } else {
                        pizza.addCheese(addedCheese);
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
   }

   public static void customiseToppings(Scanner scanner, CustomPizza pizza) {
        try {
            System.out.print("Would you like to remove toppings?(yes/no)");
            String toppings = scanner.nextLine();
            if (toppings.equalsIgnoreCase("yes")) {
                boolean remove = true;
                while (remove) {
                    System.out.println("Toppings: " + pizza.getToppings());
                    System.out.print("Enter name of the topping to be removed (or enter done): ");
                    String removedTopping = scanner.nextLine();
                    if (removedTopping.equalsIgnoreCase("done")) {
                        remove = false;
                    } else {
                        pizza.removeToppings(removedTopping);
                    }
                }
            }

            System.out.print("Would you like to add toppings?(yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                boolean add = true;
                while (add) {
                    System.out.println("Toppings: " + toppingsList);
                    System.out.print("Enter name of the topping to be added (or enter done): ");
                    String addedTopping = scanner.nextLine();
                    if (addedTopping.equalsIgnoreCase("done")) {
                        add = false;
                    } else {
                        pizza.addToppings(addedTopping);
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
   }

   public static void customiseSauces(Scanner scanner, CustomPizza pizza) {
        try {
            System.out.print("Would you like to remove sauces (yes/no)");
            String sauces = scanner.nextLine();
            if (sauces.equalsIgnoreCase("yes")) {
                boolean remove = true;
                while (remove) {
                    System.out.println("Sauces: " + pizza.getSauces());
                    System.out.print("Enter name of the sauce to be removed (or enter done): ");
                    String removedSauces = scanner.nextLine();
                    if (removedSauces.equalsIgnoreCase("done")) {
                        remove = false;
                    } else {
                        pizza.removeSauces(removedSauces);
                    }
                }
            }
            System.out.print("Would you like to add sauce?(yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                boolean add = true;
                while (add) {
                    System.out.println("Sauces: " + pizza.getSauces());
                    System.out.print("Enter name of the sauce to be added (or enter done): ");
                    String addedSauces = scanner.nextLine();
                    if (addedSauces.equalsIgnoreCase("done")) {
                        add = false;
                    } else {
                        pizza.addSauces(addedSauces);
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
   }

   public static void customiseSides(Scanner scanner, CustomPizza pizza) {
        try {
            System.out.print("Would you like to remove sides?(yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                boolean remove = true;
                while (remove) {
                    System.out.println("Sides: " + pizza.getSides());
                    System.out.print("Enter name of the side to be removed (or enter done): ");
                    String removedSides = scanner.nextLine();
                    if (removedSides.equalsIgnoreCase("done")) {
                        remove = false;
                    } else {
                        pizza.removeSides(removedSides);
                    }
                }
            }
            System.out.print("Would you like to add sides (yes/no)");
            String sides = scanner.nextLine();
            if (sides.equalsIgnoreCase("yes")) {
                boolean add = true;
                while (add) {
                    System.out.println("Sides: " + pizza.getSides());
                    System.out.print("Enter name of the side to be added (or enter done): ");
                    String addedSides = scanner.nextLine();
                    if (addedSides.equalsIgnoreCase("done")) {
                        add = false;
                    } else {
                        pizza.addSides(addedSides);
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
   }


    public static void addDrink(Scanner scanner, Order order){
        try {
            String drinkName = "";

            while (!Drinks.drinkList.contains(drinkName)) {
                System.out.println("Drinks:");
                Drinks.drinkList.forEach(drinks ->
                        System.out.println("----" + drinks));

                System.out.print("Choose the drink from the following options:");
                drinkName = scanner.nextLine().toLowerCase();
                if (!Drinks.drinkList.contains(drinkName)) {
                    System.out.println("Invalid choice");
                }
            }
            String drinkSize = "";
            while (!Drinks.sizeList.contains(drinkSize)) {
                System.out.println("Sizes: ");
                Drinks.sizeList.forEach(drinks ->
                        System.out.println("----" + drinks));
                System.out.print("Choose the drink size from the following options:");
                drinkSize = scanner.nextLine();
                if (!Drinks.sizeList.contains(drinkSize)) {
                    System.out.println("Invalid choice");
                }
            }
            Drinks drink = new Drinks(drinkName, drinkSize);
            order.addItem(drink);
            System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW +"Drink has been added to your order!" + Colors.ANSI_RESET);
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }

    }

    public static void addGarlicKnots(Order order){
        Sides garlicKnots = new Sides("Garlic Knots", 1.50);
        order.addItem(garlicKnots);
        System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW + "Garlic Knots has been added to your order!"  + Colors.ANSI_RESET);
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

    public static void cart(Scanner scanner, Order order ){
        try {
            viewCart(order);
            System.out.print(Colors.HIGH_INTENSITY + Colors.YELLOW + "\nWould you like to remove something from the cart? (yes/no)" + Colors.ANSI_RESET);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.print("Enter the number of the item to be removed (or enter 0 to finish): ");
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (itemNumber == 0) {
                        break;
                    }

                    boolean remove = order.removeItem(itemNumber - 1);
                    if (!remove) {
                        System.out.println("Item could not be removed!");
                        return;
                    } else {
                        System.out.println(Colors.HIGH_INTENSITY + Colors.YELLOW + "Item has been removed!" + Colors.ANSI_RESET);
                    }

                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }

    }

    public static void viewCart( Order order){
        System.out.println("========CART========");
        if (order.getItems().isEmpty()){
            System.out.println("There are no items in your order!");
            return;
        }

        List<MenuItem> items = order.getItems();

        for (int i = 0; i<items.size(); i++){
            System.out.println((i + 1) + ". " + items.get(i).getName());
            System.out.println(items.get(i));
        }


        System.out.printf("\nTotal : " + "$%.2f", order.calculateTotalPrice());
    }

    public static void checkOut(Scanner scanner, Order order){
        try {
            if (!isValidOrder(order)) {
                System.out.println("Invalid order!");
                return;
            }

            System.out.println("======ORDER======");
            for (MenuItem item : order.getItems()) {
                System.out.println("----" + item);
            }
            System.out.println("-------------------");
            System.out.println("Total: $" + String.format("%.2f", order.calculateTotalPrice()));
            System.out.print("Confirm or cancel?");
            String confirmOrCancel = scanner.nextLine();
            if (confirmOrCancel.equalsIgnoreCase("confirm")) {
                Receipt.transaction(Receipt.buildReceipt(order));
                System.out.println("Your receipt has been successfully saved!");
            } else if (confirmOrCancel.equalsIgnoreCase("cancel")) {
                System.out.println("Your order has been successfully deleted!");
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice" + e.getMessage());
        }
    }

}

