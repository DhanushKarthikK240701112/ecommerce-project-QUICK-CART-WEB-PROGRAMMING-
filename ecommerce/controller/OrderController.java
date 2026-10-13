package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        System.out.println("Product IDs: " + order.getProductIds());

        return orderService.saveOrder(order);

    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @PutMapping("/{id}")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestBody Order order) {

        Order existingOrder = orderService.getOrderById(id);

        existingOrder.setStatus(order.getStatus());

        return orderService.saveOrder(existingOrder);
    }
    
}