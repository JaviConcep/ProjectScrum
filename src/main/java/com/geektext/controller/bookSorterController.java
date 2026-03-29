
package com.geektext.controller;

import com.geektext.model.bookSorter;
import com.geektext.repository.bookSorterRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController

public class bookSorterController{

  private final bookSorterRepository repository;

  public bookSorterController(bookSorterRepository repository){
    this.repository = repository;
  }

  
  public bookSorter getBooksByGenre(){
    
  }

  @GetMapping("/books/top10")
  public bookSorter getBooksBySales(){
    return repository.findTop10ByOrderBySalesDesc();
  }
  
}
