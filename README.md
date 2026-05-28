#          Pizza Store POS 🍕

Pizza store POS program is a java console application for a pizza restaurant.
The application guides users through building a full order — from a custom-built pizza 
to a signature recipe.
Orders are tracked in a cart, and completed transactions are saved as printed receipts.


---------

### FEATURES ✨✨✨

- ## Custom pizza builder 
    choose size (8", 12", 16"), crust, meats, cheese, toppings, sauces, sides, and optional stuffed crust, 
     with multi-ingredient support at every step.
-  ## Signature pizzas
   four preset recipes (Hawaiian, Margherita, Veggie, Pepperoni)
    that can be optionally customized before adding to the cart.

-  ## Drinks & sides
   dd drinks by name and size, or add Garlic Knots as a side item.

-  ## Cart management
   view all items and a running total at any time; remove items by position before checkout
- ## Receipt generation
  on checkout confirmation, a receipt is automatically built and saved to disk
- ## Input validation
     all inputs are validated with retry loops 
     and exception handling as try/catch.
------
## ORDER FLOW ⏳

```
Home Screen → New Order → Add Items → Review Cart → Checkout → Receipt Saved
```
 

-----

## PROJECT STRUCTURE 🤍

```
src/
└── com/
    └── pluralsight/
        ├── HomeScreen.java              # Entry point — drives all screens and interactions
        ├── design/
        │   ├── ASCII.java               # Store logo (ASCII art banner)
        │   └── Colors.java              # ANSI color codes for styled terminal output
        └── menu/
            ├── MenuItem.java            # Base interface for all orderable items
            ├── Pizza.java               # Base class with shared ingredient lists
            ├── CustomPizza.java         # Fully configurable pizza with add/remove methods
            ├── HawaiianPizza.java       # Signature pizza — preset ingredients
            ├── MargheritaPizza.java     # Signature pizza — preset ingredients
            ├── VeggiePizza.java         # Signature pizza — preset ingredients
            ├── PepperoniPizza.java      # Signature pizza — preset ingredients
            ├── Drinks.java              # Drink item with name and size-based pricing
            ├── Sides.java               # Side item (e.g. Garlic Knots) with fixed price
            ├── Order.java               # Holds cart items, calculates total, supports removal
            └── Receipt.java             # Builds and writes a receipt file for completed orders
```
 

------

## REPOSITORY GitHub LINK

https://github.com/polinabreha/pizza-store

-------


## Usage

On launch, the store logo is displayed, and you are taken to the home screen.

```
WELCOME to the PIZZA STORE
1. New Order
0. Exit
```

From the order screen, you can:

| Option | Action                                            |
|--------|---------------------------------------------------|
| `1`    | Build a custom pizza from scratch                 |
| `2`    | Choose and optionally customise a signature pizza |
| `3`    | Add a drink (choose name and size)                |
| `4`    | Add Garlic Knots                                  |
| `5`    | View and manage your cart                         |
| `6`    | Proceed to checkout                               |
| `0`    | Cancel the order                                  |
 
---

-----
## Technologies Used

- **Java** — core application language
- **OOP principles** — inheritance, polymorphism, and encapsulation throughout
- **Scanner** — console input handling
- **File I/O** — receipt persistence via `Receipt.java`

-----

## License 📄

This project was built as a learning exercise, free using.
