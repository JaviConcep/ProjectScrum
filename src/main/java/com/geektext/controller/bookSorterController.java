
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

  
  public BookSorter getBooksByGenre(){
    
  }
  
}
