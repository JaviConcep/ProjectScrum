package com.geektext.service;

import com.geektext.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book getBookById(Long bookId) {
        return new Book(bookId, "Sample Book", "Sample Author", "Fiction", true);
    }
}