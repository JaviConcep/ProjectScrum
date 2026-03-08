package com.geektext.repository;




import com.geektext.model.WishlistBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WishlistBookRepository
        extends JpaRepository<WishlistBook, Long> {

    List<WishlistBook> findByWishlistId(Long wishlistId);

}