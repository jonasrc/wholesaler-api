package com.atividade.wholesaler.rest.implementation;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;
import com.atividade.wholesaler.rest.OrderController;
import com.atividade.wholesaler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/")
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    @GetMapping("/health-check")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok().body("It's alive!");
    }

    @Override
    @GetMapping("/order")
    public ResponseEntity<List<Order>> getList() {
        return ResponseEntity.ok().body(orderService.getList());
    }

    @Override
    @PostMapping("/order")
    public ResponseEntity<Order> create(String data){
//        Order order = orderService.create(status, productList);
//        return ResponseEntity.created(URI.create(order.getId())).body(order);
        int a = 1;
        return ResponseEntity.ok().body(null);
    }
}
