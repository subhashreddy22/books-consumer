package com.books.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private Long id;

    private String name;

    private String author;

    private Double rating;
}
