package com.example.progwebtest;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void createItem(String name, String itemId) {
        products.add(new Product(name, itemId));
    }

    public void increaseQuantity(String itemId) {
        for (Product product : products) {
            if (product.getItemId().equals(itemId))
                product.add();
        }
    }

    public void decreaseQuantity(String itemId) {
        for (Product product : products) {
            if (product.getItemId().equals(itemId))
                product.remove();
        }
    }

    @Override
    public String toString() {
        String str = "Items: \n";
        for (Product product : products) {
            str += product.toString() + "\n";
        }
        return str;
    }

    public String existingItems() {
        String str = "Existing items: \n";
        for (Product product : products) {
            if (product.getQuantity() > 0)
                str += product.toString() + "\n";
        }
        return str;
    }

    public void printInventory() {
        System.out.println(toString());
    }

    public void printInventoryExistingItems() {
        System.out.println(existingItems());
    }
}
