package com.example.magicofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.magicofbooks.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
