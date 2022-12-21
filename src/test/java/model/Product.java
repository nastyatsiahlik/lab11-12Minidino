package model;

import java.util.Objects;

public class Product {
    private String name;
    private String price;
    private String url;

    public Product(String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String price) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equals(product.getName()) && price.equals(product.getPrice()) && url.equals(product.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getUrl());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + name + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
