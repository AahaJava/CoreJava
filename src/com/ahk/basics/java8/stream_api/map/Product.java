package com.ahk.basics.java8.stream_api.map;

public class Product {

    private int id;
    private String name;
    private String rate;
    private String availability;
    private int price;

    public Product() {

    }

    public Product(int id, String name, String rate, String availability, int price) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.availability = availability;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate='" + rate + '\'' +
                ", availability='" + availability + '\'' +
                ", price=" + price +
                '}';
    }
}
