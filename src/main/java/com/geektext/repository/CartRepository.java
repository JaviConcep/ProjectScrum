//Retrieves the cart that belongs to the userId
package com.geektext.repository;

import com.geektext.shoppingCart.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long>{
    List<Cart> findByUserId(Long userID);
}
