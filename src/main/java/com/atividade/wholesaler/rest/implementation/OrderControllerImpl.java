package com.atividade.wholesaler.rest.implementation;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;
import com.atividade.wholesaler.rest.OrderController;
import com.atividade.wholesaler.service.OrderService;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public ResponseEntity<String> create(String data){
        return ResponseEntity.ok().body(orderService.create(data));
    }
}
