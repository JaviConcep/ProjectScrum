
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


}
