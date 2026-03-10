package com.geektext.repository;

import com.geektext.model.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRatingRepository extends JpaRepository<BookRating, Long> {
    List<BookRating> findByBookId(Long bookId);

    @Query("SELECT AVG(r.rating) FROM BookRating r WHERE r.bookId = ?1")
    Double getAverageRating(Long bookId);
}