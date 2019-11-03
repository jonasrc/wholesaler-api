package com.atividade.wholesaler.domain;

import java.util.UUID;

public class Product {
    private String id;

    private String name;

    private Long code;

    private Double value;

    public Product(String name, Long code, Double value) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
