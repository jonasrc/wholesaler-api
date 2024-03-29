package com.atividade.wholesaler.service;

import com.atividade.wholesaler.domain.Budget;
import com.atividade.wholesaler.domain.OrderItem;
import com.atividade.wholesaler.domain.Product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

public interface BudgetService {

    public List<Budget> getList();

    public Budget getById(String id);

    public Budget create(List<OrderItem> orderItemList, String orderId);

    public String updateAcceptance(String id, String acceptance) throws IOException, URISyntaxException;
}
