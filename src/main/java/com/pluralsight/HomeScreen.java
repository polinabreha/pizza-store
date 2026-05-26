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

        }
    }

    public static void addPizza(Scanner scanner, Order order) {
        System.out.println("What pizza size would you like to add?(8 , 12,16) ");
        int size = scanner.nextInt();
        scanner.nextLine();
        CustomPizza customPizza = new CustomPizza(size);

        System.out.println("Choose the crust : ");
        crustList.stream().forEach(crust -> {
            System.out.println("----" + crust);
        } );

        System.out.print("Enter your choice: ");
        String pizzaCrust = scanner.nextLine();
        customPizza.addCrust(pizzaCrust);

        System.out.println("Choose toppings: ");
        meatList.stream().forEach(meat -> {
            System.out.println("----" + meat);
        });
        System.out.print("Enter your choice: ");
        String pizzaMeat = scanner.nextLine();
        customPizza.addMeat(pizzaMeat);

        System.out.print("Would you like to add extra meat?(yes/no)");
        String extraMeat = scanner.nextLine();

        while (extraMeat.equalsIgnoreCase("yes")) {
            meatList.stream().forEach(meat -> {
                System.out.println("----" + meat);
            });
            System.out.print("Enter your choice: ");
            String meatExtra = scanner.nextLine();
            customPizza.addMeat(meatExtra);
            System.out.print("Would you like to add another meat?(yes/no)");
            extraMeat = scanner.nextLine();

        }

        cheeseList.stream().forEach(cheese -> {
            System.out.println("----" + cheese);
        });
        System.out.print("Enter your choice: ");
        String pizzaCheese = scanner.nextLine();
        customPizza.addCheese(pizzaCheese);

        System.out.println("Would you like to add extra cheese?(yes/no) ");
        String extraCheese = scanner.nextLine();
        while (extraCheese.equalsIgnoreCase("yes")) {
            cheeseList.stream().forEach(cheese -> {
                System.out.println("----" + cheese);
            });
            System.out.print("Enter your choice: ");
            String cheeseExtra = scanner.nextLine();
            customPizza.addCheese(cheeseExtra);
            System.out.print("Would you like to add another extra cheese?(yes/no)");
            extraCheese = scanner.nextLine();
        }

    }

}

