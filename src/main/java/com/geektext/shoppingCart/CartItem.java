//This represents the items within the shopping cart
package com.geektext.shoppingCart;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private int quantity;

    //Constructors
    public CartItem(){}

    public CartItem(Long cartId, Long bookId, int quantity){
        this.cartId = cartId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    //Getters and Setters

    public Long getId(){
        return id;
    }

    public Long getCartId(){
        return cartId;
    }

    public Long getBookId(){
        return bookId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setCartId(Long cartId){
        this.cartId = cartId;
    }

    public void setBookId(Long bookId){
        this.bookId = bookId;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
