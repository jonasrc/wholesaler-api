package com.atividade.wholesaler.domain;

public class OrderItem {
    private Product product;

    private Long quantity;

    private String notes;

    public OrderItem(Product product, Long quantity, String notes) {
        this.product = product;
        this.quantity = quantity;
        this.notes = notes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
