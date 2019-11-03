package com.atividade.wholesaler.service;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;

import java.util.List;

public interface OrderService {
    public Order create(String status, List<Product> productList);

    public List<Order> getList();

    public Order getById(String id);
}
