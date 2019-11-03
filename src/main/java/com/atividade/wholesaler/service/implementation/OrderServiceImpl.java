package com.atividade.wholesaler.service.implementation;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;
import com.atividade.wholesaler.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private List<Order> orderList = new ArrayList<>();

    @Override
    public Order create(String status, List<Product> productList) {
        Order order = new Order(status, productList);
        this.orderList.add(order);
        return order;
    }

    @Override
    public List<Order> getList() {
        return this.orderList;
    }

    @Override
    public Order getById(String id) {
        Order order = orderList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(order == null){
            throw new NoSuchElementException("Order not found.");
        }

        return order;
    }
}
