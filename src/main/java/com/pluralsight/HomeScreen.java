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
        while(!meatList.contains(pizzaMeat)){
            System.out.println("Choose meats: ");
            meatList.forEach(meat -> {
                System.out.println("----" + meat);
            });
            System.out.print("Enter your choice: ");
            pizzaMeat = scanner.nextLine();
            if(!meatList.contains(pizzaMeat)){
                System.out.println("Invalid choice");
            }
        }
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
            System.out.print("Would you like to add another meat?(yes/no)");
            extraMeat = scanner.nextLine();
            customPizza.addMeat(meatExtra);
        }

       // cheese
        String pizzaCheese = "";
        while(!cheeseList.contains(pizzaCheese)){
            System.out.println("Choose cheese");
            cheeseList.forEach(cheese -> {
                System.out.println("----" + cheese);
            });
            System.out.print("Enter your choice: ");
            pizzaCheese = scanner.nextLine();
            if(!cheeseList.contains(pizzaCheese)){
                System.out.println("Invalid choice");
            }
        }
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
            System.out.print("Would you like to add another extra cheese?(yes/no)");
            extraCheese = scanner.nextLine();
            customPizza.addCheese(cheeseExtra);
        }

        //regular toppings
        String pizzaTopping = "";
        while(!toppingsList.contains(pizzaTopping)){
            System.out.println("Choose topping :");
            toppingsList.forEach(topping -> {
                System.out.println("----" + topping);
            });
            System.out.print("Enter your choice: ");
            pizzaTopping = scanner.nextLine();
            if(!toppingsList.contains(pizzaTopping)){
                System.out.println("Invalid choice");
            }
        }
        customPizza.addToppings(pizzaTopping);

        //extra regular toppings
        System.out.println("Would you like to add extra topping?(yes/no) ");
        String extraTopping = scanner.nextLine();
        while(extraTopping.equalsIgnoreCase("yes")) {
            toppingsList.forEach(topping -> {
                System.out.println("----" + topping);
            });
            System.out.print("Enter your choice: ");
            String toppingExtra = scanner.nextLine();
            System.out.println("Would you like to add extra topping?(yes/no)");
            extraTopping = scanner.nextLine();
            customPizza.addToppings(toppingExtra);
        }

        //sauces

        String pizzaSauce = "";
        while(!saucesList.contains(pizzaSauce)){
            System.out.println("Choose sauce :");
            saucesList.forEach(sauce -> {
                System.out.println("----" + sauce);
            });
            System.out.print("Enter your choice: ");
            pizzaSauce = scanner.nextLine();
            if(!saucesList.contains(pizzaSauce)){
                System.out.println("Invalid choice");
            }
        }
        customPizza.addSauces(pizzaSauce);

        //extra sauce

        System.out.println("Would you like to add extra sauce?(yes/no)");
        String extraSauce = scanner.nextLine();
        while(extraSauce.equalsIgnoreCase("yes")) {
            saucesList.forEach(sauce -> {
                System.out.println("----" + sauce);
            });
            System.out.print("Enter your choice: ");
            String sauceExtra = scanner.nextLine();
            System.out.println("Would you like to add extra sauce?(yes/no)");
            extraSauce = scanner.nextLine();
            customPizza.addSauces(sauceExtra);
        }

        //sides
        String pizzaSide = "";
        while(!sidesList.contains(pizzaSide)){
            System.out.println("Choose side :");
            sidesList.forEach(side -> {
                System.out.println("----" + side);
            });
            System.out.print("Enter your choice: ");
            pizzaSide = scanner.nextLine();
            if(!sidesList.contains(pizzaSide)){
                System.out.println("Invalid choice");
            }
        }
        customPizza.addSides(pizzaSide);
        //extra sides
        System.out.print("Would you like to add extra side?(yes/no)");
        String extraSide = scanner.nextLine();
        while(extraSide.equalsIgnoreCase("yes")) {
            sidesList.forEach(side -> {
                System.out.println("----" + side);
            });
            System.out.print("Enter your choice: ");
            String sideExtra = scanner.nextLine();
            System.out.println("Would you like to add extra side?(yes/no)");
            extraSide = scanner.nextLine();
            customPizza.addSides(sideExtra);
        }

        order.addItem(customPizza);
        System.out.println("Pizza has been added to your order!");

    }

}

