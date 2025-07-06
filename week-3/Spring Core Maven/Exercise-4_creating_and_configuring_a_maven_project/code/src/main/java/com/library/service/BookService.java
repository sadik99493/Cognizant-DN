package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookRepository injected into BookService");
        this.bookRepository = bookRepository;
    }

    public void listBooks() {
        System.out.println("BookService: Calling BookRepository...");
        bookRepository.fetchBooks();
    }
}
