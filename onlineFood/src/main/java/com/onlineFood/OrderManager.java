package com.onlineFood;


import java.util.List;

public class OrderManager {

    private OrderDao orderDao;

    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

  
    public List<Order> getAllOrders() {
        return orderDao.fetchAllOrders();
    }

   
    public boolean addOrder(Order order) {
        orderDao.logAction("Order Placed");
        return orderDao.addOrder(order);
    }

   
    public boolean cancelOrder(int orderId) {
        orderDao.logAction("Order Cancelled");
        return orderDao.cancelOrder(orderId);
    }

    
    public double processOrder(Order order) {
        String offer = internalOfferLogic();

        if ("Festival Offer".equals(offer)) {
            return order.getPrice() * 0.8;  
        } else {
            return order.getPrice() * 0.9;  
        }
    }

   
    public String internalOfferLogic() {
        return "Regular";
    }

  
    public static double calculateDiscount(double price) {
        return price * 0.9;
    }
}

