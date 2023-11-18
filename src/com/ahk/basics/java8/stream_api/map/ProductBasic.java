package com.ahk.basics.java8.stream_api.map;

public class ProductBasic {

    private String name;
    private String availability;
    private int price;

    public ProductBasic() {

    }

    public ProductBasic(String name, String availability, int price) {
        this.name = name;
        this.availability = availability;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ProductBasic{" +
                "name='" + name + '\'' +
                ", availability='" + availability + '\'' +
                ", price=" + price +
                '}';
    }
}
