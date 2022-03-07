package com.example.progwebtest;

public class Product {
    private String name;
    private String itemId;
    private int quantity;

    public Product(String name, String itemId) {
        this.name = name;
        this.itemId = itemId;
        quantity = 0;
    }

    public void add() {
        quantity++;
    }

    public void remove() {
        quantity--;
    }

    public String getName() {
        return name;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
