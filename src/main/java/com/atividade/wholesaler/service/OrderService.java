package com.atividade.wholesaler.service;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;
import org.json.JSONObject;

import java.util.List;

public interface OrderService {
    public List<Order> getList();

    public Order getById(String id);

    public String create(String retailerApiData);
}
