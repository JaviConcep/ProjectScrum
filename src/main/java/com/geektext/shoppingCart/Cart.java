//This represents each individual's ID their shopping cart
package com.geektext.shoppingCart;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    //Constructors
    public Cart(){}

    public Cart(Long userId){
        this.userId = userId;
    }

    //Getters and Setters
    public Long getId(){
        return id;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }
}
