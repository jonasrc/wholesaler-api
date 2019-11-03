package com.atividade.wholesaler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;

    private String status;

    private List<OrderItem> orderItemList;

    private Date creationDate;

    public Order(String status, List<OrderItem> orderItemList) {
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.orderItemList = new ArrayList<>();
        this.orderItemList = orderItemList;
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

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setProductList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
