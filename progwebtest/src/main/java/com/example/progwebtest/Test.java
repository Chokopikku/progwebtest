package com.example.progwebtest;

public class Test {

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.createItem("Prod1", "#1");
        inv.createItem("Prod2", "#2");
        inv.createItem("Prod3", "#3");
        inv.createItem("Prod4", "#4");
        inv.increaseQuantity("#1");
        inv.increaseQuantity("#2");
        inv.increaseQuantity("#2");
        inv.printInventory();
        inv.printInventoryExistingItems();
    }
}
