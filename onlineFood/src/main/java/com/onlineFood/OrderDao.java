package com.onlineFood;


import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Order> fetchAllOrders() {
        return new ArrayList<>();
    }

    public boolean addOrder(Order order) {
        return true;
    }

    public boolean cancelOrder(int orderId) {
        return true;
    }

    public final String getDatabaseInfo() {
        return "Connected to MySQL DB";
    }

    public void logAction(String message) {
        System.out.println("LOG: " + message);
    }
}
