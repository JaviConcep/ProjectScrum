package com.geektext.controller;

import com.geektext.model.BookRating;
import com.geektext.repository.BookRatingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class BookRatingController {

    private final BookRatingRepository repository;

    // This connects the controller to your database repository
    public BookRatingController(BookRatingRepository repository) {
        this.repository = repository;
    }

    // Action: Create a rating/comment
    @PostMapping("/add")
    public BookRating addRating(@RequestBody BookRating rating) {
        return repository.save(rating);
    }

    // Action: Retrieve all comments for a specific book
    @GetMapping("/book/{bookId}")
    public List<BookRating> getByBook(@PathVariable Long bookId) {
        return repository.findByBookId(bookId);
    }

    // Action: Get the average rating for a book
    @GetMapping("/average/{bookId}")
    public Double getAverage(@PathVariable Long bookId) {
        return repository.getAverageRating(bookId);
    }
}