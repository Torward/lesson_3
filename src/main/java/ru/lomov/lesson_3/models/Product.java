package ru.lomov.lesson_3.models;

public class Product {

    private String title;
    private Long id;
    private int price;

    public Product() {
    }

    public Product(String title, Long id, int price) {
        this.title = title;
        this.id = id;
        this.price = price;
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "title='" + title + '\'' +
                ", id=" + id +
                ", cost=" + price +
                '}';
    }
}
