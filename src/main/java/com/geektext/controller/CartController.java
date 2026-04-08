package com.geektext.controller;

import com.geektext.shoppingCart.Cart;
import com.geektext.shoppingCart.CartItem;
import com.geektext.repository.CartRepository;
import com.geektext.repository.CartItemRepository;

import com.geektext.model.Book;
import com.geektext.service.BookService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    //Added book details feature to find book prices
    private final BookService bookService;

    public CartController(CartRepository cartRepository, CartItemRepository cartItemRepository, BookService bookService){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.bookService = bookService;
    }


    @GetMapping
    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    //This retrieves all the items within a user's cart
    @GetMapping("/user/{userId}/items")
    public List<CartItem> getItemsByUser(@PathVariable Long userId){
        List<Cart> carts = cartRepository.findByUserId(userId);
        if(carts.isEmpty()) return List.of();

        Cart cart = carts.get(0);
        return cartItemRepository.findByCartId(cart.getId());

    }

    //This adds a book to the user's cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId, @RequestParam Long bookId){
        List<Cart> carts = cartRepository.findByUserId(userId);
        Cart cart;

        //This creates a cart if it did not exist
        if(carts.isEmpty()){
            cart = new Cart(userId);
            cartRepository.save(cart);
        }
        else{
            cart = carts.get(0);
        }

        List<CartItem> items = cartItemRepository.findByCartId(cart.getId());

        //This checks if a book is already in a shopping cart
        //If it does already exist, it increases the quantity of the book by 1
        for(CartItem item : items){
            if(item.getBookId().equals(bookId)){
                item.setQuantity(item.getQuantity() + 1);
                return cartItemRepository.save(item);
            }
        }

        //This adds the book into the cart if it did not already exist
        CartItem newItem = new CartItem(cart.getId(), bookId, 1);
        return cartItemRepository.save(newItem);
    }

    //This deletes books from the user's cart
    @DeleteMapping("/remove")
    public void removeFromCart(@RequestParam Long userId, @RequestParam Long bookId){
        List<Cart> carts = cartRepository.findByUserId(userId);
        if(carts.isEmpty()) return;

        Cart cart = carts.get(0);
        List<CartItem> items = cartItemRepository.findByCartId(cart.getId());

        //This deletes the quantity of books within a user's cart
        for(CartItem item : items){
            if(item.getBookId().equals(bookId)){
                //This reduces the quantity of a book within the cart if there is more than 1
                if(item.getQuantity() > 1){
                    item.setQuantity(item.getQuantity() - 1);
                    cartItemRepository.save(item);
                }
                //This removes the book completely from the cart if there was only 1
                else{
                    cartItemRepository.deleteById(item.getId());
                }

                break;
            }
        }
    }

    //This calculates the subtotal of all the books within a user's cart
    @GetMapping("/user/{userId}/subtotal")
    public double getSubtotal(@PathVariable Long userId){
        List<Cart> carts = cartRepository.findByUserId(userId);
        if(carts.isEmpty()) return 0;

        Cart cart = carts.get(0);
        List<CartItem> items = cartItemRepository.findByCartId(cart.getId());

        double total = 0;
        //This checks every book within the user's cart and multiplies its quantity by its price
        for(CartItem item : items){
            //Using book details feature to find book prices
            try{
                Book book = bookService.getBookById(item.getBookId());
                total += item.getQuantity() * book.getBookPrice();
            }
            catch(RuntimeException e){
                //Skips if a book is not found
            }
        }

        return total;
    }


}