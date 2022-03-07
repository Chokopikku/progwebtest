package com.example.progwebtest;

import java.sql.*;

public class InventoryDB {
    public static Inventory inventory = new Inventory();
    private static Connection con;

    public static void getInventory() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/progwebtest", "root", "admin1234");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select p.name, i.itemId, i.quantity from inventory i join product p on i.itemId = p.itemId;");
            while (rs.next()) {
                inventory.createItem(rs.getString(1), rs.getString(2));
                for (int i = 0; i <= rs.getInt(3); i++) {
                    inventory.increaseQuantity(rs.getString(2));
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createItem(String name, String itemId) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/progwebtest", "root", "admin1234");
            String query = "insert into inventory values (?, ?);";
            ps = con.prepareStatement(query);
            ps.setString(1, itemId);
            ps.setInt(2, 0);
            ps.executeUpdate();

            query = "insert into product values (?, ?);";
            ps = con.prepareStatement(query);
            ps.setString(1, itemId);
            ps.setString(2, name);
            ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating new product.");
        }
    }

    public static void main(String[] args) {
        createItem("Prod11", "#11");
        createItem("Prod12", "#12");
        getInventory();
        System.out.println(inventory.toString());
    }
}
