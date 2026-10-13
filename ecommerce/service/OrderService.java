package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductService productService;

    public Order saveOrder(Order order) {

        // Save the order
        Order savedOrder = repository.save(order);

        // Reduce stock for each purchased product
        if (order.getProductIds() != null) {

            for (Long productId : order.getProductIds()) {

                productService.reduceStock(productId);

            }

        }

        return savedOrder;

    }

    public List<Order> getAllOrders() {

        return repository.findAll();

    }

    public Order getOrderById(Long id) {

        return repository.findById(id)
                .orElse(null);

    }

}