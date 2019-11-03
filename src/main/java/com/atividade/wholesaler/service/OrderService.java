package com.atividade.wholesaler.service;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface OrderService {
    public List<Order> getList();

    public Order getById(String id);

    public String create(String retailerApiData);

    public String getStatus(Integer type);

    public void updateStatus(String id, String status) throws IOException, URISyntaxException;
}
