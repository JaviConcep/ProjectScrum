package com.geektext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")

public class Wishlist
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId ;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_primary")
    private boolean isPrimary;

    //Constructors
    public Wishlist() {}

    public Wishlist(Long userId, String name, boolean isPrimary) {
        this.userId = userId;
        this.name = name;
        this.isPrimary = isPrimary;
    }


    // getters and Setters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public boolean isPrimary() { return isPrimary; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setPrimary(boolean primary) { isPrimary = primary; }


}
