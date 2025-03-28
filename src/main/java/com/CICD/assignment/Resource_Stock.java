package com.CICD.assignment;


public class Resource_Stock {
    private Long id;
    private String name;
    private int quantity;

    public Resource_Stock() {
       
    }
    // Constructor with name and quantity
    public Resource_Stock(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
