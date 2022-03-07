package com.example.progwebtest;

import java.sql.*;
import static com.example.progwebtest.Provider.*;

public class ConnectionProvider {
    private static Connection con;

    static {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}
