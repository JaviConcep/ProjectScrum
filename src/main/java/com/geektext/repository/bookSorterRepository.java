package com.geektext.repository;

import com.geektext.model.bookSorter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface bookSorterRepository extends JpaRepository<bookSorter, Long> {

    List<bookSorter> findByGenre(String genre);

    List<bookSorter> findTop10ByOrderBySalesDesc();

    List<bookSorter> findByRatingGreaterThanEqual(double rating);

    List<bookSorter> findByPublisher(String publisher);
}
