package com.atividade.wholesaler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;

    private String status;

    private List<Product> productList;

    private Date creationDate;

    public Order(String status, List<Product> productList) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.productList = new ArrayList<>();
        this.productList = productList;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
