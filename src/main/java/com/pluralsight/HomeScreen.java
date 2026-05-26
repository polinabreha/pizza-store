package com.pluralsight;
import com.pluralsight.menu.*;

import java.util.Scanner;

import static com.pluralsight.menu.Pizza.*;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    orderScreen(scanner);
                    break;
                case 0:
                    exit = true;
                     break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    public static void orderScreen(Scanner scanner) {
        boolean exit = false;
        System.out.println("1. Add Pizza\n" +
                "2. Add Drink\n" +
                "3. Add Garlic Knots\n" +
                "4. Checkout\n" +
                "0. Cancel Order ");
        System.out.print("Choose from the following options : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addPizza(scanner , new Order());
                break;
            case 2 :
                //add drink();
                break;
            case 3 :
                //add garlic knots();
                break;
            case 4:
                //checkout();
                break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice");


        }
    }

    public static void addPizza(Scanner scanner, Order order) {
       // System.out.print("What pizza size would you like to add?(8 , 12,16) ");
        //int size = scanner.nextInt();
        //scanner.nextLine();

        int size = 0;
        while (size != 8 && size != 12 && size != 16) {
            System.out.print("What pizza size would you like to add?(8 , 12,16) ");
            size = scanner.nextInt();
            scanner.nextLine();
            if (size != 8 && size != 12 && size != 16) {
                System.out.println("Invalid choice");
            }
        }
        CustomPizza customPizza = new CustomPizza(size);

        //crust
        System.out.println("Choose the crust : ");
        crustList.forEach(crust -> {
            System.out.println("----" + crust);
        } );

        System.out.print("Enter your choice: ");
        String pizzaCrust = scanner.nextLine();
        if(!crustList.contains(pizzaCrust)){
            System.out.println("Invalid choice");
            return;
        }
        customPizza.addCrust(pizzaCrust);

        //meats
        System.out.println("Choose meats: ");
        meatList.forEach(meat -> {
            System.out.println("----" + meat);
        });
        System.out.print("Enter your choice: ");
        String pizzaMeat = scanner.nextLine();
        customPizza.addMeat(pizzaMeat);

        //extra meat
        System.out.print("Would you like to add extra meat?(yes/no)");
        String extraMeat = scanner.nextLine();

        while (extraMeat.equalsIgnoreCase("yes")) {
            meatList.forEach(meat -> {
                System.out.println("----" + meat);
            });
            System.out.print("Enter your choice: ");
            String meatExtra = scanner.nextLine();
            customPizza.addMeat(meatExtra);
            System.out.print("Would you like to add another meat?(yes/no)");
            extraMeat = scanner.nextLine();

        }
       // cheese
        System.out.println("Choose cheese");
        cheeseList.forEach(cheese -> {
            System.out.println("----" + cheese);
        });
        System.out.print("Enter your choice: ");
        String pizzaCheese = scanner.nextLine();
        customPizza.addCheese(pizzaCheese);

        //extra cheese
        System.out.println("Would you like to add extra cheese?(yes/no) ");
        String extraCheese = scanner.nextLine();
        while (extraCheese.equalsIgnoreCase("yes")) {
            cheeseList.forEach(cheese -> {
                System.out.println("----" + cheese);
            });
            System.out.print("Enter your choice: ");
            String cheeseExtra = scanner.nextLine();
            customPizza.addCheese(cheeseExtra);
            System.out.print("Would you like to add another extra cheese?(yes/no)");
            extraCheese = scanner.nextLine();
        }

        //regular toppings

        System.out.println("Choose topping :");
        toppingsList.forEach(topping -> {
            System.out.println("----" + topping);
        });
        System.out.print("Enter your choice: ");
        String pizzaTopping = scanner.nextLine();

        //extra regular toppings
        System.out.println("Would you like to add extra topping?(yes/no) ");
        String extraTopping = scanner.nextLine();
        while(extraTopping.equalsIgnoreCase("yes")) {
            toppingsList.forEach(topping -> {
                System.out.println("----" + topping);
            });
            System.out.print("Enter your choice: ");
            String toppingExtra = scanner.nextLine();
            customPizza.addToppings(toppingExtra);
            System.out.println("Would you like to add extra topping?(yes/no)");
            extraTopping = scanner.nextLine();
        }

        //sauces
        System.out.println("Choose sauce :");
        saucesList.forEach(sauce -> {
            System.out.println("----" + sauce);
        });
        System.out.print("Enter your choice: ");
        String pizzaSauce = scanner.nextLine();

        //extra sauce

        System.out.println("Would you like to add extra sauce?(yes/no)");
        String extraSauce = scanner.nextLine();
        while(extraSauce.equalsIgnoreCase("yes")) {
            saucesList.forEach(sauce -> {
                System.out.println("----" + sauce);
            });
            System.out.print("Enter your choice: ");
            String sauceExtra = scanner.nextLine();
            customPizza.addSauces(sauceExtra);
            System.out.println();
        }

    }

}

