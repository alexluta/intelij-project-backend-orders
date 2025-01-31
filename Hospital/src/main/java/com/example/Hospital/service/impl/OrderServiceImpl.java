package com.example.Hospital.service.impl;

import com.example.Hospital.entity.Order;
import com.example.Hospital.repository.OrderRepository;
import com.example.Hospital.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        }
        return orderOptional.orElseThrow(()-> new RuntimeException("No such Order"));
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(!orderOptional.isPresent()) {
            throw new RuntimeException("No such Medic");
        }else {
            Order order1 = orderOptional.get();
            order1.setItem(order.getItem());
            order1.setPrice(order.getPrice());
            orderRepository.save(order1);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(!orderOptional.isPresent()) {
            throw new RuntimeException("No such Order");
        }
        orderRepository.deleteById(id);
    }
}
