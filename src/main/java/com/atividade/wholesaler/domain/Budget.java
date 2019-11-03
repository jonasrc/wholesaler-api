package com.atividade.wholesaler.domain;

import java.util.Date;
import java.util.UUID;

public class Budget {
    private String id;

    private String orderId;

    private Double value;

    private Date deliveryDate;

    private String acceptance;

    private Date creationDate;

    public Budget(String orderId, Double value, Date deliveryDate, String acceptance) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.value = value;
        this.deliveryDate = deliveryDate;
        this.acceptance = acceptance;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
