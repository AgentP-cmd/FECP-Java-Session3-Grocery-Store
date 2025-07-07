package org.example;
import java.util.*;

public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        while (isRunning) {
            System.out.println("\n=== Grocery Inventory Menu ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose an Option (1-6): ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> viewInventory(map);
                case 2 -> addProduct(sc,map);
                case 3 -> checkProduct(sc, map);
                case 4 -> updateProduct(sc, map);
                case 5 -> removeProduct(sc, map);
                case 6 -> {
                    System.out.println("Exiting system...");
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
            }
        }
    private static void viewInventory(Map<String, Integer> map) {
       if (map.isEmpty()){
           System.out.println("No Products Yet.");
       }else {
           System.out.println("=== Current Inventory ===");
           for (Map.Entry<String, Integer> entry : map.entrySet()){
               System.out.println(entry.getKey() + " - " + entry.getValue());
           }
       }
    }

    private static void addProduct(Scanner sc, Map<String, Integer> map) {
        System.out.print("Enter Product Name: ");
        String prodName = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int prodQuantity = sc.nextInt();

        map.put(prodName, prodQuantity);
        System.out.println("Product Added!");


    }

    private static void checkProduct(Scanner sc, Map<String, Integer> map) {
        System.out.print("Enter Product name to check: ");
        String prodCheck = sc.nextLine();
        if (map.containsKey(prodCheck)){
            Integer result = map.get(prodCheck);
            System.out.println(prodCheck + " is in stock:" + result );
        } else {
            System.out.println("That product does not exist!");
        }
    }

    private static void updateProduct(Scanner sc, Map<String, Integer> map) {
        System.out.print("Enter Product name to update: ");
        String prodUpdate = sc.nextLine();
        if (map.containsKey(prodUpdate)){
            System.out.print("Enter new stock quantity: ");
            int prodQuantityUpdate = sc.nextInt();
            map.put(prodUpdate,prodQuantityUpdate);
            System.out.println("Stock Updated!");
        }

    }

    private static void removeProduct(Scanner sc, Map<String, Integer> map) {
        System.out.print("Enter Product name to remove: ");
        String prodRemove = sc.nextLine();
        if (map.containsKey(prodRemove)){
            map.remove(prodRemove);
            System.out.println("Product Removed.");
        } else {
            System.out.println("Product does not exist!");
        }


    }

}
