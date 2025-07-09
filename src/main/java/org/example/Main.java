package org.example;

import java.util.*;

public class Main {
    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

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
                case 1 -> System.out.println(viewInventory());
                case 2 -> {
                    System.out.print("Enter Product Name: ");
                    String prodName = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int prodQuantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println(addProduct(prodName, prodQuantity));
                }
                case 3 -> {
                    System.out.print("Enter Product Name to Check: ");
                    String prodCheck = sc.nextLine();
                    System.out.println(checkProduct(prodCheck));
                }
                case 4 -> {
                    System.out.print("Enter Product Name to Update: ");
                    String prodUpdate = sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int prodQuantityUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.println(updateProduct(prodUpdate, prodQuantityUpdate));
                }
                case 5 -> {
                    System.out.print("Enter Product Name to Remove: ");
                    String prodRemove = sc.nextLine();
                    System.out.println(removeProduct(prodRemove));
                }
                case 6 -> {
                    System.out.println("Exiting system...");
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static String viewInventory() {
        if (map.isEmpty()) return "No Products Yet.";
        StringBuilder sb = new StringBuilder("=== Current Inventory ===\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return sb.toString().trim();
    }

    public static String addProduct(String prodName, int prodQuantity) {
        if (prodName == null || prodName.isBlank()) return "Invalid product name.";
        if (prodQuantity < 0) return "Quantity cannot be negative.";
        map.put(prodName, prodQuantity);
        return "Product added: " + prodName + " (" + prodQuantity + ")";
    }

    public static String checkProduct(String prodCheck) {
        if (map.containsKey(prodCheck)) {
            return prodCheck + " is in stock: " + map.get(prodCheck);
        }
        return "Product not found.";
    }

    public static String updateProduct(String prodUpdate, int prodQuantityUpdate) {
        if (!map.containsKey(prodUpdate)) return "Product not found.";
        if (prodQuantityUpdate < 0) return "Invalid quantity.";
        map.put(prodUpdate, prodQuantityUpdate);
        return "Stock updated: " + prodUpdate + " (" + prodQuantityUpdate + ")";
    }

    public static String removeProduct(String prodRemove) {
        if (map.containsKey(prodRemove)) {
            map.remove(prodRemove);
            return "Product removed: " + prodRemove;
        }
        return "Product not found.";
    }

    public static void resetInventory() {
        map.clear();
    }
}
