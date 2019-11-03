package com.atividade.wholesaler.domain;

import java.util.Date;
import java.util.UUID;

public class Budget {
    private String id;

    private Double value;

    private Date deliveryDate;

    private Date creationDate;

    public Budget(Double value, Date deliveryDate) {
        this.id = UUID.randomUUID().toString();
        this.deliveryDate = deliveryDate;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
