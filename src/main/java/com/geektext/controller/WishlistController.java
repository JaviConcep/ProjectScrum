
package com.geektext.controller;

import com.geektext.model.Wishlist;

import com.geektext.model.WishlistBook;

import com.geektext.repository.WishlistRepository;
import com.geektext.repository.WishlistBookRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    private final WishlistRepository wishlistRepository;
    private final WishlistBookRepository wishlistBookRepository ;

    public WishlistController(WishlistRepository wishlistRepository,
                              WishlistBookRepository wishlistBookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.wishlistBookRepository = wishlistBookRepository;

    }

    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll() ;
    }

    @GetMapping("/{id}/books")
    public List<WishlistBook> getBooksInWishlist(@PathVariable Long id) {

        return wishlistBookRepository.findByWishlistId(id);
    }

    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @PostMapping("/{wishlistId}/books")
    public WishlistBook addBookToWishlist(@PathVariable Long wishlistId,
                                          @RequestBody WishlistBook wishlistBook) {

        if (!wishlistRepository.existsById(wishlistId)) {
            throw new RuntimeException("Wishlist not found");
        }

        WishlistBook existing =
                wishlistBookRepository.findByWishlistIdAndBookId(wishlistId, wishlistBook.getBookId());

        if (existing != null) {
            return existing;
        }

        wishlistBook.setWishlistId(wishlistId);
        return wishlistBookRepository.save(wishlistBook);
    }

@DeleteMapping("/{wishlistId}/books/{bookId}")
public void removeBookFromWishlist(@PathVariable Long wishlistId,
                                   @PathVariable Long bookId) {

    WishlistBook wb =
        wishlistBookRepository.findByWishlistIdAndBookId(wishlistId, bookId);

    if (wb != null) {
        wishlistBookRepository.delete(wb);
    }
}

    @DeleteMapping("/{id}")
    public void deleteWishlist(@PathVariable Long id) {
        wishlistBookRepository.deleteByWishlistId(id);
        wishlistRepository.deleteById(id);
    }
}
