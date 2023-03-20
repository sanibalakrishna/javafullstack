package com.example.magicofbooks.model;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getAuthor() {
        return this.author;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setAuthor(String author2) {
        this.author = author2;
    }

    public void setPrice(Double price2) {
        this.price = price2;
    }

    public Long getId() {
        return this.id;
    }

    // getters and setters
}
