package com.geektext.model;

import jakarta.persistence.*;


@Entity
@Table(name = "wishlist_books")
public class WishlistBook {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wishlist_id", nullable = false)
    private Long wishlistId;

    @Column(name = "book_id", nullable = false)
    private Long bookId ;

    public WishlistBook() {}

    public WishlistBook(Long wishlistId, Long bookId) {
        this.wishlistId = wishlistId;
        this.bookId = bookId;

    }

    public Long getId() { return id; }

    public Long getWishlistId() { return wishlistId; }
    public void setWishlistId(Long wishlistId) { this.wishlistId = wishlistId; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }



}
