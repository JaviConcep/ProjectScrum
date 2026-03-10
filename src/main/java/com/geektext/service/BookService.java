package com.geektext.service;

import com.geektext.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book getBookById(Long id) {
        return new Book(id, "Sample Book", "Sample Author", "Fiction", true);
    }
}