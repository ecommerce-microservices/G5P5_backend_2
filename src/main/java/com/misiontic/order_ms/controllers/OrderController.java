package com.misiontic.order_ms.controllers;

import com.misiontic.order_ms.models.Order;
import com.misiontic.order_ms.repositories.OrderRepository;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders/{id}")
    Order getOrder(@PathVariable String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la orden"));
    }

    @PostMapping("/orders")
    Order newOrder(@RequestBody Order order) {
        order.setDate(new Date());
        return orderRepository.save(order);
    }

    @GetMapping("/orders")
    List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
