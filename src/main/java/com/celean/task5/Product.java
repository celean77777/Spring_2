package com.celean.task5;

public class Product {
    private int id;
    private String productName;
    private String cost;

    public Product(int id, String productName, String cost) {
        this.id = id;
        this.productName = productName;
        this.cost = cost;
    }

    public int getId(){
        return id;
    }

    public Product() {
    }

    @Override
    public String toString(){
        return "id: " + id + "\n"
        + "ProductName: " + productName + "\n"
        + "Cost: " + cost + "\n";
    }
}
