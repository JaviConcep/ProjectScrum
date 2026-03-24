package com.geektext.model;

import jakarta.persistence.*;

public class bookSorter{

  private Long bookId;

  private String title;

  private String author;

  private String genre;

  private double price;

  private double rating;

  private int sales;

  private String publisher;

  public bookSort(Long bookId, String title, String author, String genre, double price, double rating, int sales, String publisher){
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.price = price;
    this.rating = rating;
    this.sales = sales;
    this.publisher = publisher.
  }


  public getGenre {
   return genre;
  }
  public getPrice {
    return price;
  }
  public getRating{
    return rating;
  }
  public getSales;{
    return sales;
  }

  public setPrice (double price){
    this.price = price;
  }
  
}
