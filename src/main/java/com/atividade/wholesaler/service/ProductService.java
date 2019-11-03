package com.atividade.wholesaler.service;

import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getList();

    public Product getById(String id);

    public Product getByCode(Long code);
}
