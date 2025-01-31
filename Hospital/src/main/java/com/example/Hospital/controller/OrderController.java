package com.example.Hospital.controller;

import com.example.Hospital.entity.Order;
import com.example.Hospital.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private OrderServiceImpl orderServiceImpl;

    @Autowired
    public  OrderController(OrderServiceImpl orderServiceImpl){
        this.orderServiceImpl=orderServiceImpl;
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder  = orderServiceImpl.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            orderServiceImpl.deleteOrder(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/modifyOrder/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long id,@RequestBody Order order) {
        orderServiceImpl.updateOrder(id,order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/selectOrder/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = orderServiceImpl.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }


}
