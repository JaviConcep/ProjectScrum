//Retrieves the items for each cart
package com.geektext.repository;

import com.geektext.shoppingCart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    List<CartItem> findByCartId(Long cartId);
}
