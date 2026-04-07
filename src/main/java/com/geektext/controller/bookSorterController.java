
package com.geektext.controller;

import com.geektext.model.bookSorter;
import com.geektext.repository.bookSorterRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/books")
public class bookSorterController{
    private final bookSorterRepository repository;

    public bookSorterController(bookSorterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/genre")
    public List<bookSorter> getBooksByGenre(@RequestParam String genre) {
        return repository.findByGenre(genre);
    }

    @GetMapping("/top10")
    public List<bookSorter> getBooksBySales() {
        return repository.findTop10ByOrderBySalesDesc();
    }

    @GetMapping("/rating")
    public List<bookSorter> getBooksByRating(@RequestParam double rating) {
        return repository.findByRatingGreaterThanEqual(rating);
    }

    @PatchMapping("/discount")
    public void applyDiscount(@RequestParam String publisher, @RequestParam double discountPercent) {
        List<bookSorter> books = repository.findByPublisher(publisher);
        for (bookSorter book : books) {
            book.setPrice(book.getPrice() * (1 - discountPercent / 100));
        }
        repository.saveAll(books);
    }
}
