package ru.lomov.lesson_3.models;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String title;
    private Long id;
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
