package com.geektext.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookSorter")
public class bookSorter{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;

  @Column(name = "title", nullable = false)
  private String title;
  
  @Column(name = "author", nullable = false)
  private String author;
  
  @Column(name = "genre", nullable = false)
  private String genre;

  @Column(name = "price", nullable = false)
  private double price;
  
  @Column(name = "rating", nullable = false)
  private double rating;

  @Column(name = "sales", nullable = false)
  private int sales;
  
  @Column(name = "publisher", nullable = false)
  private String publisher;

  public bookSort(){}
  
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
