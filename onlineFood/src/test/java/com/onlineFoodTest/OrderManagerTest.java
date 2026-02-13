package com.onlineFoodTest;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.onlineFood.Order;
import com.onlineFood.OrderDao;
import com.onlineFood.OrderManager;

class OrderManagerTest {

    
    @Test
    void testGetAllOrders() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderManager manager = new OrderManager(mockDao);

        when(mockDao.fetchAllOrders())
                .thenReturn(Arrays.asList(
                        new Order(1, "Dominos", "Pizza", 500)));

        List<Order> orders = manager.getAllOrders();

        assertEquals(1, orders.size());
        verify(mockDao).fetchAllOrders();
    }

    
    @Test
    void testAddOrder() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderManager manager = new OrderManager(mockDao);

        Order order = new Order(1, "KFC", "Burger", 200);

        when(mockDao.addOrder(order)).thenReturn(true);

        boolean result = manager.addOrder(order);

        assertTrue(result);
        verify(mockDao).addOrder(order);
        verify(mockDao).logAction("Order Placed");
    }

    
    @Test
    void testCancelOrder() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderManager manager = new OrderManager(mockDao);

        when(mockDao.cancelOrder(1)).thenReturn(true);

        boolean result = manager.cancelOrder(1);

        assertTrue(result);
        verify(mockDao).cancelOrder(1);
        verify(mockDao).logAction("Order Cancelled");
    }

    
    @Test
    void testStaticDiscount() {
        double result = OrderManager.calculateDiscount(1000);
        assertEquals(900, result);
    }

    
    @Test
    void testFinalMethod() {
        OrderDao dao = new OrderDao();
        assertEquals("Connected to MySQL DB", dao.getDatabaseInfo());
    }

    
    @Test
    void testVoidMethod() {
        OrderDao mockDao = mock(OrderDao.class);
        doNothing().when(mockDao).logAction(anyString());

        mockDao.logAction("Order Placed");

        verify(mockDao).logAction("Order Placed");
    }

   
    @Test
    void testProcessOrderFestivalOffer() {
        OrderDao mockDao = mock(OrderDao.class);
        OrderManager manager = Mockito.spy(new OrderManager(mockDao));

        Order order = new Order(1, "Pizza Hut", "Veg Pizza", 1000);

        doReturn("Festival Offer").when(manager).internalOfferLogic();

        double finalPrice = manager.processOrder(order);

        assertEquals(800, finalPrice); 
    }
}
