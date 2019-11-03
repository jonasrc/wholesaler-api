package com.atividade.wholesaler.service.implementation;

import com.atividade.wholesaler.domain.Product;
import com.atividade.wholesaler.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private static List<Product> productList;

    public ProductServiceImpl() {
        productList = new ArrayList<>();
        productList.add(new Product("PC Gamer 3Green", 101L, 7000d));
        productList.add(new Product("Moda de luxo boné de hip hop", 202L, 133.26d));
        productList.add(new Product("FIFA 2021 PS4", 303L, 14532d));
    }

    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        Product product = productList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(product == null){
            throw new NoSuchElementException("Product not found.");
        }

        return product;
    }

    @Override
    public Product getByCode(Long code) {
        Product product = productList.stream().filter(element -> element.getCode().equals(code)).findAny().orElse(null);

        if(product == null){
            throw new NoSuchElementException("Product not found.");
        }

        return product;
    }
}
