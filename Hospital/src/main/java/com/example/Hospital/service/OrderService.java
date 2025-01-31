package com.example.Hospital.service;

import com.example.Hospital.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    void updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
